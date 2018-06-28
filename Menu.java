public class Menu {
    private Input input = new Input();
    private Screen screen = new Screen();

    public int menu() {
		screen.displayMessageLine( "\nBattleship" );
		screen.displayMessageLine( "1. Start" );
		screen.displayMessageLine( "2. Quit" );
		screen.displayMessageLine( "\nEnter a choice: " );
		return input.getInput();
    }
    public int difficulty() {
		screen.displayMessageLine( "\nDifficulty" );
		screen.displayMessageLine( "1. Beginner" );
		screen.displayMessageLine( "2. Intermediate" );
		screen.displayMessageLine( "3. Advanced" );
		screen.displayMessageLine( "\nChoose a difficulty: " );
		return input.getInput();
	}
}