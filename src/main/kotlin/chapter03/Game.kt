package chapter03

fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(gameChoice, userChoice)
}

//You can omit the return type since the compiler can infer it.
//fun getGameChoice(options: Array<String>): String = options[(Math.random() * options.size).toInt()]
fun getGameChoice(options: Array<String>) = options[(Math.random() * options.size).toInt()]

fun getUserChoice(options: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Please enter one of the following:")
        for ((index, opt) in options.withIndex()) print(" $index) $opt")
        println(".")
        val response = readln()
        if (response in options) {
            isValidChoice = true
            userChoice = response
        }
        if (!isValidChoice) println("You must enter a valid choice.")
    }

    return userChoice
}

fun printResult(gameChoice: String, userChoice: String): Unit {
    val result =
        if (userChoice == gameChoice) "Tie!"
        else if ((userChoice == "Rock" && gameChoice == "Scissors" ||
                    userChoice == "Paper" && gameChoice == "Rock" ||
                    userChoice == "Scissors" && gameChoice == "Paper")
        ) "You win!"
        else "You lose!"

    println("You chose $userChoice. I chose $gameChoice. $result")
}
