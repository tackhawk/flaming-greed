package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import user.NeverRollAgain;
import user.Player;

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
		
		int gameSelection = Integer.parseInt(userIn);
		
		
		
		System.out.print("How many players? ");
		userIn = scan.nextLine();
		int numPlayers = Integer.parseInt(userIn);
		
		List<Player> playerList = generatePlayers(numPlayers);
		Greed game = getGreedGame(gameSelection, playerList);
		
		System.out.print("How many rounds? ");
		userIn = scan.nextLine();
		Integer.parseInt(userIn);
		
		game.runGame();
	}

	private static List<Player> generatePlayers(int numPlayers) {
		List<Player> listToReturn = new ArrayList<Player>();
		
		for (int i=0; i<numPlayers; i++) {
			listToReturn.add(new NeverRollAgain());
		}
		
		return listToReturn;
	}

	public static Greed getGreedGame(int gIndex, List<Player> playerList) {
		GreedType gType = GreedType.values()[gIndex];
		
		switch(gType) {
			case GREED_DEFAULT:
				return new GreedGame(playerList);
			default :
				System.out.println("Input not recognized: using default");
				return new GreedGame(playerList);
		}
	}
}
