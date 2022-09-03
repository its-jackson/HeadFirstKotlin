package chapter04

import java.util.*

class Dog(val name: String, weight: Int, breed: String) {
    init {
        println("Dog $name has been initialized")
    }

    var activities = arrayOf("Walks")
    val breed = breed.uppercase(Locale.getDefault())

    init {
        println("The breed is $breed")
    }

    var weight = weight
        set(value) {
            if (value > 0) field = value
        }

    val weightInKgs: Double
        get() = weight / 2.2

    fun bark(): Unit = println(if (weight < 20) "Yip!" else "Woof!")
}