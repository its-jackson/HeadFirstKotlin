package chapter06

abstract class Animal : Roamable {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String

    var hunger = 10

    abstract fun makeNoise()
    abstract fun eat()

    open override fun roam(): Unit = println("The Animal is roaming")
    open fun sleep(): Unit = println("The Animal is sleeping")
}