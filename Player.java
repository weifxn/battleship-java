public class Player {
    // same for each difficulty
    private int lives = 15;
    private int potions = 18;
    private int shipBombed = 0;

    // diff for each difficulty
    private int ships;
    private int traps;

    // steps 
    private int steps = 0;

    public void setDifficulty(int[] diff) { // [ships, traps]
        setShips(diff[0]);
        setTraps(diff[1]);
    }

    // Getter
    public int getLives() {
        return lives;
    }
    public int getPotions() {
        return potions;
    }
    public int getShips() {
        return ships;
    }
    public int getTraps() {
        return traps;
    }
    public int getSteps() {
        return steps;
    }
    public int getShipBombed() {
        return shipBombed;
    }

    // Setter
    
    public void setShips(int ships) {
        this.ships = ships;
    }
    public void setTraps(int traps) {
        this.traps = traps;
    }
    public void reduceLives( int count ) {
        for(int i = 0; i < count; i++) {
            lives -= 1;
        }
    }
    public void increaseLives() {
        lives += 1;
    }
    public void addSteps() {
        steps += 1;
    }
    public void increaseShipBombed() {
        shipBombed += 1;
    }

    public void displayStats() {
        System.out.println();
        System.out.println("Lives: " + getLives());
        System.out.println("Steps: " + getSteps());
        System.out.println("Ships bombed: " + getShipBombed());
        System.out.println();

    }

    

}