package chapter04

fun main(args: Array<String>) {
    val songOne = Song("The Mesopotamians", "They Might Be Giants")
    val songTwo = Song("Going Underground", "The Jam")
    val songThree = Song("Make Me Smile", "Steve Harley")

    songTwo.play()
    songTwo.stop()
    songThree.play()
}