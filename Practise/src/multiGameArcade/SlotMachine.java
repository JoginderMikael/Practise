package multiGameArcade;

import java.util.Scanner;

public class SlotMachine implements Game{


	
	@Override
	public void startGame(Scanner scanner) {

		IO.println("\n---------------------------------------");
		IO.println("Welcome to the Slot Machine Game!");
		IO.println("Try your luck and spin the slots!");
		IO.println("---------------------------------------\n");

		String[] symbols = { "Cherry", "Lemon", "Orange", "Plum", "Bell", "Bar", "Seven" };
		int costPerSpin = 5;

		IO.println("Each spin costs " + costPerSpin + " points.");
		IO.println("You start with " + ScoreManager.getScore() + " points.");

		boolean continuePlaying = true;

		while (continuePlaying && ScoreManager.getScore() >= costPerSpin) {
			IO.print("Press Enter to spin the slots (or type 'exit' to quit): ");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("exit")) {
				continuePlaying = false;
				break;
			}

			ScoreManager.addPoints(-costPerSpin);

			String slot1 = symbols[(int) (Math.random() * symbols.length)];
			String slot2 = symbols[(int) (Math.random() * symbols.length)];
			String slot3 = symbols[(int) (Math.random() * symbols.length)];

			IO.println("Spinning... [" + slot1 + "] [" + slot2 + "] [" + slot3 + "]");

			if (slot1.equals(slot2) && slot2.equals(slot3)) {
				int reward = 50;
				IO.println("Jackpot! You won " + reward + " points!");
				ScoreManager.addPoints(reward);
				
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
				
			} else if (slot1.equals(slot2) || slot2.equals(slot3) || slot1.equals(slot3)) {
				int reward = 20;
				IO.println("Nice! You matched two symbols and won " + reward + " points!");
				ScoreManager.addPoints(reward);
				
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
				IO.println("No matches this time. Better luck next spin!");
			}

			IO.println("Your current score: " + ScoreManager.getScore() + " points.");

			if (ScoreManager.getScore() < costPerSpin) {
				IO.println("You don't have enough points to continue playing.");
				continuePlaying = false;
			}
		}

		IO.println("Thank you for playing the Slot Machine Game!");
		
	}
	@Override
	public String getName() {
		
		return "Slot Machine Game";
	}

	

}
