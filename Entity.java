// blank, ship, trap, potion
public abstract class Entity {
 
    private Player player;

    public Entity ( Player player ) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    abstract public void execute();
} 