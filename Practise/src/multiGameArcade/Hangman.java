package multiGameArcade;

import java.util.Scanner;

public class Hangman implements Game{

	@Override
	public void startGame(Scanner scanner) {
		IO.println("\n---------------------------------------");
		IO.println("Welcome to HangMan Game!");
		IO.println("Try to guess the word before you run out of attempts!");
		IO.println("---------------------------------------\n");

		String[] words = { "programming", "java", "hangman", "computer", "interface", "game", "arcade" };
		String wordToGuess = words[(int) (Math.random() * words.length)];
		char[] guessedLetters = new char[wordToGuess.length()];
		int attemptsLeft = 6;
		boolean wordGuessed = false;

		for (int i = 0; i < guessedLetters.length; i++) {
			guessedLetters[i] = '_';
		}

		while (attemptsLeft > 0 && !wordGuessed) {
			IO.println("Word to guess: " + String.valueOf(guessedLetters));
			IO.println("Attempts left: " + attemptsLeft);
			IO.print("Enter a letter: ");
			String input = scanner.nextLine();
			char guessedChar = input.charAt(0);

			boolean correctGuess = false;
			for (int i = 0; i < wordToGuess.length(); i++) {
				if (wordToGuess.charAt(i) == guessedChar) {
					guessedLetters[i] = guessedChar;
					correctGuess = true;
				}
			}

			if (!correctGuess) {
				attemptsLeft--;
				IO.println("Wrong guess!");
			} else {
				IO.println("Good guess!");
			}

			if (String.valueOf(guessedLetters).equals(wordToGuess)) {
				wordGuessed = true;
			}
		}

		if (wordGuessed) {
			IO.println("\nCongratulations! You've guessed the word: " + wordToGuess);
			ScoreManager.addPoints(15);
			
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
			
		} else {
			IO.println("\nGame Over! The word was: " + wordToGuess);
		}
	}


	@Override
	public String getName() {
		
		return "HangMan Game";
	}

	
}
