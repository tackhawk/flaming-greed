package user;

import java.util.List;

import game.Greed;
import game.PairDiceScore;

public class NeverRollAgain implements Player {
	@Override
	public boolean continuePreviousRoll(Greed greed) {
		return false;
	}

	@Override
	public boolean passDice(Greed greed) {
		return false;
	}

	@Override
	public int chooseRollIndex(List<PairDiceScore> scoreList) {
		return 0;
	}

}
