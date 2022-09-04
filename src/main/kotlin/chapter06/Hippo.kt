package chapter06

class Hippo : Animal() {
    override val image: String
        get() = "hippo.jpg"
    override val food: String
        get() = "grass"
    override val habitat: String
        get() = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}