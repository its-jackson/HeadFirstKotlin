package chapter06

class Vehicle : Roamable {
//    override val velocity: Int
//        get() = 200

    override fun roam() {
        println("The Vehicle is roaming")
    }
}