package com.test.task3

class Teacher(override val firstName: String, override val secondName: String) : BaseUser() {

    val teacherCource: ArrayList<Cources.Cource> = ArrayList()

    fun setOcenka(ocenka: Int, student: Student, courceName: String) {

        var cource: Cources.Cource? = null
        teacherCource.forEach {
            if (it.name == courceName) {
                cource = it
                return@forEach
            }
        }
        if (cource != null) {
            Archive.OneArchive(ocenka, student, cource!!)
        }
    }

    fun createCource(name: String, description: String, subject: String, timeHours: Int) {
        val cource = Cources.Cource(name, timeHours, subject, description, this)
        Cources.cources.add(cource)
        teacherCource.add(cource)
    }

}