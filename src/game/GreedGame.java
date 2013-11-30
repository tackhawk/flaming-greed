package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.*;

public class GreedGame implements Greed {
	private List<Player> players;
	private int totalRounds;
	private int roundNumber;
	private int totalDice;
	
	private int[] scoreboard;
	
	private int[] diceRolled;
	
	GreedGame() {
		// Set number of dice
		// Set limit
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
	public void setPlayers(List<Player> pList) {
		players = new ArrayList<Player>(pList);
	}
	
	@Override
	public int[] getScoreboard() {
		return Arrays.copyOf(scoreboard, scoreboard.length);
	}

	@Override
	public void runGame() {
		scoreboard = new int[getNumberOfPlayers()];
		
	}
	
	private void rollDice() {
		
	}
	
	public void printScores() {
		for (int i =0; i<scoreboard.length; i++) {
			System.out.println(players.get(i) + "  " + scoreboard[i]);
		}
	}
	
	// Returns diceRemaining (key) and scores (value) associated, returns empty map if no score
	@Override
	public List<PairDiceScore> getCurrentDiceScore(int[] diceRolled) {
		
		List<PairDiceScore> possibleScores = new ArrayList<PairDiceScore>();
		int score = 0;
		int diceUsed = 0;
		int [] diceCount = new int[6];
		
		//Initializing array to contain the dice count
		for( int i=1; i<=6; i++ ) {
			diceCount[i-1] = 0;
		}
		
		//Evaluating the number of straights possible to use
		int straightCount = diceCount[0];
		
		for( int i=1; i<=6; i++) {
			straightCount = ( straightCount > diceCount[i-1] ) ? diceCount[i-1] :  straightCount;
		}
		
		//Evaluating scores for each valid number of straights
		for( int i=0; i<=straightCount; i++) {
			score = 0;
			diceUsed = 0;
			for( int j=1; j<=6; j++ ) {
				if (i != 1 && i != 5 ) {
					score += ((diceCount[i-1] - straightCount) / 3) * i * 100;
					diceUsed += ((diceCount[i-1] - straightCount) / 3);
				} else if ( i==1 ) {
					score += ((diceCount[i-1] - straightCount) / 3) * i * 1000;
					score += ((diceCount[i-1] - straightCount) % 3) * 100;				
					diceUsed += (diceCount[i-1] - straightCount);
				} else if ( i==5 ) {
					score += ((diceCount[i-1] - straightCount) / 3) * i * 1500;
					score += ((diceCount[i-1] - straightCount) % 3) * 50;
					diceUsed += (diceCount[i-1] - straightCount);
				}
			}
			score += straightCount * 1000;
			diceUsed += straightCount * 6;
			
			if( score != 0 ) {
				possibleScores.add(new PairDiceScore(diceUsed, score));
			}
		}
		
		return possibleScores;
	}
}
