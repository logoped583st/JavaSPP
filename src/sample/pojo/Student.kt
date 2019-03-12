package sample.pojo

data class Student(val id: Int, val firstName: String, val secondName: String,
                   val kurs: Int, val group: Int)

data class StudentWithGroup(val id: Int, val firstName: String, val secondName: String,
                            val kurs: Int, val idGroup: Int, val name: String, val dekanat: Int)

data class LessonsTeachersGroup(val id: Int, val name: String, val language:String, val teacherFirstName: String, val teacherSecondName: String,
                                val deegree: String, val groupName: String)

data class StudentGroup(val idGroup: Int, val name: String, val dekanat: Int)


data class Teacher(val id:Int, val teacherFirstName: String, val teacherSecondName: String,
                   val deegree: String )