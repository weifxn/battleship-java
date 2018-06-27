import java.util.Scanner;

public class Input {
    private Scanner input;

    public Input() {
        input = new Scanner( System.in );
    }

    public int getInput() {
        return input.nextInt();
    }
}