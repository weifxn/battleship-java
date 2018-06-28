import java.util.Random;

public class Trap extends Entity {
    public Trap( Player player ) {
        super(player);
    }

    @Override
    public void execute() {
    	Player player = new Player();
    	String highlow = "";
    	Random rand = new Random();
    	int dangerlevel=rand.nextInt(2);
    	if (dangerlevel==0) {
    		highlow = "low";
    		player.reduceLives();
    		System.out.println(player.getLives());
    	}
    	else {
    		highlow = "high";
    		player.reduceLives();
    		player.reduceLives();
    		System.out.println(player.getLives());
    	}
    	
    	System.out.println("You hit " + highlow + " Trap!");
    }
    
    
}