package multiGameArcade;

import java.util.Scanner;

public class GuessTheNumber implements Game{

	@Override
	public void startGame(Scanner scanner) {
		IO.println("\n---------------------------------------");
		IO.println("Welcome to Guess The Number!");
		IO.println("I'm thinking of a number between 1 and 100.");
		IO.println("Try to guess it!");
		IO.println("---------------------------------------");

		int numberToGuess = (int) (Math.random() * 100) + 1;
		int numberOfTries = 0;
		boolean hasGuessedCorrectly = false;

		while (!hasGuessedCorrectly) {
			IO.print("Enter your guess: ");
			int playerGuess = scanner.nextInt();
			numberOfTries++;

			if (playerGuess < numberToGuess) {
				IO.println("Too low! Try again.");
			} else if (playerGuess > numberToGuess) {
				IO.println("Too high! Try again.");
			} else {
				hasGuessedCorrectly = true;
				IO.println("\n-----------------------------------------------------------------");
				IO.println("Congratulations! You've guessed the number " + numberToGuess + " in " + numberOfTries
						+ " tries.");
				IO.println("-----------------------------------------------------------------");
			}
		}
		
	}

	@Override
	public String getName() {
		
		return "Guess The Number";
	}

}
