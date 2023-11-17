package classes.scaler.DSA.MODULE3.bitManipulationsBasics

fun main() {
    val num1 = 83 // Replace with your first integer
    val num2 = 73 // Replace with your second integer

    // Bitwise AND
    val andResult = num1 and num2
    println("$num1 AND $num2 = $andResult")

    // Bitwise OR
    val orResult = num1 or num2
    println("$num1 OR $num2 = $orResult")

    // Bitwise XOR
    val xorResult = num1 xor num2
    println("$num1 XOR $num2 = $xorResult")

    // Bitwise NOT (Complement)
    val notResult1 = num1.inv()
    val notResult2 = num2.inv()
    println("NOT $num1 = $notResult1")
    println("NOT $num2 = $notResult2")

    // Left Shift
    val leftShiftResult = num1 shl 1 // Shift left by 1 bit
    println("$num1 left-shifted by 1 bit = $leftShiftResult")

    // Right Shift
    val rightShiftResult = num1 shr 1 // Shift right by 1 bit
    println("$num1 right-shifted by 1 bit = $rightShiftResult")
}