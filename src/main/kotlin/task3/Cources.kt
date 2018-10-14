package com.test.task3

object Cources {
    val cources: ArrayList<Cource> = ArrayList()

    class Cource(val name: String, val timeHourse: Int, val subject: String, val description: String, val teacher: Teacher) {
        init {
            cources.add(this)
        }
    }
}