package chapter09

/*
Important note about kotlin collections (Lists, Sets, Maps, etc):

The collection types have subtypes just for mutability. This forces you to explicitly
choose whether your collection should be mutable or immutable. This means that you can prevent collections from
being updated if you don’t want them to be.

You can still use Java collections, however, you should avoid them, unless you have a good reason.
If, you choose to use a Java collection, it will be mutable.

Sets: Only use a set for data class types, or an object that overrides hashCode() and equals().
        If you don't, the set will be highly inefficient, because it stores the values using the hashcode unordered.
*/

data class Recipe(var name: String)

fun main(args: Array<String>) {
    var mShoppingList = mutableListOf("Tea", "Eggs", "Milk")
    println("mShoppingList original: $mShoppingList")

    val extraShopping = listOf("Cookies", "Sugar", "Eggs")
    mShoppingList.addAll(extraShopping)
    println("mShoppingList items added: $mShoppingList")

    if (mShoppingList.contains("Tea")) mShoppingList[mShoppingList.indexOf("Tea")] = "Coffee"

    mShoppingList.sort()
    println("mShoppingList sorted: $mShoppingList")
    mShoppingList.reverse()
    println("mShoppingList reversed: $mShoppingList")

    val mShoppingSet = mShoppingList.toMutableSet()
    println("mShoppingSet: $mShoppingSet")
    val moreShopping = setOf("Chives", "Spinach", "Milk")
    mShoppingSet.addAll(moreShopping)
    println("mShoppingSet items added: $mShoppingSet")
    mShoppingList = mShoppingSet.toMutableList()
    println("mShoppingList new version: $mShoppingList")

    val r1 = Recipe("Chicken Soup")
    val r2 = Recipe("Quinoa Salad")
    val r3 = Recipe("Thai Curry")
    val r4 = Recipe("Jambalaya")
    val r5 = Recipe("Sausage Rolls")

    val mRecipeMap = mutableMapOf("Recipe1" to r1, "Recipe2" to r2, "Recipe3" to r3)
    println("mRecipeMap original: $mRecipeMap")
    val recipesToAdd = mapOf("Recipe4" to r4, "Recipe5" to r5)
    mRecipeMap.putAll(recipesToAdd)
    println("mRecipeMap updated: $mRecipeMap")
    if (mRecipeMap.containsKey("Recipe1")) println("Recipe1 is: ${mRecipeMap.getValue("Recipe1")}")
}