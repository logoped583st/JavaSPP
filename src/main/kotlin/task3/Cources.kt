package com.test.task3

object Cources {
    val cources: ArrayList<Cource> = ArrayList()

    data class Cource(val name: String,
                      val timeHourse: Int,
                      val subject: String,
                      val description: String,
                      val teacher: Teacher,
                      val students:ArrayList<Student> = ArrayList()) {
        init {
            cources.add(this)
        }

        fun studentSubscribe(student: Student){
            students.add(student)
        }
    }
}