package classes.scaler.DSA.MODULE2.introToProblemSolving

fun main() {
    //For finding the perfect sqrt of a number
    //we need to iterate from 1 to root N only
    //because 16 = 4*4 => 16 is a perfect square root of 4,
    //So 4 is sqrt of 16, so we just need to iterate till root N only
    //16 => 1,2,....RootOfN
    //16 => 1,2...4 only 4 iterations or can say root of N iterations only

    //If a number is a perfect square of N
    println(sqrt(25))
    println(notSqrt(16))
}

//Root N iterations only
fun sqrt(n: Int): Int {
    var sqrt = 0
    for (i in 1..n) {
        if (i * i == n) {
            sqrt = i
            break
        }
    }
    return sqrt
}

//If a number is not a perfect square. It'll take root n iterations only
fun notSqrt(n: Int): Int {
    var ans = 0
    var i = 1
    while ((i * i) <= n) {
        ans = i
        i++
    }
    return ans
}

//Square root of a number
//Given a number A. Return square root of the number if it is perfect square otherwise return -1.
fun solve(A: Int): Int {
    var ans = -1
    var i = 1
    while ((i * i) <= A) {
        if(i*i==A){
            ans = i
        }
        i++
    }
    return ans
}
