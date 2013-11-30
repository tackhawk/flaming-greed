package game;

import java.util.Random;

public class Die {
	public static int roll() {
		Random generator = new Random();
		return generator.nextInt(6) + 1;
	}
	
}
