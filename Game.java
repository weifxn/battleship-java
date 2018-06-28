/*
Todo: 
- Add ships (should be 2D int array of one row and multiple col)
- Add traps (should be 2D array of int)
- Add potions (should be 2D array of int)
- these 3 should affect grid.java
- Add inheritance for trap, potion and ship (@override execute)
- Superclass is Grid.java? Randomize position method
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

	// grid entities
	private static final int BLANK = 0;
	private static final int SHIP = 1;
	private static final int TRAP = 2;
	private static final int POTION = 3;

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
		grid.populateGrid();
		grid.populateEntity();
		for (int quit = 0; quit < 1; quit--) {
			quit = gameMenu();
		}
	}
	private int gameMenu() {	
		while (true) {
			int choice = menu.menu();
			switch ( choice )
			{
				case START:
					while (!diff) {
						// set difficulty to player class
						player.setDifficulty(getDifficulty(menu.difficulty()));
						diff = true;
					}
					startGame();
					return 0;
				case QUIT:
					return 2;
			}
			return 0;
		}
	}

	private void startGame() {
		Entity en = null;
		for (int exit = 0; exit < 1; exit--) {
			grid.displayGrid();
			grid.displayEntity();
			int[] choice = input.getGameInput();
			exit = checkExit(choice); // if return 2 will exit loop
			System.out.println(grid.checkEntity(choice));
			
			// en = selectedEntity(grid.checkHit(choice));
			player.addSteps();
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
	
	// blank, ship, trap, potion
	private Entity selectedEntity( int type ) {
		Entity en = null;

		switch ( type ) {
			case SHIP:
				en = new Ship(player);
				break;
			case TRAP:
				en = new Trap(player);
				break;
			case POTION:
				en = new Potion(player);
				break;
			case BLANK:
				
		}

		return en;


	}

	
	// public static void clearScreen() {  
	// 	System.out.print("\033[H\033[2J");  
	// 	System.out.flush();  
    // }
}
