import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {
    private Scanner input;
    private int checkInput;
    private boolean retry;
    private Screen screen = new Screen();

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
                screen.displayMessage("Please insert integer: ");
                input.next();
            }
        }
        retry = false;
        return checkInput;
    }

    public int[] getGameInput() {
        String[] rowCol = { "row", "column" };
        int[] choice={0,0};
		for (int i = 0; i < 2; i++) {
			System.out.printf( "Enter %s: ", rowCol[i] );
            choice[i] = getInput();
            i = checkExceed(choice, i);
			
		}	
		return choice;
    }

    private int checkExceed(int[] choice, int i) {
        if (choice[i] == 0) { // 0 to exit
            i = 2; // 2 will exit loop
        }
        else if (choice[0] > 20 || choice[0] < 0) {
            screen.displayMessage("Exceed grid rows. \n");
            i--;
        }
        else if (choice[1] > 60 || choice[1] < 0) {
            screen.displayMessage("Exceed grid columns. \n");
            i--;
        }
        return i;

    }
}