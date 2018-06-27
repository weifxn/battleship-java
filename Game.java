/*
Todo: 
- Add ships 
- Fix error handling for input other than int

Changelog:

26/6 14:38 wf
- Added '0' to exit/go menu
- changed choice to array

Fix: 
- infinite loop when string at menu

*/
import java.util.Scanner;


public class Game {
	// variables
	private String[] rowCol = { "row", "column" };
	// classes
	private Screen screen; 
	private Input input;
	private Grid grid;
	private Player player;

	// constants or menu options
	private static final int START = 1;
	private static final int QUIT = 2;
	
	public Game() {
		screen = new Screen();
		input = new Input();
		grid = new Grid();
		player = new Player();

	}

	public void run() 
	{
		for (int quit = 0; quit < 1; quit--) {
			quit = gameMenu();
		}
	}
	private int gameMenu() {	
		while (true) {
			int choice = displayMenu();
			switch ( choice )
			{
				case START:
					
					startGame();
					return 0;
				case QUIT:
					return 2;
			}
			return 0;
		}
	}

	private int setDifficulty() {
		screen.displayMessageLine( "\nDifficulty" );
		screen.displayMessageLine( "1. Start" );
		screen.displayMessageLine( "2. Quit" );
		screen.displayMessageLine( "\nEnter a choice: " );
		return input.getInput();
	}

	private int displayMenu() {
		screen.displayMessageLine( "\nBattleship" );
		screen.displayMessageLine( "1. Start" );
		screen.displayMessageLine( "2. Quit" );
		screen.displayMessageLine( "\nEnter a choice: " );
		return input.getInput();
	}

	private void startGame() {
		for (int exit = 0; exit < 1; exit--) {
			grid.displayGrid();
			int[] choice = getUserChoice();
			exit = checkExit(choice); // if return 2 will exit loop
			// clearScreen();
		}
	}
	// get user choice
    private int[] getUserChoice() {
		int[] choice = {-1,-1};
		for (int i = 0; i < 2; i++) {
			System.out.printf( "Enter %s: ", rowCol[i] );
			choice[i] = input.getInput();
			if (choice[i] == 0) { // 0 to exit
				i = 2; // 2 will exit loop
			}
		}	
		return choice;
	} 

	private int checkExit(int[] choice) {
		for (int i = 0; i < 2; i++) {
			if (choice[i] == 0) {
				return 2;
			}
		}
		return 0;

	}

	
	// public static void clearScreen() {  
	// 	System.out.print("\033[H\033[2J");  
	// 	System.out.flush();  
    // }
}
