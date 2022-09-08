package chapter10

/*
Important notes on generics:
out: allows you to use a generic subtype in place of a supertype (covariant).
in:  allows you to use a generic supertype in place of a subtype (contravariant).
contravariant is the polar opposite of covariant.
when a generic type has no in or out prefix, we say that the type is invariant.
generic types can be locally contravariant too.
*/

// only allowed in top level (for const variables)
const val MAX_SCORE = 100

// single abstract method/function interface.
// if you want to be able to use a generic subtype object in a place of a generic
// supertype, you can do so by prefixing the generic type with 'out'.
// 'out' means making a generic type 'covariant'.
// if a generic type is covariant, it means that you can use a subtype in place of a supertype.
interface Retailer<out E> {
    fun sell(): E
}

// concrete implementations of retailers (obv could have one retailer to sell all pet types)
internal class CatRetailer() : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell cat")
        return Cat("")
    }
}

internal class DogRetailer() : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell dog")
        return Dog("")
    }
}

internal class FishRetailer() : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell fish")
        return Fish("")
    }
}

// we want to be able to use a generic supertype in place of a generic subtype (contravariant).
// pass a Pet<Vet> to a Contest<Cat> in place of a Pet<Cat>
internal class Vet<in T: AbstractPet> {
    fun treat(t: T) = println("Treating pet: ${t.name}")
}

// internal (only accessible within the module)
internal abstract class AbstractPet(var name: String)

internal open class Cat(name: String) : AbstractPet(name)

internal open class Dog(name: String) : AbstractPet(name)

internal open class Fish(name: String) : AbstractPet(name)

internal class PetOwner<T: AbstractPet>(t: T) {
    private val pets = mutableListOf(t)

    fun add(t: T) = pets.add(t)

    fun remove(t: T) = pets.remove(t)
}

// Restrict "T" to a specific supertype, "AbstractPet"
internal class Contest<T : AbstractPet>(var vet: Vet<in T>) {
    private val scores: MutableMap<T, Int> = mutableMapOf()

    fun addScore(t: T, score: Int = 0) {
        if (score in 1..MAX_SCORE) scores[t] = score
    }

    fun getWinners(): MutableSet<T> {
        val highScore = scores.values
            .maxOrNull()

        val winners: MutableSet<T> = mutableSetOf()

        for ((t, score) in scores) {
            val isHighScore = highScore?.equals(score) ?: false
            if (isHighScore) winners.add(t)
            //if (highScore?.equals(score) == true) winners.add(t)
        }

        return winners
    }
}

fun main(args: Array<String>) {
    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny Mcgraw")
    val dogMav = Dog("Maverick")

    val catVet = Vet<Cat>()
    val dogVet = Vet<Dog>()
    val fishVet = Vet<Fish>()
    val petVet = Vet<AbstractPet>()

    val catContest = Contest<Cat>(petVet) // contravariant
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatsu, 45)
    val topCat = catContest.getWinners()
        .first()
    println("Cat contest winner is: ${topCat.name}")

    val petContest = Contest<AbstractPet>(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)
    petContest.addScore(dogMav, 62)
    petContest.vet.treat(fishFinny)
    val topPet = petContest.getWinners()
        .first()
    println("Pet contest winner is: ${topPet.name}")

    val petOwner = PetOwner(dogMav)
    petOwner.remove(dogMav)
    petOwner.add(dogMav)

    val dogRetailer: Retailer<Dog> = DogRetailer()
    val catRetailer: Retailer<Cat> = CatRetailer()
    val petRetailer: Retailer<AbstractPet> = CatRetailer() // covariant
    val catSold = petRetailer.sell()

    dogVet.treat(dogMav)
    fishVet.treat(fishFinny)
    petVet.treat(catFuzz)
    petVet.treat(fishFinny)
    petVet.treat(catKatsu)
}