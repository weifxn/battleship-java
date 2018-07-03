import java.util.Random;
public class Potion extends Entity {
    public Potion( Player player, Grid grid ) {
		super(player,grid);
    }

    @Override
    public void execute() {
		Player player = getPlayer();
		Grid grid = getGrid();
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
			grid.revealShip();
    	}
    	else if (potionlvl == 2) {
			potiontype = "reveal trap";
			grid.revealTrap();
    	}
    
    	System.out.println("You hit " + potiontype + " Potion!");

    }

    @Override
    public void populate() {
        Random rand = new Random();
		Player player = getPlayer();
		Grid grid = getGrid();
		int[][] map = grid.getMap();
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
	}
}