package game;

import user.Player;

public interface Greed {
	
	int getCurrentRoundNumber();
	int getRoundsLeft();
	
	int getNumberOfPlayers();
	int getPlayerPostion(Player p);
	int getPlayerScore(Player p);
	int[] getScoreboard();
	
	void addPlayerListener(Player p);
	
	int getDiceScore();
}
