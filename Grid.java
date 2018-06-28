import java.util.Arrays;
import java.util.Random;

// Board consists of 20 rows x 60 columns
public class Grid {
	private final int rows = 20;
	private final int columns = 60;

	private String[][] grid = new String[rows][columns];
	private String[][] show = new String[rows][columns];
	private String gridDisplay = "";
	private String entityDisplay = "";

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
		show = grid;
		populateShip();
		populatePotion();
		populateTrap();	
	}
	
	public void populateTrap() { 
		int trapno = 10;
		int count = 0;
		while (count < trapno) {
			int row = rand.nextInt(19);
			int col = rand.nextInt(59);
			
			if (show[row][col] == "#") {
				show[row][col] = "%";
				
			}
			else {
				count-=1;
			}
			count++;
		}

	}
	
	public void populatePotion() {
		int potionno = 18;
		int count = 0;
		while (count<potionno) {
			int row = rand.nextInt(19);
			int col = rand.nextInt(59);
			
			if(show[row][col] == "#") {
				show[row][col] = "$";
				
			}
			else {
				count-=1;
			}
			count++;
		}
	}
	
	public void populateShip() {
		
		
		int shipno = 80;
		int count = 0;
		while (count < shipno) {
			int  row = rand.nextInt(19);
			int  col = rand.nextInt(59);
			boolean gotShip = false;

			int length =  rand.nextInt(3) + 3;
			if (col < 54) {
				for (int i = col; i < col + (length + 1); i++){
					if (show[row][i] == ">") {
						gotShip = true;
					}
				}// after length + 1
				if (col > 0 ){
					if (show[row][col-1] == ">") {
						gotShip = true;
					}
				}
				if(!gotShip) {
					for (int i = col; i < col + length; i++){
						show[row][i] = ">";
					}
				}
			}
			else {
				for (int i = col; i > col - (length + 1) ; i--){
					if (show[row][i] == ">") {
						gotShip = true;
					}
				}// before length + 1
				if (col < 59){
					if (show[row][col+1] == ">") {
						gotShip = true;
					}
				}
				if (!gotShip){
					for (int i = col; i > col - length ; i--){
						show[row][i] = ">";
					}
				}
				
			}
			count++;
			if (gotShip) {
				gotShip = false;
				count -=1;
			}
		}
	}

	public void displayGrid() {
		gridDisplay = ""; //reset display
		for (int a = 1; a <= 6; a++) {
			for (int b = 1; b <=9; b++) {
				gridDisplay += " ";   //for space
			}
			gridDisplay += a;
		}
			gridDisplay += ("\n");
			gridDisplay+="     ";
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
			gridDisplay += (i+1) + "    ";
			for (int j = 0; j < grid[i].length; j++) {
				
				
				gridDisplay += grid[i][j];
			}
			gridDisplay += ("\n");
		
	
		}
		screen.displayMessageLine(gridDisplay);
		
		
	}

	public void displayEntity() {
		entityDisplay = "";
		for (int i = 0; i < show.length; i++) {
			for (int j = 0; j < show[i].length; j++) {
				entityDisplay += show[i][j];
			}
			entityDisplay += "\n";
		}
		screen.displayMessageLine(entityDisplay);
	}

	
	
	public String checkEntity(int[] choice) {
		String entity=show[choice[0]-1][choice[1]-1];
		return entity;
	}
	
	
}
