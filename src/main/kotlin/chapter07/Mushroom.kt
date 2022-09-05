package chapter07

/*
Rarely do you use a secondary constructor, since the primary constructor can have default values.
The primary constructor allows for named arguments or passing values in order of declaration.
 */
class Mushroom(val size: Int, isMagic: Boolean) {
    constructor(isMagic_param: Boolean) : this(0, isMagic_param) {
        // Code that executes when the secondary constructor is invoked
    }
}