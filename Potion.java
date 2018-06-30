import java.util.Random;
public class Potion extends Entity {
    public Potion( Player player ) {
        super(player);
    }

    @Override
    public int[][] execute( int[][] map ) {
    	System.out.println("You hit Potion!");
		
		return map;
    }

    @Override
    public int[][] populate( int[][] map ) {
        Random rand = new Random();
        Player player = getPlayer();
		int potionno = player.getPotions();
		int count = 0;
		while (count<potionno) {
			int row = rand.nextInt(19);
			int col = rand.nextInt(59);
			
			if(map[row][col] == 0) {
				map[row][col] = 3;
				
			}
			else {
				count-=1;
			}
			count++;
        }
        return map;
	}
}