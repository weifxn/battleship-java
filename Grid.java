import java.util.Arrays;
import java.util.Random;

// Board consists of 20 rows x 60 columns
public class Grid {
	private final int rows = 20;
	private final int columns = 60;

	private String[][] grid = new String[rows][columns];
	private String[][] map = new String[rows][columns];
	private String gridDisplay = "";
	private String mapDisplay = "";

	private Screen screen = new Screen();
	Random rand = new Random();

	Player player = new Player();

	Ship ship = new Ship(player);
	Trap trap = new Trap(player);
	Potion potion = new Potion(player);

	public void populateGrid() {
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = "#";
			}
		}
	}

	public void populateMap() { // random {19,59}
		map = grid;
		ship.populate(map);
		potion.populate(map);
		trap.populate(map);	
	}
	

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
		mapDisplay = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				mapDisplay += map[i][j];
			}
			mapDisplay += "\n";
		}
		screen.displayMessageLine(mapDisplay);
	}

	
	
	public String checkEntity(int[] choice) {
		String entity=map[choice[0]-1][choice[1]-1];
		return entity;
	}
	
	
}
