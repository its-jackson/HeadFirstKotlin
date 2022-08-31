package chapter01

fun main(args: Array<String>) {
    println("Pow!")
    var x = 3
    val y = 20
    val name = "Cormoran"
    x *= 10
    println("x is $x.")

    while (x > 20) {
        x -= 1
        println("x is now $x.")
    }

    for (i in 1..10) {
        x += 1
        println("x is now $x.")
    }

    if (x == 20) {
        println("x must be 20.")
    } else {
        println("x isn't 20.")
    }

    if (name.equals("Cormoran")) {
        println("$name Strike")
    }

    // If statements can be used as Expressions to directly return a value.
    // When using an if statement as an expression you MUST have the "else" clause.
    println(
        if (x > y) "x is greater than y"
        else "y is greater than x"
    )

    var z = 1

    while (z < 3) {
        print(if (z == 1) "Yab" else "Dab")
        print("ba")
        z += +1
    }

    if (z == 3) {
        print("Do")
    }
}
