public class Ship extends Entity {
    public Ship( Player player ) {
        super(player);
    }

    @Override
    public void execute() {
    	System.out.println("You found the Ship!");
        
    }
}