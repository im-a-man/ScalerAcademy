package classes.scaler.DSA.MODULE2.introToProblemSolving

fun main() {
    //Factors of 24 is 8 in N iterations
    println(countFactors(24))
    //Factors of 24 is 8 in Root N iterations
    println(countFactorsInRootNTime(6))
}

//This approach is not good for larger numbers
fun countFactors(n: Int): Int {
    var count = 0
    for (i in 1..n) {
        if (n % i == 0) count += 1
    }
    return count
}

//This approach is good for larger numbers in Root N iterations
//It'll iterate till root N times only,
//i<=Root N
//i*i<=N
fun countFactorsInRootNTime(n: Int): Int {
    var count = 0
    var i = 1
    while ((i * i) <= n) {//Only Root N times iterate
        if (n % i == 0)
        //If i is factor of N the N/i is also a factor of N
            if (i == (n / i))
                count += 1
            else
                count += 2
        i++
    }
    return count
}