package com.test.task3

object Archive {

    private val arhives: ArrayList<OneArchive> = ArrayList()

    fun getArhives(): ArrayList<OneArchive> = arhives

    class OneArchive(ocenka: Int, student: Student, cource: Cources.Cource) {

        init {
            arhives.add(this)
        }
    }
}
