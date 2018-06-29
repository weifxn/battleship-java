import java.util.Random;
public class Ship extends Entity {
    
    public Ship( Player player ) {
        super(player);
    }

    @Override
    public void execute() {
    	System.out.println("You found the Ship!");
        
    }

    @Override
    public void populate( int[][] map ) {
		Random rand = new Random();
		
		int shipno = 80;
		int count = 0;
		while (count < shipno) {
			int  row = rand.nextInt(19);
			int  col = rand.nextInt(59);
			boolean gotShip = false;

			int length =  rand.nextInt(3) + 3;
			if (col < 54) {
				for (int i = col; i < col + (length + 1); i++){
					if (map[row][i] == 1) {
						gotShip = true;
					}
				}// after length + 1
				if (col > 0 ){
					if (map[row][col-1] == 1) {
						gotShip = true;
					}
				}
				if(!gotShip) {
					for (int i = col; i < col + length; i++){
						map[row][i] = 1;
					}
				}
			}
			else {
				for (int i = col; i > col - (length + 1) ; i--){
					if (map[row][i] == 1) {
						gotShip = true;
					}
				}// before length + 1
				if (col < 59){
					if (map[row][col+1] == 1) {
						gotShip = true;
					}
				}
				if (!gotShip){
					for (int i = col; i > col - length ; i--){
						map[row][i] = 1;
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
}