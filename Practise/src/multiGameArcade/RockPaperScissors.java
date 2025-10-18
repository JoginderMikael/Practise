package multiGameArcade;

import java.util.Scanner;

public class RockPaperScissors implements Game{

	@Override
	public void startGame(Scanner scanner) {
		
		IO.println("\n---------------------------------------");
		IO.println("Welcome to Rock Paper Scissors!");
		IO.println("Beat the computer to earn points.");
		IO.println("---------------------------------------\n");

		String[] choices = { "Rock", "Paper", "Scissors" };
		int rounds = 5;
		int playerScore = 0;
		int computerScore = 0;

		for (int i = 0; i < rounds; i++) {
			IO.print("Enter your choice (Rock, Paper, Scissors): ");
			String playerChoice = scanner.nextLine();
			String computerChoice = choices[(int) (Math.random() * 3)];
			IO.println("Computer chose: " + computerChoice);

			if (playerChoice.equalsIgnoreCase(computerChoice)) {
				IO.println("It's a tie!");
			} else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors"))
					|| (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock"))
					|| (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
				IO.println("You win this round!");
				playerScore++;
			} else {
				IO.println("Computer wins this round!");
				computerScore++;
			}
		}

		IO.println("\n---------------------------------------");
		IO.println("Final Score - You: " + playerScore + " | Computer: " + computerScore);
		if (playerScore > computerScore) {
			IO.println("Congratulations! You won the game! +15 points!");
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
			
		} else if (computerScore > playerScore) {
			IO.println("Computer wins the game! Better luck next time.");
		} else {
			IO.println("The game is a tie! +5 points for your effort.");
			ScoreManager.addPoints(5);
			
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
			
			
		}
		
		IO.println("---------------------------------------");
	}

	@Override
	public String getName() {
		
		return "ROCK PAPER SCISSORS";
	}

}
