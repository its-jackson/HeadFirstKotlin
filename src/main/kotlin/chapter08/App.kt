package chapter08

class Wolf {
    var hunger = 10
    val food = "meat"

    fun eat(): Unit = println("The Wolf is eating $food")
}

class MyWolf {
    var wolf: Wolf? = Wolf()

    fun myFunction(): Unit? = wolf?.eat()
}

fun getAlphaWolf(): Wolf? {
    return Wolf()
}

fun main(args: Array<String>) {
    var w: Wolf? = Wolf()

    if (w != null) w.eat()

    var x = w?.hunger
    println("The value of x is $x")

    // use elvis operator to set y to the value of hunger if w is not null, otherwise set y to -1
    var y = w?.hunger ?: -1
    println("The value of y is $y")

    var myWolf: MyWolf? = MyWolf()
    myWolf?.wolf?.hunger = 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray) {
        item?.let { println(it) } // print all non-null items
    }

    // get the alpha Wolf, and if it’s not null, let it eat
    getAlphaWolf()?.let {
        it.eat()
    }

    w = null
    // throws an NPE as w is null.
    // var z = w!!.hunger
    //
}