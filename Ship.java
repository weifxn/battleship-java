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
    public int[][] populate( int[][] map ) {
		Random rand = new Random();
        Player player = getPlayer();
        
        
        int shipno = player.getShips();
        System.out.println("ship no: "+shipno);
		int count = 0;
		while (count < shipno) {
			int  row = rand.nextInt(20);
			int  col = rand.nextInt(60);
			boolean gotShip = false;

            int length =  rand.nextInt(3) + 3;
            
            // row 0 and col 60 wont have ship
            // fix this
			if (col < 54 && col > 0) {
                if (map[row][col+(length+1)] == 0) {
                    if col > 0
                    map[row][col-1] == 0
                    for (int i = col; i < col + length; i++){
						map[row][i] = 1;
					}
                }
			}
			else if (col > 53 && col < 60) {
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
			count++;
        }
        return map;
	}
}