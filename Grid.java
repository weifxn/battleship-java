import java.util.Arrays;

// Board consists of 20 rows x 60 columns
public class Grid{
	private int rows = 20;
	private int columns = 60;

	private String board[][] = new String[rows][columns];
	private String boardDisplay = "";

	private Screen screen = new Screen();

	// Board Constructor
	public Grid() {

		populateBoard(); 
	}	


	public void populateBoard() {
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				board[i][j] = "#";
			}
		}
	}

	

	public void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boardDisplay += board[i][j];
			}
			boardDisplay += "\n";
		}
		screen.displayMessageLine(boardDisplay);

	}
	
}
