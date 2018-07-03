// blank, ship, trap, potion
public abstract class Entity {
 
    private Player player;
    private Grid grid;

    public Entity ( Player player, Grid grid ) {
        this.player = player;
        this.grid = grid;
    }

    public Player getPlayer() {
        return player;
    }

    public Grid getGrid() {
        return grid;
    }

    abstract public void execute();
    abstract public void populate();
} 