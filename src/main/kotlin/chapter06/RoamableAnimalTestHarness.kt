package chapter06

fun main(args: Array<String>) {
    val animals = arrayOf(Hippo(), Aussiedoodle())

    for (animal in animals) {
        animal.roam()
        animal.eat()
    }

    val vet = Vet()
    val aussiedoodle = Aussiedoodle()
    val hippo = Hippo()

    vet.giveShot(aussiedoodle)
    vet.giveShot(hippo)

    val roamables = arrayOf(Hippo(), Aussiedoodle(), Vehicle())

    for (roamable in roamables) {
        roamable.roam()
        if (roamable is Animal) roamable.eat()
    }
}