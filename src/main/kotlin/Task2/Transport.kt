package com.test.Task2

abstract class Transport {

    abstract val peopleCount: Int

    abstract val gruz: Int

    abstract val coustForOneTrip: Int

    abstract val peopleForOneTrip: Int

    abstract val gruzForOneTrip: Int

    abstract val hoursForOneTrip: Double

    fun getTimeForTrip(): Double {
        val hoursForPeople = Math.ceil((peopleCount / peopleForOneTrip).toDouble())
        val hoursForGruz = Math.ceil((gruz / gruzForOneTrip).toDouble())
        return if (hoursForGruz > hoursForPeople) {
            hoursForGruz
        } else {
            hoursForPeople
        }
    }

    fun getCoust(): Double {
        return getTimeForTrip() * coustForOneTrip
    }
}