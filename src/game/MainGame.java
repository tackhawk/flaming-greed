package game;

import java.util.List;
import java.util.Scanner;

public class MainGame {
	public enum GreedType { GREED_DEFAULT }

	public static void main(String[] args) {
		
		System.out.println("WELCOME TO GREED SELECTOR\n---------------------");
		for(GreedType gT : GreedType.values()) {
			int index = 0;
			System.out.println(index +" : " + gT);
		}
		
		Scanner scan = new Scanner(System.in);
		String userIn = scan.nextLine();
		System.out.println();
		
		Greed game = getGreedGame(Integer.parseInt(userIn));
		
		System.out.print("How many players? ");
		userIn = scan.nextLine();
		int numPlayers = Integer.parseInt(userIn);
		
//		List<Players> playerList = generatePlayers(numPlayers);
		
		System.out.print("How many rounds? ");
		userIn = scan.nextLine();
		Integer.parseInt(userIn);
		
		game.runGame();
	}

	public static Greed getGreedGame(int gIndex) {
		GreedType gType = GreedType.values()[gIndex];
		
		switch(gType) {
			case GREED_DEFAULT:
				return new GreedGame(null);
			default :
				System.out.println("Input not recognized: using default");
				return new GreedGame(null);
		}
	}
}
