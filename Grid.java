import java.util.Arrays;
import java.util.Random;

// Board consists of 20 rows x 60 columns
public class Grid {
	private static final int rows = 20;
	private static final int columns = 60;

	private String grid[][] = new String[rows][columns];
	private String gridDisplay = "";

	//Entities
	private int[][] ship;
	private int[][] potion;
	private int[][] trap;

	private Screen screen = new Screen();
	Random rand = new Random();

	public void populateGrid() {
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = "#";
			}
		}
	}

	public void populateEntity() { // random {19,59}
		int  n = rand.nextInt(50) + 1;
	}

	public void displayGrid() {
		gridDisplay = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				gridDisplay += grid[i][j];
			}
			gridDisplay += "\n";
		}
		screen.displayMessageLine(gridDisplay);
	}

	public int checkHit( int[] choice ) {
		return 0;
	}
	
	
	
}
