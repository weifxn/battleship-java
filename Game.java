
import java.io.BufferedReader;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.util.HashMap;
import java.util.*;

import java.io.File;  
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;


public class Game {
	// classes
	private Input input;
	private Grid grid;
	private Player player;
	private Menu menu;
	private Screen screen = new Screen();
	

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
			System.out.println("\n\n\n\n\n\n Battleship\n\n");
			grid.displayGrid();
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
				player.playerReset();
			}
			else if (exit == 4) {
				scoreList();
				grid.populateGrid();
				diff = false;
				player.playerReset();
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

	private void scoreList() {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boolean nextLine = false;
		String name = "";

		Scanner input = new Scanner( System.in );
		

		screen.displayMessageLine("\nPlease enter your name: ");
		name = input.nextLine();
		name += ("\n");
		name += player.getSteps();
		name += ("\n");
		
		 
		try {
			FileOutputStream fout = new FileOutputStream(new File("highscore.txt"), true);
			byte b[] = name.getBytes();
			fout.write(b);
			fout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			FileInputStream fin = new FileInputStream("highscore.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fin));

			String line = " ";
			String value;
			while(line != null){
				line = reader.readLine();
				value = reader.readLine();
				if (line != null && value != null) {
					hmap.put(line,Integer.parseInt(value));
				}
			} 
			SortedSet set = new TreeSet(); 

			screen.displayMessageLine("Here are the top 10 players: ");
		
			
			
			Map<String, Integer> sortedMapDesc = sortByComparator(hmap, true);
			printMap(sortedMapDesc);
			

			fin.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}
	private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	public static void printMap(Map<String, Integer> map)
    {
        for (Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("Name : " + entry.getKey() + " Steps : "+ entry.getValue());
        }
    }
}	
	

	
	

