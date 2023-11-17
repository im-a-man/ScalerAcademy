package classes.scaler.DSA.MODULE3.strings

fun main() {
    println("ASCII Table")
    (0..256).forEach {
        print(" [$it, ${it.toChar()}]   ")
        if (it % 10 == 0) println()
    }
}