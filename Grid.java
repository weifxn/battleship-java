import java.util.Arrays;

// Board consists of 20 rows x 60 columns
public class Grid {
	private static final int rows = 20;
	private static final int columns = 60;

	private String grid[][] = new String[rows][columns];
	private String gridDisplay = "";

	private Screen screen = new Screen();

	// Board Constructor


	public void populateGrid() {
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = "#";
			}
		}
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
	
}
