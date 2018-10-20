package com.test.Task2

class Bicyrcle(override val peopleCount: Int,
               override val gruz: Int,
               override val coustForOneTrip: Int) : Transport() {

    override val hoursForOneTrip: Double
        get() = 3.0

    override val peopleForOneTrip: Int
        get() = 2

    override val gruzForOneTrip: Int
        get() = 1


}