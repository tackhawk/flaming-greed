package user;

import game.Greed;

public class NeverRollAgain implements Player {

	public boolean takePreviousRoll(Greed greed) {
		return false;
	}

	public boolean rollAgain(Greed greed) {
		return false;
	}

}
