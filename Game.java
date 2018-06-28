/*
Todo: 
- Add ships 
- Add inheritance for trap, potion and ship (@override execute)
- Add methods for row column (choice[] in startgame)

Changelog:

26/6 wf
- Added '0' to exit/go menu
- changed choice to array

27/6 wf
- Fixed error handling for input other than int (in Input.java)
- Done with difficulty

Fix: 

*/


public class Game {
	// classes
	private Input input;
	private Grid grid;
	private Player player;
	private Menu menu;

	// menu options
	private static final int START = 1;
	private static final int QUIT = 2;
	private final int[][] difficulty = {{80, 10},{50, 20},{20, 30}};

	// boolean
	private boolean diff = false;
	
	public Game() {
		input = new Input();
		grid = new Grid();
		menu = new Menu();
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
			int choice = menu.menu();
			while (!diff) {
				// set difficulty to player class
				player.setDifficulty(getDifficulty(menu.difficulty()));
				System.out.println(player.getShips());
				System.out.println(player.getTraps());
				diff = true;
			}
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

	private void startGame() {
		for (int exit = 0; exit < 1; exit--) {
			grid.displayGrid();
			int[] choice = input.getGameInput();
			exit = checkExit(choice); // if return 2 will exit loop
			// clearScreen();
		}
	}

	private int checkExit(int[] choice) {
		for (int i = 0; i < 2; i++) {
			if (choice[i] == 0) {
				return 2;
			}
		}
		return 0;
	}

	private int[] getDifficulty(int diff) {
        return difficulty[diff-1];
    }

	
	// public static void clearScreen() {  
	// 	System.out.print("\033[H\033[2J");  
	// 	System.out.flush();  
    // }
}
