package com.test

import com.test.task3.Student
import com.test.task3.Teacher

class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            //val notePad = NotePad("name", "description")
            //notePad.capsDescription(0)
            //notePad.oneNodePadClass.capsDescription(0)
            //print(notePad.notePads[0].description)
            //val customString: CustomString = CustomString(Word(), Symbol())

            val teacher = Teacher("Alexander", "Kroshenko")
            teacher.createCource("Java", "Kurs po java dlia PO-1", "JAVA", 42)
            val student = Student("Stas", "Bushuk")
            student.subscribeToCource("Java")
            teacher.setOcenka(10, student, "Java")
        }
    }
}