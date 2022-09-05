package chapter08

class BadException : Exception()

fun main(args: Array<String>) {
    myFunc("Yes")
}

fun myFunc(test: String) {
    try {
        print("t")
        riskyCode(test)
        print("o")
    } catch (e: BadException) {
        print("a")
    } finally {
        print("w")
    }
    print("a")
}

fun riskyCode(test: String) {
    print("h")
    if (test == "Yes") throw BadException()
    print("r")
}