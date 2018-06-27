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
import java.util.InputMismatchException;


public class Game {
	private Screen screen; 
	private Input input;
	private Grid grid;

	// constants or menu options
	private static final int START = 1;
	private static final int QUIT = 2;
	
	public Game() {
		screen = new Screen();
		input = new Input();
		grid = new Grid();

	}

	public void run() 
	{
		while (true) {
			gameMenu();
		}
		

	}
	private void gameMenu() {
		Scanner input = new Scanner( System.in );
		for (int quit = 0; quit < 1; quit--) {
			try {
				
				int choice = displayMenu();
				if (choice == 1) {
					startGame();
				}
			}
			catch (InputMismatchException e) {
			}
		}
	}

	private int displayMenu() {
		screen.displayMessageLine( "\n Battleship" );
		screen.displayMessageLine( " 1. Start" );
		screen.displayMessageLine( " 2. Quit" );
		screen.displayMessageLine( "\n Enter a choice: " );
		return input.getInput();


	}

	private static void startGame() {
		for (int exit = 0; exit < 1; exit--) {
			screen.displayMessageLine(grid.displayBoard());
			int[] choice = getUserChoice();
			exit = checkExit(choice);
			// clearScreen();
		}
	}
	// get user choice
    private static int[] getUserChoice() {
		String[] rowCol = { "row", "column" };
		Scanner input = new Scanner( System.in );
		int[] choice = {-1,-1};
		for (int i = 0; i < 2; i++) {
			try {
				System.out.printf( "Enter %s: ", rowCol[i] );
				choice[i] = input.nextInt();
				if (choice[i] == 0) {
					i = 2; // 0 to exit
				}
			}
			catch (InputMismatchException e) {
				i = 2;
				// System.out.println("Please enter integer");
				
			}
		}	
		return choice;
	} 

	private static int checkExit(int[] choice) {
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
