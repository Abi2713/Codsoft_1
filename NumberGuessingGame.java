package codsoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;
        int totalRounds = 0;
        int totalWins = 0;

        do {
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A new round has started! Guess the number between " + RANGE_START + " and " + RANGE_END + ".");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < RANGE_START || userGuess > RANGE_END) {
                    System.out.println("Please enter a number between " + RANGE_START + " and " + RANGE_END + ".");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            }

            totalRounds++;
            if (guessedCorrectly) {
                totalWins++;
            }

            System.out.println("Do you want to play again? (yes/no)");
            scanner.nextLine(); 
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Wins: " + totalWins);

        scanner.close();
    }
}

