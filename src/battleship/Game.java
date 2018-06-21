/*
Todo: 
[x] Display board
[] Add ships 
Changelog:

*/
import java.util.Scanner;


public class Game {
	public static void main(String[] args) {
		int choice = 1;
		while (choice > 0) {
			Board b1 = new Board();
			System.out.println(b1.displayBoard());
			choice = getUserChoice();
			clearConsole();
		}


	}
	// get user choice
    private static int getUserChoice() {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter location to boom (row, col): " );
        return input.nextInt();
	} 
	
	public final static void clearConsole() {
    try {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            Runtime.getRuntime().exec("cls");
        }
        else {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)  {
        
    }
}

}
