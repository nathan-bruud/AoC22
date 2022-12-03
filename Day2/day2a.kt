import java.io.File;


fun readFileAsLinesUsingUseLines(fileName: String): List<String>
  = File(fileName).useLines { it.toList() }

fun calculateScore(matchup: String): Int {
    val map = hashMapOf(
        "A X" to 4,
        "A Y" to 8,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6
    )
    return map[matchup]!!;
}

fun main(){
    var score = 0;
    var inputs = readFileAsLinesUsingUseLines("input.txt");
    inputs.forEach {
        score += calculateScore(it);
    }
    println(score);
}
