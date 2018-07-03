import java.util.Random;
public class Potion extends Entity {
    public Potion( Player player ) {
        super(player);
    }

    @Override
    public int[][] execute( int[][] map ) {
    	Player player = getPlayer();
    	String potiontype = "";
    	Random rand = new Random();
    	int potionlvl = rand.nextInt(3);
    	if (potionlvl == 0) {
			potiontype = "lifesaver";
    		player.increaseLives();
    		System.out.println(player.getLives());
    	}
    	else if (potionlvl == 1) {
			potiontype = "reveal ship";
			
			
			;
    		System.out.printf("*&*");
    	
    	}
    	else if (potionlvl == 2) {
    		potiontype = "reveal trap";
    		player.getTraps();
    		System.out.println(player.getTraps());
    	}
    
    	System.out.println("You hit " + potiontype + " Potion!");

		return map;
    }

    @Override
    public int[][] populate( int[][] map ) {
        Random rand = new Random();
        Player player = getPlayer();
		int potionno = player.getPotions();
		int count = 0;
		while (count<potionno) {
			int row = rand.nextInt(20);
			int col = rand.nextInt(60);
			
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