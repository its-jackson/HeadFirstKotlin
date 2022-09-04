package chapter06

abstract class Canine : Animal() {
    override fun roam(): Unit =
        println("The Canine is roaming")
}