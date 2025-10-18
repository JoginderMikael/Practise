package multiGameArcade;

import java.util.Scanner;

public class MultiGameArcade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        IO.println("***************************************");
        IO.println("===Welcome to the Multi-Game Arcade!===");
        IO.println("***************************************");
		boolean exit = false;
		
		while(!exit) {
			
			IO.println("\n---------------------------------------");
			IO.println("\nSelect a game to play:");
			IO.println("1. Guess the Number Game");
			IO.println("2. Hang Man Game");
			IO.println("3. Rock Paper Scissors Game");
			IO.println("4. Slot Manager Game");
			IO.println("5. Exit");
			IO.println("---------------------------------------\n");
			
			
			int choice = 0;
			
			try {
            IO.print("\nEnter your choice (1-5): ");
             choice = scanner.nextInt();
             scanner.nextLine();
			
			} catch (Exception e) {
                IO.print("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); 
                continue;
			}
            
            Game game = null;
            
            switch(choice) {
            case 1 -> game = new GuessTheNumber();
            case 2 -> game = new Hangman();
            case 3 -> game = new RockPaperScissors();
            case 4 -> game = new SlotMachine();
            case 5 -> {
            	IO.println("\n****************************************");
                IO.println("Exiting the Multi-Game Arcade. Goodbye!");
                IO.println("****************************************");
                exit = true;
            }
               default -> IO.println("Invalid choice. Please select a valid option (1-5).");
                }
            
            if(game != null) {
                IO.println("Starting " + game.getName() + "...");
                game.startGame(scanner);
            }
            
            
        }

	scanner.close();
	}

}
