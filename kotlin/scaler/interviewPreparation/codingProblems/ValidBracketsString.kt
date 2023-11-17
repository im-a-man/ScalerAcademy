package classes.scaler.interviewPreparation.codingProblems

import java.util.Stack

fun isValidBrackets(input: String): Boolean {
    val stack = Stack<Char>()

    for (char in input) {
        when (char) {
            '(', '[', '{' -> stack.push(char)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
        }
    }

    return stack.isEmpty()
}

fun main() {
    val input1 = "{[()()]}" // Valid brackets
    val input2 = "{[({})]}" // Valid brackets
    val input3 = "{[()]}"   // Valid brackets
    val input4 = "{[()]"    // Invalid brackets
    val input5 = "){[()]}"    // Invalid brackets

    println("Input1 is valid: ${isValidBrackets(input1)}")
    println("Input2 is valid: ${isValidBrackets(input2)}")
    println("Input3 is valid: ${isValidBrackets(input3)}")
    println("Input4 is valid: ${isValidBrackets(input4)}")
    println("Input5 is valid: ${isValidBrackets(input5)}")
}