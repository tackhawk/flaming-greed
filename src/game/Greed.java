package game;

import java.util.List;

import user.Player;

public interface Greed {
	
	int getCurrentRoundNumber();
	
	int getNumberOfPlayers();
	int getPlayerPostion(Player p);
	int getPlayerScore(Player p);
	
	int[] getScoreboard();

//	int getRoundsLeft();
//	boolean isGameOver();
	
	List<PairDiceScore> getCurrentDiceScore(int[] diceRolled);
	
	void runGame();
}
