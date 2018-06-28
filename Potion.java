public class Potion extends Entity {
    public Potion( Player player ) {
        super(player);
    }

    @Override
    public void execute() {
    	System.out.println("You hit Potion!");
        
    }
}