package chapter07

/*
What's a data class, and how does it function?
I know that it's similar to the lombok annotation, but what can it do for me?
The data class will override the hashCode() equals() toString() functions from Any (Mother of all classes).
the equals() function changes from checking the underlying object reference, to object equivalency.
'==' checks for equivalency, rather than, '===' which, checks if the same variable points to the same object in the system.
The data class allows creating copies of the object, with altered state too. One of the cool features that data class has
is the ability to de-structure classes with componentN functions.
*/
data class Recipe(
    val title: String,
    val mainIngredient: String,
    val isVegetarian: Boolean = false, // default value - could be declared as expression too
    val difficulty: String = "Easy" // default value - could be declared as expression too
) {
    fun getAddition(a: Int, b: Int) = a + b

    fun getAddition(a: Double, b: Double) = a + b

    companion object { // a companion object is java's version of the static keyword, we don't have a static keyword
        // you can always overload the function if need be
        @JvmOverloads fun findRecipes(title: String = "",
                        ingredient: String = "",
                        isVegetarian: Boolean = false,
                        difficulty: String = ""): Array<Recipe> {
            // Code to find recipes...
            return arrayOf()
        }
    }
}