package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Override
	public int getCurrentDiceScore() {
		return 0;
	}
}
