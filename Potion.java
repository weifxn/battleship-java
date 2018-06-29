import java.util.Random;
public class Potion extends Entity {
    public Potion( Player player ) {
        super(player);
    }

    @Override
    public void execute() {
    	System.out.println("You hit Potion!");
        
    }

    public void populate( String[][] map ) {
        Random rand = new Random();
		int potionno = 18;
		int count = 0;
		while (count<potionno) {
			int row = rand.nextInt(19);
			int col = rand.nextInt(59);
			
			if(map[row][col] == "#") {
				map[row][col] = "$";
				
			}
			else {
				count-=1;
			}
			count++;
		}
	}
}