
import java.util.Scanner;

public class Guesser {

    private int low;
    private int high;
    private Scanner scanner = new Scanner(System.in);

   
    public Guesser(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public void start() {
        rules();
        doGuesses();
    }

   
    private void rules() {
        System.out.println("Think of a number between " + low + " and " + high);
        System.out.println("I'm going to ask a few questions in order to guess the number.");
        System.out.println("Please answer T for true, and F for false.");
        System.out.println();
    }

  
    private String getReply() {
        String reply = scanner.nextLine();

        while (!reply.equals("T") && !reply.equals("F")) {
            System.out.println("Please reply T for true or F for false");
            reply = scanner.nextLine();
        }

        return reply;
    }

   
    private void doGuesses() {
        int guesses = 0;

        while (low < high) {
            int middle = low + (high - low) / 2;

            System.out.println("Is the number less than or equal to " + middle + "?");

            String reply = getReply();

            if (reply.equals("T")) {
                high = middle;
            } else {
                low = middle + 1;
            }

            guesses++;
        }

        answer(low, guesses);
    }

    private void answer(int guess, int numberOfGuesses) {
        System.out.println("You were thinking about " + guess +
                " (took me " + numberOfGuesses + " guesses)");
    }
}
