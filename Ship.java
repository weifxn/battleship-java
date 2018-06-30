import java.util.Random;
public class Ship extends Entity {
    
    public Ship( Player player ) {
        super(player);
    }

    @Override
    public int[][] execute( int[][] map ) {
    	System.out.println("You found the Ship!");
        return map;
    }

    @Override
    public int[][] populate( int[][] map ) {
		Random rand = new Random();
        Player player = getPlayer();
		for (int count = 0; count < player.getShips(); count++) {
			int  row = rand.nextInt(20);
			int  col = rand.nextInt(60);
			boolean gotShip = false;

            int length =  rand.nextInt(3) + 3;
            
            // row 0 and col 60 wont have ship
            // fix this
			if (col < 54 && col > 0) {
                if (map[row][col+(length+1)] == 0) {
                 
                    for (int i = col; i < col + length; i++){
						map[row][i] = 1;
					}
                }
			}
			else if (col > 53 && col < 59) {
                if(map[row][col-(length+1)] == 0
                && map[row][col+1] == 0){
                    for (int i = col; i > col - length ; i--){
						map[row][i] = 1;
					}
				}
            }
            else {
                count--;
            }
        }
        return map;
	}
}