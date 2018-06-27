import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {
    private Scanner input;
    private int checkInput;
    private boolean retry;

    public Input() {
        input = new Scanner( System.in );
        retry = false;
    }

    public int getInput() {
        while (!retry) {
            try {
                checkInput = input.nextInt();
                retry = true;
            }
            catch (InputMismatchException e){
                System.out.print("Please insert integer: ");
                input.next();
            }
        }
        retry = false;
        return checkInput;
    }

    public int[] getGameInput() {
        String[] rowCol = { "row", "column" };
        int[] choice = {-1,-1};
		for (int i = 0; i < 2; i++) {
			System.out.printf( "Enter %s: ", rowCol[i] );
			choice[i] = getInput();
			if (choice[i] == 0) { // 0 to exit
				i = 2; // 2 will exit loop
			}
		}	
		return choice;
    }
}