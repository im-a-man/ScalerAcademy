package classes.scaler.DSA.MODULE2.introToProblemSolving

fun main() {
    //To find the sum of n natural numbers
    //Use this formula
    //=> sumOfNaturalNumbers = N * (N + 1) / 2
    println(sumOfNaturalNumbers(100))
}

fun sumOfNaturalNumbers(n: Int): Int {
    //There is no iteration so we can say 1 iteration only to find the sum of the natural numbers
    return ((n * (n + 1)) / 2)
}