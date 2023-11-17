package classes.scaler.DSA.MODULE2.introToProblemSolving

fun main() {
    //Prime numbers should match 2 conditions
    //1-> Number should divisible by 1 and itself only
    //2-> and It has exactly 2 factors only
    //So following these conditions 1 is not a prime number because it has 1 factor only
    val n = 72
    println(if (isPrime(n)) "$n is a prime number" else "$n is not a prime number")
}

//This will take Root N iterations only
fun isPrime(n: Int): Boolean {
    return (countFactorsInRootNTime(n) == 2)
}

//You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
fun countPrimeNumbers(A: Int): Int {
    var count = 0
    for(i in 1..A){
        if(countFactorsInRootNTime(i) ==2)
            count+=1
    }
    return count
}