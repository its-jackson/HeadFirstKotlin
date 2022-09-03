package chapter05

// If the superclass has a primary constructor
// then you must call it in the subclass header or your
// code won’t compile. Remember that the compiler always makes a default constructor.
// Even if you haven't explicitly added a constructor to the superclass.
class Hippo : Animal() {
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

//    override val image: String
//        get() = "hippo.jpg"
//    override val food: String
//        get() = "grass"
//    override val habitat: String
//        get() = "water"

    override fun makeNoise(): Unit = println("Grunt! Grunt!")
    override fun eat(): Unit = println("The hippo is eating $food")
}