package classes.scaler.DSA.MODULE4.recursion2

fun main() {
    val n = 3 // Change this value to the number of disks you want to solve for
    towerOfHanoi1(n, 'A', 'B', 'C')
}

fun towerOfHanoi1(n: Int, source: Char, auxiliary: Char, destination: Char) {
    if (n == 1) {
        println("Move disk 1 from $source to $destination")
        return
    }

    towerOfHanoi1(n - 1, source, destination, auxiliary)
    println("Move disk $n from $source to $destination")
    towerOfHanoi1(n - 1, auxiliary, source, destination)
}