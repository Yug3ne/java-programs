import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        System.out.println("Guessing game");

        
        Random random = new Random();
        int correctNum = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        int numberOfTries = 0;
        int maxTries = 5;
        System.out.println("Guess a number: ");

        while (guess != correctNum && numberOfTries < maxTries) {
            guess = scanner.nextInt();
            numberOfTries++;
            if (guess > correctNum) {
                System.out.println("You are too high");
            } else if (guess < correctNum) {
                System.out.println("You are too low");
            } else {
                System.out.println("Congratualtions you won, the number is: " + correctNum);
            }
        }
        if (guess!= correctNum ) {
            System.out.println("Too many attemps, you LOSE!!!.");
            System.out.println("The correct number is: " +correctNum);
            
        }

    }
}
