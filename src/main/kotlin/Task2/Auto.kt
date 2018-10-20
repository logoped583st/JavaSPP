package com.test.Task2

class Auto(override val peopleCount: Int,
           override val gruz: Int,
           override val coustForOneTrip: Int) : Transport() {

    override val hoursForOneTrip: Double
        get() = 0.5

    override val peopleForOneTrip: Int
        get() = 5

    override val gruzForOneTrip: Int
        get() = 5


}