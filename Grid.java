import java.util.Arrays;
import java.util.Random;

// Board consists of 20 rows x 60 columns
public class Grid {
	private final int rows = 20;
	private final int columns = 60;

	private String[][] grid = new String[rows][columns];
	private int[][] map = new int[rows][columns];
	private String gridDisplay = "";
	private String mapDisplay = "";

	private Screen screen = new Screen();
	Random rand = new Random();




	// grid entities
	private static final int BLANK = 0;
	private static final int SHIP = 1;
	private static final int TRAP = 2;
	private static final int POTION = 3;

	public void populateGrid() {
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = "#";
			}
		}
	}

	public void populateMap(Player player) { // random {19,59}
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				map[i][j] = 0;
			}
		}
		Entity currentEntity = null;
		int[] temp = {1,1};
		for (int i=1;i<=3;i++){
			currentEntity=selectedEntity(temp, i, player);
			map = currentEntity.populate(map);
		}
	}
	// getter
	public int[][] getMap() {
		return map;
	}

	//setter 
	public void updateGrid() {
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				if(map[i][j] == BLANK-4) {
					grid[i][j] = " ";
				}
				else if(map[i][j] == SHIP-4) {
					grid[i][j] = "O";
				}
				else if(map[i][j] == TRAP-4) {
					grid[i][j] = "O";
				}
				else if(map[i][j] == POTION-4) {
					grid[i][j] = "O";
				}

			}
		}
	}


	// for display

	public void displayGrid() {
		gridDisplay = "    "; //reset display
		// first row
		for (int a = 1; a <= 6; a++) {
			for (int b = 1; b <=9; b++) {
				gridDisplay += " ";   //for space
			}
			gridDisplay += a;
		}
			gridDisplay += ("\n");
			gridDisplay+="    ";
		// second row
		for (int a=1;a<=6;a++) {
			for (int b=1; b<=10;b++) {
				if (b==10) {
					gridDisplay += (b-10); 
				}else {
					gridDisplay += b;
				}
			}
		}
		
		gridDisplay += ("\n");
		
		for (int i = 0; i < grid.length; i++) {
			if(i < 9) {
				gridDisplay += (i+1) + "   ";
			} else {
				gridDisplay += (i+1) + "  ";
			}
			for (int j = 0; j < grid[i].length; j++) {
				gridDisplay += grid[i][j];
			}
			gridDisplay += ("\n");
		}
		screen.displayMessageLine(gridDisplay);
		
		
	}

	public void displayMap() {
		mapDisplay = "    "; //reset display
		// first row
		for (int a = 1; a <= 6; a++) {
			for (int b = 1; b <=9; b++) {
				mapDisplay += " ";   //for space
			}
			mapDisplay += a;
		}
			mapDisplay += ("\n");
			mapDisplay+="    ";
		// second row
		for (int a=1;a<=6;a++) {
			for (int b=1; b<=10;b++) {
				if (b==10) {
					mapDisplay += (b-10); 
				}else {
					mapDisplay += b;
				}
			}
			
		}
		
		mapDisplay += ("\n");
		for (int i = 0; i < map.length; i++) {
			if(i < 9) {
				mapDisplay += (i+1) + "   ";
			} else {
				mapDisplay += (i+1) + "  ";
			}
			for (int j = 0; j < map[i].length; j++) {
				mapDisplay += Integer.toString(map[i][j]);
			}
			mapDisplay += "\n";
		}
		screen.displayMessageLine(mapDisplay);
	}

	
	
	

	public Entity selectedEntity( int[] choice, int type, Player player ) {
		Entity en = null;

		switch ( type ) {
			case POTION:
				setEntity(choice, type-4);
				en = new Potion(player);
				break;
			case TRAP:
				setEntity(choice, type-4);
				en = new Trap(player);
				break;
			case SHIP:
				setEntity(choice, type-4);
				en = new Ship(player);
				break;
			case BLANK:
				setEntity(choice, type-4);
				break;
			
		}

		return en;
	}

	public void getWholeShip(int[] choice) {

		
	}


	public int getEntity(int[] choice) {
		int entity=map[choice[0]-1][choice[1]-1];
		return entity;
	}

	private void setEntity(int[] choice, int entity) {
		map[choice[0]-1][choice[1]-1] = entity;
	}
	
	
}
