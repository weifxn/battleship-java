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
    	if (potiontype == "lifesaver") {
    		potionlvl = 1;
    		player.increaseLives();
    		System.out.println(player.getLives());
    	}
    	else if (potiontype == "revealship") {
    		potionlvl = 2;
    		player.getShips();
    		System.out.println(player.getShips());
    	}
    	else if (potiontype == "revealtrap") {
    		potionlvl = 3;
    		player.getTraps();
    		System.out.println(player.getTraps());
    	}
    
    	System.out.println("You hit " + potionlvl + " Potion!");
		System.out.println("You have "+ player.getLives()+" lives left.");

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