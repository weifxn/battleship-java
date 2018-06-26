/*
Todo: 
- Add ships 
- Fix error handling for input other than int

Changelog:

26/6 14:38 wf
- Added '0' to exit/go menu
- changed choice to array

*/
import java.util.Scanner;
import java.util.InputMismatchException;


public class Game {
	public static void main(String[] args) {
		for (int exit = 0; exit < 1; exit--) {
			Grid b1 = new Grid();
			System.out.println(b1.displayBoard());
			int[] choice = getUserChoice();
			exit = checkExit(choice);
			// clearScreen();
		}


	}
	// get user choice
    private static int[] getUserChoice() {
		String[] rowCol = { "row", "column" };
		Scanner input = new Scanner( System.in );
		int[] choice = {0,0};
		for (int i = 0; i < 2; i++) {
			try {
				System.out.printf( "Enter %s: ", rowCol[i] );
				choice[i] = input.nextInt();
				if (choice[i] == 0) {
					i = 2; // 0 to exit
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter integer");
				
			}
		}	
		return choice;
	} 

	private static int checkExit(int[] choice) {
		for (int i = 0; i < 2; i++) {
			if (choice[i] == 0) {
				System.out.println("exit");
				return 2;
			}
		}
		return 0;

	}

	
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	   
    }
}
