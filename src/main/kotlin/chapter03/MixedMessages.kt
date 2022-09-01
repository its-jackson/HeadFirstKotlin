package chapter03

fun main(args: Array<String>) {
    var x = 0
    var y = 20

    // Execute the inner loop 3 times.
    for (outer in 1..3) {
        // Outer loop concat 3 each iteration to x and then increments y by 1 for a full iteration / outer loop run.
        // 9 x 3 == full loop x and 21 x 3 == full loop y due to the fact
        // that the complete iteration of the inner loop x will be 9 and y 21 and outer 1.
        for (inner in 4 downTo 2) {
            // x += 6 ; x == 27 x 3 == 81 ; y == 23
            // x-- ; x == 18 ; y == 23
            y++
            x += 3
        }
        y -= 2
    }

    print("$x $y")
}