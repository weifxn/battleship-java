/*
Todo: 
- Display board
- Add ships 
- 
Changelog:
-

*/
import java.util.Scanner;
import java.util.InputMismatchException;


public class Game {
	public static void main(String[] args) {
		int choice = 1;
		while (choice > 0) {
			Grid b1 = new Grid();
			System.out.println(b1.displayBoard());
			choice = getUserChoice();
			clearScreen();
		}


	}
	// get user choice
    private static int getUserChoice() {
		int choice = -1;
		while (choice < 0) {
			try {
				Scanner input = new Scanner( System.in );
				System.out.println( "Enter row: " );
				choice = input.nextInt();
				System.out.println( "Enter column: " );
				choice = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter integer");
				
			}
		}
		
		return choice;
	} 

	
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	   
    }
}
