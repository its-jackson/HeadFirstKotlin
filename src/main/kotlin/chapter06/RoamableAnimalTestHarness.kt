package chapter06

/**
 * Application Purpose: Test the superclass Animal and interface Roamable
 *                      The abstract class Canine inherits from the abstract superclass Animal
 *                      which passes the buck to the Aussiedoodle concrete class for everything except
 *                      the fun called roam(). The interface Roamable exploits polymorphism by providing
 *                      flexibility by having fewer restrictions, more than the superclass.
 */
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
        when (roamable) {
            is Hippo -> {
                val h: Hippo = roamable // this is explicitly casting the roamable to a Hippo
                h.sleep()
                roamable.makeNoise() // this is called smart casting
                println("Image name ${roamable.image} habitat ${roamable.habitat}")
            }

            is Aussiedoodle -> {
                // Code here to do something
            }

            is Vehicle -> {
                // Code here to do something
            }

            is Canine -> {
                // Code here to do something
            }
        }
    }
}