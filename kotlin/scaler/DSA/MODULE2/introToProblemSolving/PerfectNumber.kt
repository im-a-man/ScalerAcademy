package classes.scaler.DSA.MODULE2.introToProblemSolving

//You are given an integer A. You have to tell whether it is a perfect number or not.
//Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
//A proper divisor of a natural number is the divisor that is strictly less than the number.
//Return 1 if A is a perfect number and 0 otherwise.

fun main() {
    //Find Perfect Numbers
    println(perfectNumber(6))
}

fun perfectNumber(A: Int): Int {
    var sumOfAllFactors = 0
    var i = 1
    while (i <= A/2) {
        if (A % i == 0)
            sumOfAllFactors += i
        i++
    }
    if(sumOfAllFactors == A && A>1)
        return 1;
    else
        return 0;
}