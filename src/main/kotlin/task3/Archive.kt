package com.test.task3

object Archive {

    private val arhives: ArrayList<OneArchive> = ArrayList()

    data class OneArchive(val ocenka: Int, val student: Student, val cource: Cources.Cource) {

        init {
            arhives.add(this)
        }
    }
}
