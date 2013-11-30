package user;
import game.*;


public interface Player {
	public boolean continuePreviousRoll(Greed greed);
	
	public boolean passDice(Greed greed);
	
	public int chooseRollIndex(java.util.List<PairDiceScore> scoreList);
}
