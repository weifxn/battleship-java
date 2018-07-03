import java.util.Random;

public class Trap extends Entity {
    public Trap( Player player, Grid grid ) {
		super(player,grid);
	}


    @Override
    public void execute() {
    	Player player = getPlayer();
    	String highlow = "";
    	Random rand = new Random();
    	int dangerlevel=rand.nextInt(2);
    	if (dangerlevel==0) {
    		highlow = "low";
    		player.reduceLives(1);
    		System.out.println(player.getLives());
    	}
    	else {
    		highlow = "high";
    		player.reduceLives(2);
    	}
		System.out.println("You hit " + highlow + " Trap!");
		System.out.println("You have "+ player.getLives()+" lives left.");

	}
	
	@Override
	public void populate() { 
		Grid grid = getGrid();
		int[][] map = grid.getMap();
		Random rand = new Random();
		int trapno = 10;
		int count = 0;
		while (count < trapno) {
			int row = rand.nextInt(20);
			int col = rand.nextInt(60);
			
			if (map[row][col] == 0) {
				map[row][col] = 2;
				
			}
			else {
				count-=1;
			}
			count++;
		}

	}
    
    
}