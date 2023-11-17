package classes.scaler.DSA.MODULE3.strings

fun main() {
    println(countBobOccurrences("abobc"))
    println(countBobOccurrences("bobob"))
}

fun countBobOccurrences(input: String): Int {
    var count = 0
    for (i in 0 until input.length - 2) {
        if (input.substring(i, i + 3) == "bob") {
            count++
        }
    }
    return count
}