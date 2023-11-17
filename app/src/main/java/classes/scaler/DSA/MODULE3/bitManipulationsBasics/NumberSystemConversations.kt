package classes.scaler.DSA.MODULE3.bitManipulationsBasics

import kotlinx.coroutines.delay
import kotlin.math.pow

fun main() {
    while (true) {
        clearConsole()
        println("Number System Converter")
        println("1. Decimal to Binary")
        println("2. Decimal to Octal")
        println("3. Decimal to Hexadecimal")
        println("4. Binary to Decimal")
        println("5. Octal to Decimal")
        println("6. Hexadecimal to Decimal")
        println("7. Exit")
        print("Enter your choice: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                print("Enter a decimal number: ")
                val decimal = readlnOrNull()?.toIntOrNull()
                if (decimal != null) {
                    val binary = decimalToBinary(decimal)
                    println("Binary: $binary")
                } else {
                    println("Invalid input. Please enter a valid decimal number.")
                }
            }
            2 -> {
                print("Enter a decimal number: ")
                val decimal = readlnOrNull()?.toIntOrNull()
                if (decimal != null) {
                    val octal = decimalToOctal(decimal)
                    println("Octal: $octal")
                } else {
                    println("Invalid input. Please enter a valid decimal number.")
                }
            }
            3 -> {
                print("Enter a decimal number: ")
                val decimal = readlnOrNull()?.toIntOrNull()
                if (decimal != null) {
                    val hexadecimal = decimalToHexadecimal(decimal)
                    println("Hexadecimal: $hexadecimal")
                } else {
                    println("Invalid input. Please enter a valid decimal number.")
                }
            }
            4 -> {
                print("Enter a binary number: ")
                val binary = readlnOrNull()
                val decimal = binaryToDecimal(binary)
                println("Decimal: $decimal")
            }
            5 -> {
                print("Enter an octal number: ")
                val octal = readlnOrNull()
                val decimal = octalToDecimal(octal)
                println("Decimal: $decimal")
            }
            6 -> {
                print("Enter a hexadecimal number: ")
                val hexadecimal = readlnOrNull()
                val decimal = hexadecimalToDecimal(hexadecimal)
                println("Decimal: $decimal")
            }
            7 -> {
                println("Exiting the program.")
                return
            }
            else -> {
                println("Invalid choice. Please select a valid option.")
            }
        }
        println("Wait... while resetting.")
        Thread.sleep(5000)
    }
}

fun decimalToBinary(decimal: Int): String {
    return Integer.toBinaryString(decimal)
}

fun decimalToOctal(decimal: Int): String {
    return Integer.toOctalString(decimal)
}

fun decimalToHexadecimal(decimal: Int): String {
    return Integer.toHexString(decimal)
}

fun binaryToDecimal(binary: String?): Int {
    return try {
        Integer.parseInt(binary, 2)
    } catch (e: NumberFormatException) {
        0
    }
}

fun octalToDecimal(octal: String?): Int {
    return try {
        Integer.parseInt(octal, 8)
    } catch (e: NumberFormatException) {
        0
    }
}

fun hexadecimalToDecimal(hexadecimal: String?): Int {
    return try {
        Integer.parseInt(hexadecimal, 16)
    } catch (e: NumberFormatException) {
        0
    }
}

fun clearConsole() {
    print("\u001b[H\u001b[2J")
}