import java.io.File;


fun readFileAsLinesUsingUseLines(fileName: String): List<String>
  = File(fileName).useLines { it.toList() }

fun calculateScore(matchup: String): Int {
    val map = hashMapOf(
        "A X" to 3,
        "A Y" to 4,
        "A Z" to 8,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 2,
        "C Y" to 6,
        "C Z" to 7
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
