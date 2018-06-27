public class Player {
    private int lives;
    private int steps;
    private int ships;

    public Player(int lives, int steps, int ships) {
        setLives(lives);
        setSteps(steps);
        setShips(ships);
    }

    // Getter
    public int getLives() {
        return lives;
    }
    public int getSteps() {
        return steps;
    }
    public int getShips() {
        return ships;
    }

    // Setter
    public void setLives(int lives){
        this.lives = lives;
    }
    public void setSteps(int steps){
        this.steps = steps;
    }
    public void setShips(int ships){
        this.ships = ships;
    }

}