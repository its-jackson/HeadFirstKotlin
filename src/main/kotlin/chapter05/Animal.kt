package chapter05

// The class must be declared as "open" to become a superclass.
open class Animal {
    // As with the properties of this superclass, you must declare them "open" to be overwritten.
    open val image = ""
    open val food = ""
    open val habitat = ""

    var hunger = 10

    // And with the functions, declare them as "open" so they can be overwritten if need be.
    open fun makeNoise(): Unit = println("The animal is making a noise")
    open fun eat(): Unit = println("The animal is eating")
    open fun roam(): Unit = println("The animal is roaming")

    fun sleep(): Unit = println("The animal is sleeping")
}