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
			
				if (numberOfTries <= 5) {
					IO.println("Excellent work! You guessed it in 5 or fewer tries. +20 points!");
					ScoreManager.addPoints(20);
				} else if (numberOfTries <= 10) {
					IO.println("Good job! You guessed it in 10 or fewer tries. +10 points!");
					ScoreManager.addPoints(10);
				} else {
					IO.println("You guessed it! +5 points for your effort.");
					ScoreManager.addPoints(5);
				}
				

				try {
					if (ScoreManager.getScore() > ScoreManager.loadHighScore()) {
						IO.println("New High Score: " + ScoreManager.getScore() + " points!");
						ScoreManager sm = new ScoreManager();
						sm.saveHighScoreToFile();
					}
				} catch (Exception e) {
					IO.println("An error occurred while checking/saving the high score." + e.getMessage());
					e.printStackTrace();
				}
			
				IO.println("-----------------------------------------------------------------");
				
			}
		}
		
	}

	@Override
	public String getName() {
		
		return "Guess The Number";
	}

}
