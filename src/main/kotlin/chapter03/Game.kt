package chapter03

fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)

}

//You can omit the return type since the compiler can infer it.
//fun getGameChoice(options: Array<String>): String = options[(Math.random() * options.size).toInt()]
fun getGameChoice(options: Array<String>) =
    options[(Math.random() * options.size).toInt()]

//fun getUserChoice(options: Array<String>): String {
//    print("Please enter one of the following:")
//    for ((index, opt) in options.withIndex()) print(" $index ) $opt")
//    println(".")
//    val response = readln()
//
//}
