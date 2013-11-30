package game;

public class PairDiceScore {

	private int diceUsed;
	private int score;
	
	PairDiceScore(int diceUsed, int score) {
		this.diceUsed = diceUsed;
		this.score = score;
	}
	
	public int getDiceUsed() {
		return diceUsed;
	}
	
	public int getScore() {
		return score;
	}
}
