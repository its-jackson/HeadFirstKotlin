package chapter06

class Aussiedoodle : Canine() {
    override val image = "aussiedoodle.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise(): Unit = println("Woof! Woof!")
    override fun eat(): Unit = println("The Aussiedoodle is eating $food")
}