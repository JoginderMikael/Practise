package multiGameArcade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ScoreManager {

	static int Score = 0;
	
	public static int getScore() {
		return Score;
	}
	
	public static void addPoints(int points) {
		Score += points;
	}
	
	public void saveHighScoreToFile() {
	 
		String filename = "highscore.txt";
	    FileWriter writer = null;
	    
		try {
			writer = new FileWriter(filename); 
			writer.write(String.valueOf(Score)); //convert score to string and write to file
			
		} catch (Exception e) {
			IO.println("An error occurred while saving the score." + e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				IO.println("An error occurred while closing the file." + e.getMessage());
			}
		}
	    
		
	}
	
	public static int loadHighScore() {
		String filename = "highscore.txt";
		//FileWriter writer = null;
		int highScore = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line = reader.readLine();
			if (line != null) {
				highScore = Integer.parseInt(line);
				return highScore;
			}
		} catch (Exception e) {
			IO.println("An error occurred while loading the high score." + e.getMessage());
		}
		
		return highScore;
	}
}
