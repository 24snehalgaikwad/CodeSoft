import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 7;
        int rounds = 0;
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        do {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int userGuess;
            int attempts = 0;
            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange);
            do {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += attempts;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } while (userGuess != numberToGuess && attempts < attemptsLimit);
            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + numberToGuess);
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (playAgain.equals("yes")) {
                rounds++;
            }
        } while (rounds > 0);
        System.out.println("\nThanks for playing! Your total score is: " + score);
        scanner.close();
    }
}
