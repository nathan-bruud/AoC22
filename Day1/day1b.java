import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
public class day1b {
  public static void main (String[] args) throws FileNotFoundException {
    int[] bestScore = {0,0,0};
    int runningScore = 0;
    File input = new File("input.txt");
    Scanner reader = new Scanner(input);
    while (reader.hasNextLine()){
      String currentLine = reader.nextLine();
      if (currentLine.equals("")){
        bestScore = compareMaxes(bestScore, runningScore);
        runningScore = 0;
      } else {
        runningScore += Integer.parseInt(currentLine);
      }
    }
    bestScore = compareMaxes(bestScore, runningScore);
    System.out.println(Arrays.toString(bestScore));
    runningScore = 0;
    for (int i: bestScore){
      runningScore += i;
    }
    System.out.println(runningScore);
  }

  static int[] compareMaxes(int[] ccores, int newScore){
    int[] currentScores = ccores;
    if (newScore > currentScores[0]){
      currentScores[0] = newScore;
    }
    Arrays.sort(currentScores);
    return currentScores;
  }

  

}