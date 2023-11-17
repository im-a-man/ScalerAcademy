package classes.scaler.interviewPreparation.codingProblems

//Find the element that is not occurring again.
//Using XOR
fun main() {
    val elements = intArrayOf(1, 2, 1, 2, 4)
    var result = 0
    elements.forEach {
        result = result xor it
    }
    println(result)
}