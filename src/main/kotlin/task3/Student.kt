package com.test.task3

class Student(override val firstName: String, override val secondName: String) : BaseUser() {

    val cources: ArrayList<Cources.Cource> = ArrayList()

    fun subscribeToCource(courceName: String) {
        Cources.cources.forEach {
            if (it.name == courceName) {
                cources.add(it)
                Cources.cources[Cources.cources.indexOf(it)].studentSubscribe(this)
            }
        }
    }
}