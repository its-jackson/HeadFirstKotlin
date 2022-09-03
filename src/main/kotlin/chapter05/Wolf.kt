package chapter05

class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forest"

    override fun makeNoise(): Unit = println("Hooooowl!")
    override fun eat(): Unit = println("The wolf is eating $food")
}