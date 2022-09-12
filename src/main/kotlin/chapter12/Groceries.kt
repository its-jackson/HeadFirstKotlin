package chapter12

val String.halfLength
    get() = length / 2.0

data class Grocery(
    val name: String, val category: String,
    val unit: String, val unitPrice: Double,
    val quantity: Int
)

fun main(args: Array<String>) {
    val groceriesList = listOf(
        Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery("Mushroom", "Vegetable", "lb", 4.0, 1),
        Grocery("Bagles", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive Oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice Cream", "Frozen", "Pack", 3.0, 2)
    )

    println("Highest unit price is: ${groceriesList.maxBy { it.unitPrice }.unitPrice.toDollar()}")
    println("Lowest quantity is: ${groceriesList.minBy { it.quantity }.quantity}")
    println("Sum of quantities is: ${groceriesList.sumOf { it.quantity }}")
    println("Total price is: ${groceriesList.sumOf { it.unitPrice * it.quantity }.toDollar()}")
    println("Half length of first item's name is: ${groceriesList.first().name.halfLength}")

    println("Vegetables are: ${groceriesList.filter { it.category == "Vegetable" }.map { it.name }}")
    println("Not frozen are: ${groceriesList.filterNot { it.category == "Frozen" }.map { it.name }}")

    groceriesList
        .filter { it.unitPrice > 3 }
        .map { it.name }
        .forEach { println("It's unit price is > 3: $it") }

    groceriesList
        .groupBy { it.category }
        .forEach {
            println(it.key)
            it.value.forEach { println("    ${it.name}") }
        }

    // runningSum gets its type from the initial value that
    // you specify. It’s initialized with this initial value, so in the example,
    // runningSum is an Int that’s initialized with 0.
    // The lambda body specifies the operation you want to perform for each item in
    // the collection, the result of which is then assigned to the lambda’s first parameter
    // variable. In the example, the function takes the value of runningSum, adds
    // it to the value of the current item, and assigns this new value to runningSum.
    // When the function has looped through all items in the collection, fold returns
    // the final value of this variable.
    val newTotalPrice: Double = groceriesList
        .map { it.unitPrice * it.quantity }
        .fold(0.0) { runningSum, item -> runningSum + item }

    val allNames: String = groceriesList
        .map { it.name }
        .fold("") { runningName, name -> "$runningName $name" }

    val leftOverChange: Double = groceriesList
        .fold(60.0) { change, item -> change - item.quantity * item.unitPrice }

    println("Your items are:$allNames | New total price is: ${newTotalPrice.toDollar()} | Your change is: ${leftOverChange.toDollar()}")
}

fun Double.toDollar(): String {
    return "$$this"
}