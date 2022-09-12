package chapter11

val kgsToTonsLambda = combine(getConversionLambda("KgsToPounds"), getConversionLambda("PoundsToUSTons"))

fun main(args: Array<String>) {
    var addFive: (Int) -> Int = { x -> x + 5 }
    println("Pass 6 to addFive: ${addFive(6)}")

    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts.invoke(6, 7)
    println("Pass 6, 7 to addInts: $result")

    val intLambda: (Int, Int) -> Int = { x: Int, y: Int -> x * y }
    println("Pass 10, 11 to intLambda: ${intLambda.invoke(10, 11)}")

    val addSeven: (Int) -> Int = { it + 7 }
    println("Pass 12 to addSeven: ${addSeven(12)}")

    val myLambda: () -> Unit = { println("Hi!") }
    myLambda()

    val five = convertFive { it * 1.8 + 32 }
    println("5 is converted to: $five")

    // val fahrenheit = convert(20.0, getConversionLambda("CentigradeToFahrenheit"))
    val fahrenheit: Double = convertCentigradeToFahrenheit(20.0)
    println("20.0 centigrade is converted to: $fahrenheit")

    val pounds = getConversionLambda("KgsToPounds")(2.5)
    println("2.5 kgs to pounds is: $pounds")

    // val inTons = combine(getConversionLambda("KgsToPounds"), getConversionLambda("PoundsToUSTons"))(1000.0)
    val inTons = kgsToTonsLambda(1000.0)
    println("1000 kgs to US tons is: $inTons")
}

// A type alias lets you provide an alternative name for an existing
// type. You define a type alias using typealias.
typealias DoubleConversion = (Double) -> Double

fun convertFive(converter: DoubleConversion): Double = converter(5.0)

fun convert(x: Double, converter: DoubleConversion): Double = converter(x)

// fun convertCentigradeToFahrenheit(x: Double) = convert(x) { c: Double -> c * 1.8 + 32 }
// fun convertCentigradeToFahrenheit(x: Double) = convert(x) { it * 1.8 + 32 }
fun convertCentigradeToFahrenheit(x: Double) = convert(x, getConversionLambda("CentigradeToFahrenheit"))

fun getConversionLambda(method: String): DoubleConversion {
    when (method) {
        "CentigradeToFahrenheit" -> return { it * 1.8 + 32 }
        "KgsToPounds" -> return { it * 2.204623 }
        "PoundsToUSTons" -> return { it / 2000.0 }
        else -> {
            return { it }
        }
    }
}

// this will combine two lambdas and return it
// as you can see, lambdas are extremely flexible and functional
// with a little practice and patience, you can do some really cool things
fun combine(
    lambda1: DoubleConversion,
    lambda2: DoubleConversion
): DoubleConversion = { lambda2(lambda1(it)) }
