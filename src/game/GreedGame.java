package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import user.*;

public class GreedGame implements Greed {
	private List<Player> players;
	private int roundNumber;
	private int totalDice;
	private int diceToRoll;
	
	private int[] scoreboard;
	private int maxRounds;
	
	private int currentScore;
	
	GreedGame(List<Player> pList) {
		// Set number of dice
		// Set limit
		players = new ArrayList<Player>(pList);
		totalDice = 10;
		maxRounds = 10;
	}
	
	@Override
	public int getCurrentRoundNumber() {
		return roundNumber;
	}
	
	@Override
	public int getNumberOfPlayers() {
		return players.size();
	}
	@Override
	public int getPlayerPostion(Player p) {
		return players.indexOf(p) + 1;
	}
	
	@Override
	public int getPlayerScore(Player p) {
		int index = players.indexOf(p);
		return scoreboard[index];
	}
	
	@Override
	public int[] getScoreboard() {
		return Arrays.copyOf(scoreboard, scoreboard.length);
	}

	@Override
	public void runGame() {
		scoreboard = new int[getNumberOfPlayers()];
		
		for (roundNumber=0 ; roundNumber < maxRounds; roundNumber++) {
			for (int i=0; i<players.size(); i++) {
				Player currentPlayer = players.get(i);
				System.out.println("Player's turn: " + currentPlayer);
				
				if (currentScore > 0 && !currentPlayer.continuePreviousRoll(this)) {
					currentScore = 0;
					diceToRoll = totalDice;
				}
				
				do {
					List<PairDiceScore> possibleScores = getCurrentDiceScore(rollDice(diceToRoll));
					int scoreIndex = 0;
					
					if (possibleScores.isEmpty()) {
						System.out.println("Player: " + currentPlayer + " was too greedy");
						currentScore = 0;
						diceToRoll = totalDice;
						break;
					} else if (possibleScores.size() > 1) {
						scoreIndex = currentPlayer.chooseRollIndex(new ArrayList<PairDiceScore>(possibleScores));
					}
					
					PairDiceScore chosenScorePair = possibleScores.get(scoreIndex);
					currentScore += chosenScorePair.getScore();
					diceToRoll -= chosenScorePair.getDiceUsed();
					
					if (diceToRoll == 0) {
						diceToRoll = totalDice;
					}
					
					System.out.println("Dice remaining: " + diceToRoll + " | Current Dice Score: " + currentScore);
				} while (!currentPlayer.passDice(this));
				
				scoreboard[i] += currentScore;
			}
		}
	}
	
	private int[] rollDice(int diceToRoll) {
		int[] diceRolled = new int[diceToRoll];
		
		for (int i=0; i<diceToRoll; i++) {
			diceRolled[i] = Die.roll();
		}
		
		return diceRolled;
	}
	
	public void printScores() {
		for (int i =0; i<scoreboard.length; i++) {
			System.out.println(players.get(i) + "  " + scoreboard[i]);
		}
	}
	
	@Override
	public List<PairDiceScore> getCurrentDiceScore(int[] diceRolled) {
		return null;
	}
}
