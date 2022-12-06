import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class day1 {
  public static void main (String[] args) throws FileNotFoundException {
    int bestScore = 0;
    int runningScore = 0;
    File input = new File("input.txt");
    Scanner reader = new Scanner(input);
    while (reader.hasNextLine()){
      String currentLine = reader.nextLine();
      if (currentLine.equals("")){
        bestScore = Math.max(bestScore, runningScore);
        runningScore = 0;
      } else {
        runningScore += Integer.parseInt(currentLine);
      }
    }
    reader.close();
    bestScore = Math.max(runningScore, bestScore);
    System.out.println(bestScore);
  }

}