package chapter06

class Aussiedoodle : Canine() {
    override val image = "aussiedoodle.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise(): Unit = println("Woof! Woof!")
    override fun eat(): Unit = println("The Aussiedoodle is eating $food")

    override fun toString(): String {
        return "Aussiedoodle(image='$image', food='$food', habitat='$habitat')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this.javaClass != other?.javaClass) return false

        other as Aussiedoodle

        if (image != other.image) return false
        if (food != other.food) return false
        if (habitat != other.habitat) return false

        return true
    }

    override fun hashCode(): Int {
        var result = image.hashCode()
        result = 31 * result + food.hashCode()
        result = 31 * result + habitat.hashCode()
        return result
    }
}