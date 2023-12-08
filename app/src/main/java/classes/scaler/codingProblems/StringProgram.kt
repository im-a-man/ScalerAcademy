package classes.scaler.codingProblems

fun main() {
    val input = "cats AND*Dogs-are_awesome"
    //val output = "CatsAndDogsAreAwesome"
    var word = ""
    var output = ""
    for (it in input.indices) {
        if (input[it] in 'A'..'Z' || input[it] in 'a'..'z') {
            word += if (word != "" && input[it] in 'A'..'Z') {
                input[it] + 32
            } else {
                if ((word == "" && input[it] in 'a'..'z')) {
                    input[it] - 32
                } else {
                    input[it]
                }
            }
        } else {
            output += word
            word = ""
        }
    }
    if (word.isNotEmpty())
        output += word
    print(output)
}