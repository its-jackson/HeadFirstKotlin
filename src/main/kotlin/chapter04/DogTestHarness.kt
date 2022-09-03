package chapter04

fun main(args: Array<String>) {
    val dogs = arrayOf(
        Dog("Maverick", 55, "Aussie doodle"),
        Dog("Karma", 67, "German shepard")
    )

    dogs[0].weight = -57

    for (dog in dogs) {
        dog.bark()
        println("Name: ${dog.name} weight: ${dog.weight} breed: ${dog.breed}")
    }
}