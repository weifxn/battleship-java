/*
Todo: 
- add win/lose mechanics:
	- add highscore with fileIO methods 

- not that necessary: 
	- Remove entity class? use grid as superclass to reduce redundancy (good for class diagram)


Changelog:
26/6 wf
- Added '0' to exit/go menu
- changed choice to array

27/6 wf
- Fixed error handling for input other than int (in Input.java)
- Done with difficulty

28/6 wf
- Added inheritance for trap, potion and ship (@override execute)
- Superclass is Grid.java? Randomize position method
- Added methods for row column (choice[] in startgame)

29/6 wf
- add parameter to populate map
- add restriction to user hitting the same tile again. checkHit() method to check if tile number is < 0.

3/7 wf
- entity progress:
	[x] ship
	[x] potion
	[x] trap
	- add potion function. Reveal whole ship can use getWholeShip() method


Fix: 

*/
import java.util.*;
import java.io.FileNotFoundException;
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
		grid.populateGrid();
		
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
						int diffLevel = menu.difficulty();
						if (diffLevel > 0 && diffLevel < 4) {
							diff = true;
							player.setDifficulty(getDifficulty(diffLevel));
						} else {
							diff = false;
						}
					}
					grid.populateMap(player,grid);
					startGame();
					return 0;
				case QUIT:
					return 2;
			}
			return 0;
		}
	}

	private void startGame() {
		Entity currentEntity = null;
		for (int exit = 0; exit < 1; exit--) {
			grid.displayGrid();
			grid.displayMap();
			player.displayStats();
			int[] choice = input.getGameInput();
			exit = checkExit(choice); // if return 2 will exit loop
			if (exit != 2){
				currentEntity=grid.selectedEntity(choice, grid.getEntity(choice), player,grid);
				if(currentEntity != null){ 
					currentEntity.execute();
				}
			}
			exit = player.checkLose(exit);
			exit = player.checkWin(exit);
			
			
			if (exit == 3) {
				grid.populateGrid();
				diff = false;
			}
			else if (exit == 4) {
				System.out.println("Congratulations!Please enter your name:");
				storeName();
				grid.populateGrid();
				diff = false;
			}
			// clearScreen();
			grid.updateGrid();
			player.addSteps(); 
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


	
	private void storeName() {
		Formatter output;
		String name;
		int mark = 0;
		Scanner input = new Scanner(System.in);
		try{
				output = new Formatter("highestscore.txt");
					System.out.print("Enter name:");
					name = input.next();
					System.out.println("Enter mark:");
					mark = input.nextInt();
					Map<String,Integer> hmap = new HashMap<String,Integer>(10);
					hmap.put(name,mark);
					
					Set set = hmap.entrySet();
					Iterator iterator = set.iterator();
					while(iterator.hasNext()) {
						Map.Entry mentry = (Map.Entry)iterator.next();
						System.out.println(name+mark);
						new TreeMap<Integer,String>(Collections.reverseOrder());
					
					}
					
					
					output.format("%s %d\r\n", name, player.getSteps());
					
				if (output!= null){
				output.close();
			}
		} catch (SecurityException se){
			System.out.println("You do not have write access");
		} catch (FileNotFoundException fe){
			System.out.println("Error opening/creating file.");
		}
		
	
	}
		
	
	}	

	// blank, ship, trap, potion
	

	
	// public static void clearScreen() {  
	// 	System.out.print("\033[H\033[2J");  
	// 	System.out.flush();  
    // }

