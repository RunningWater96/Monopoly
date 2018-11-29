package game;

import java.io.IOException;
import enumeration.Token;
import dependancy.*;


public class Game {

	public int turn;
	public int countPlayers;
	public Player[] players;
	Die die = new Die();
	
	/**
	 * Initialize the game by assigning names, tokens and initial balance.
	 * @param totalPlayers insert the number of player
	 */
	private void init(int totalPlayers) throws IOException {
		players = new Player[totalPlayers];
		for (int i = 0; i < players.length; i++) {
			String playerName = ConsoleUI.promptForInput("Enter player " + (i + 1) + "'s name", false);
			
			System.out.println("\nOk " + players[i].name + ", is time to choose your token.");
			Token selection = chooseYourToken();
			players[i].balance = 1500;
			
			//Finish interaction with players[i]
			if(players.length == totalPlayers) {
				System.out.println("Thank you " + players[i].name + ".");
			}
			else {
				System.out.println("Thank you " + players[i].name + ". Now let me ask your friend.");
			}
			Player newPlayer = new Player(playerName, selection);
			players[i] = newPlayer;
		}
	}
	
	/**
	 * Without a while loop to only run the game once. Later on we can comment them back to let the game keep running.
	 * Might need a little fix after one game is played
	 */
	public void run() throws IOException {
		//boolean keepRunning = true;
		//while (keepRunning) {
			System.out.println("Welcome to Monopoly!");
			int action = printMainMenu();
			takeAction(action);
		//	keepRunning = takeAction(action);
		//}
	}

	/**
	 * Handles the selection from the user
	 * @param action the selection from user of the main menu
	 * @return if the game needs to keepRunning or not
	 */
	private boolean takeAction(int action) throws IOException {
		switch (action) {
		case 0:
			speedDieRules();
			break;
		case 1:
			classicMonopolyRules();
			break;
		case 2:
			return false;
		default:
			throw new IllegalArgumentException("Invalid action " + action);
		}
		return true;
	}
	
	/**
	 * After selection this method through the main menu, it will play this version of monopoly
	 */
	private void classicMonopolyRules() throws IOException {

		System.out.println("Welcome to Monopoly\nClassic Rules");
		int howManyPlayers = ConsoleUI.promptForInt("First, let's get started by having a count of the players.\n"
				+ "Remember that the minimun is 2 and maximun is  6", 2, 6);
		init(howManyPlayers);
		
		

		
	}

	public void turn(Player p) {
		boolean isYourTurn = true;
		System.out.println("\nAlright " + p.getToken() + ", you;re up.");
		while(isYourTurn) {
			
		}
	}
	
	private void movePlayer(int num, Player player) {
		checkForGo(player);
	}
	
	
	private void checkForGo(Player player) {
		if(player.location == 0) {
			player.addMoney(200);
		}
		
	}

	private void speedDieRules() {
		System.out.println("inside speed die rules");
	}

	/**
	 * By using switch to let user choose which token they want.
	 * @return what token user wants to get;
	 */
	private Token chooseYourToken() throws IOException {
		Token selection = null;
		int desireToken = printTokenSelection();
		switch (desireToken) {
		case 0:
			selection = Token.BATTLESHIP;
			break;
		case 1:
			selection = Token.CAR;
			break;
		case 2:
			selection = Token.CAT;
			break;
		case 3:
			selection = Token.DOG;
			break;
		case 4:
			selection = Token.HAT;
			break;
		case 5:
			selection = Token.SHOE;
			break;
		case 6:
			selection = Token.THIMBLE;
			break;
		case 7:
			selection = Token.WHEELBARROW;
			break;
		default:
			throw new IllegalArgumentException("Invalid selection " + desireToken);
		}
		return selection;
	}
	
	/**
	 * Prints the options of tokens
	 * @return the selection from the options presented
	 */
	private int printTokenSelection() throws IOException {
		String[] options = new String[8];
		options[0] = Token.BATTLESHIP.toString();
		options[1] = Token.CAR.toString();
		options[2] = Token.CAT.toString();
		options[3] = Token.DOG.toString();
		options[4] = Token.HAT.toString();
		options[5] = Token.SHOE.toString();
		options[6] = Token.THIMBLE.toString();
		options[7] = Token.WHEELBARROW.toString();
		return ConsoleUI.promptForMenuSelection(options);
	}
	
	/**
	 * Prints the options for the main menu
	 * @return 
	 */
	private int printMainMenu() throws IOException {
		String[] menuOptions = new String[3];
		menuOptions[0] = "Speed Die Rules";
		menuOptions[1] = "Classic Monopoly Rules";
		menuOptions[2] = "Exit";
		return ConsoleUI.promptForMenuSelection(menuOptions);
	}

	private int printTurnMenu() throws IOException {
		String[] menuOptions = new String[2];
		menuOptions[0] = "Roll dice";
		menuOptions[1] = "See balance";
		return ConsoleUI.promptForMenuSelection(menuOptions);
		
	}
}
