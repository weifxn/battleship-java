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
}