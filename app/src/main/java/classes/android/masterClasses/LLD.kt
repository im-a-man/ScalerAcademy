package classes.android.masterClasses

fun main() {
    val num: Int = 10
    val num1: (Int) -> Unit = {
        println(it)
    }
    num1(num)
}