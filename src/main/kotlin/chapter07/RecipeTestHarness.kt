package chapter07

fun main(args: Array<String>) {
    val thaiCurryRecipes = Recipe.findRecipes("Thai Curry")
    thaiCurryRecipes.forEachIndexed { index, recipe ->
        println("index is $index toString is $recipe")
    }

    val r1 = Recipe("Thai Curry", "Chicken")
    val r2 = Recipe("Thai Curry", "Chicken")
    val r3 = r1.copy(title = "Chicken Bhuna")

    // named arguments, order doesn't matter
    val r4 = Recipe(mainIngredient = "Beef", title = "Spaghetti Bolognese")
    // passing values in order of declaration
    val r5 = Recipe("Clam Chowder", "Clam", true, "Moderate")

    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")
    println("r3 hash code: ${r3.hashCode()}")
    println("r4 hash code: ${r4.hashCode()}")
    println("r5 hash code: ${r5.hashCode()}")

    println("r1 toString: $r1")
    println("r1 == r2? ${r1 == r2}")
    println("r1 === r2? ${r1 === r2}")
    println("r1 == r3? ${r1 == r3}")

    // isn't this just cool or what?!
    // componentN functions
    val (title, mainIngredient, vegetarian, difficulty) = r1

    println(
        "title is $title " +
                "mainIngredient is $mainIngredient " +
                "vegetarian is $vegetarian " +
                "and difficulty is $difficulty"
    )
}