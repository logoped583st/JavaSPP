package sample

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import sample.pojo.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement


object DatabaseManager {

    private val statement: Statement
    private val conn: Connection = DriverManager.getConnection("jdbc:h2:~/SPP", "logoped583", "")

    init {
        conn.autoCommit = true
        statement = conn.createStatement()
    }


    fun selectDekanats(): ObservableList<Dekanat> {
        val result = statement.executeQuery("SELECT * FROM DEKANAT")

        val data = FXCollections.observableArrayList<Dekanat>()

        while (result.next()) {
            //Iterate Row
            val dekanat = Dekanat(result.getInt(1), result.getString(2))
            data.add(dekanat)
            println("Row [1] added $dekanat")
        }

        return data
    }

    fun selectStudents(): ObservableList<StudentWithGroup> {
        val result = statement.executeQuery("SELECT * FROM STUDENT inner join GROUP_STUDENT GS on STUDENT.\"group_studing\" = GS.ID")

        val data = FXCollections.observableArrayList<StudentWithGroup>()

        while (result.next()) {
            //Iterate Row

            val studnetWithGroup = StudentWithGroup(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
                    result.getInt(5), result.getString(7), result.getInt(8))
            data.add(studnetWithGroup)
            println("Row [1] added $studnetWithGroup")
        }

        return data
    }

    fun selectLessons(): ObservableList<LessonsTeachersGroup> {
        val result = statement.executeQuery("SELECT * FROM LESONS inner join TEACHERS T on LESONS.\"teachers\" = T.ID inner join GROUP_STUDENT GS on LESONS.\"group_students\" = GS.ID")

        val data = FXCollections.observableArrayList<LessonsTeachersGroup>()

        while (result.next()) {
            //Iterate Row

            val lessonTeacherGroup = LessonsTeachersGroup(result.getInt(1), result.getString(2), result.getString(3), result.getString(8), result.getString(7),
                    result.getString(9), result.getString(12))
            data.add(lessonTeacherGroup)
            println("Row [1] added $lessonTeacherGroup")
        }
        return data
    }

    fun selectGroups(): ObservableList<StudentGroup> {
        val result = statement.executeQuery("SELECT * FROM GROUP_STUDENT")
        val data = FXCollections.observableArrayList<StudentGroup>()

        while (result.next()) {
            //Iterate Row
            val studentGroup = StudentGroup(result.getInt(1), result.getString(2), result.getInt(3))
            data.add(studentGroup)
            println("Row [1] added $studentGroup")
        }

        return data
    }

    fun selectTeachers(): ObservableList<Teacher> {
        val result = statement.executeQuery("SELECT * FROM TEACHERS")
        val data = FXCollections.observableArrayList<Teacher>()

        while (result.next()) {
            //Iterate Row
            val teacher = Teacher(result.getInt(1), result.getString(3), result.getString(2), result.getString(4))
            data.add(teacher)
            println("Row [1] added $teacher")
        }

        return data
    }

    fun removeLesson(id: Int) {
        val stat = conn.prepareStatement("DELETE FROM LESONS WHERE ID = ?")
        stat.setInt(1, id)
        stat.execute()
    }

    fun updateLesson(id: Int, name: String, language: String, group: Int, teacher: Int) {
        val stat = conn.prepareStatement("UPDATE LESONS SET NAME = ? , DESCRIPTION = ?, \"group_students\" = ?, \"teachers\" = ?  WHERE ID = ?")
        stat.setString(1, name)
        stat.setString(2, language)
        stat.setInt(3, group)
        stat.setInt(4, teacher)
        stat.setInt(5, id)
        stat.execute()
    }

    fun insertLesson(name: String, language: String, group: Int, teacher: Int) {
        val stat = conn.prepareStatement("INSERT INTO LESONS (NAME, DESCRIPTION, \"group_students\", \"teachers\") VALUES (? , ?, ?, ?)")
        stat.setString(1, name)
        stat.setString(2, language)
        stat.setInt(3, group)
        stat.setInt(4, teacher)
        stat.execute()
    }

    fun selectLessonsTeacherFilter(filter: String): ObservableList<LessonsTeachersGroup> {
        val stat = conn.prepareStatement("SELECT * FROM LESONS inner join TEACHERS T on LESONS.\"teachers\" = T.ID inner join GROUP_STUDENT GS on LESONS.\"group_students\" = GS.ID WHERE (T.FIRST_NAME LIKE ? or T.SECOND_NAME LIKE ?)")
        stat.setString(1,"%$filter%")
        stat.setString(2,"%$filter%")

        val result = stat.executeQuery()
        val data = FXCollections.observableArrayList<LessonsTeachersGroup>()

        while (result.next()) {
            //Iterate Row

            val lessonTeacherGroup = LessonsTeachersGroup(result.getInt(1), result.getString(2), result.getString(3), result.getString(8), result.getString(7),
                    result.getString(9), result.getString(12))
            data.add(lessonTeacherGroup)
            println("Row [1] added $lessonTeacherGroup")
        }
        return data

    }


    fun selectLessonsNameFilter(filter: String): ObservableList<LessonsTeachersGroup> {
        val stat = conn.prepareStatement("SELECT * FROM LESONS inner join TEACHERS T on LESONS.\"teachers\" = T.ID inner join GROUP_STUDENT GS on LESONS.\"group_students\" = GS.ID WHERE (LESONS.NAME LIKE ?)")
        stat.setString(1, "%$filter%")

        val result = stat.executeQuery()
        val data = FXCollections.observableArrayList<LessonsTeachersGroup>()

        while (result.next()) {
            //Iterate Row

            val lessonTeacherGroup = LessonsTeachersGroup(result.getInt(1), result.getString(2), result.getString(3), result.getString(8), result.getString(7),
                    result.getString(9), result.getString(12))
            data.add(lessonTeacherGroup)
            println("Row [1] added $lessonTeacherGroup")
        }
        return data

    }
}