import java.sql.DriverManager

class Main {
    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(a: Array<String>) {
            try {

                val conn = DriverManager.getConnection("jdbc:h2:./SPP", "logoped583", "")
                conn.autoCommit = true
                val statement = conn.createStatement()

                //INSERT
                statement.executeUpdate("INSERT INTO DEKANAT (NAME) VALUES ('FEIS')")
                statement.executeUpdate("INSERT INTO GROUP_STUDENT (NAME,DEKANA) VALUES ('PO-1',18)")
                statement.executeUpdate("INSERT INTO KAFEDRA (NAME, DESCRIPTION) VALUES ( 'IIT','iskustveny' )")
                statement.executeUpdate("INSERT INTO STUDENT(FIRST_NAME, SECOND_NAME, KURS, \"group_studing\") VALUES ( 'Stas','Bushuk',3,1)")
                statement.executeUpdate("INSERT INTO TEACHERS (FIRST_NAME, SECOND_NAME, DEGREE, KAFEDRA) VALUES ( 'Kroshenko','Alexander','Profy',4 )")
                statement.executeUpdate("INSERT INTO LESONS (NAME, DESCRIPTION, \"teachers\", \"group_students\") VALUES ( 'SPP', 'JAVA', 5, 1 )")
                statement.executeUpdate("INSERT INTO KAFEDRA_DEKANAT_MEDIATOR (DEKANAT, KAFEDRA) VALUES ( 18,4 )")

                statement.executeUpdate("UPDATE LESONS SET DESCRIPTION = 'KOTLIN!' where DESCRIPTION = 'JAVA'")
                statement.executeUpdate("UPDATE STUDENT SET FIRST_NAME = 'STANISLAU' where FIRST_NAME = 'Stas'")

                statement.executeUpdate("DELETE FROM STUDENT where FIRST_NAME = '!Stas'")


                val map: Map<String, String> = mutableMapOf()
                val result = statement.executeQuery("SELECT * FROM GROUP_STUDENT INNER JOIN STUDENT S on GROUP_STUDENT.ID = S.\"group_studing\"")
                while (result.next()) {
                   println(result.getString("FIRST_NAME")+" studing in"+ result.getString("NAME"))
                }

                statement.executeUpdate("")
                conn.close()
            } catch (e: Exception) {
                print(e.message + "ERROR")
            }

            // INSERT dekanat
            //  conn.prepareCall("INSERT INTO GROUP_STUDENT (NAME, DEKANA) VALUES ( 'PO-1','1' )").executeQuery()

            //  conn.prepareCall("INSERT INTO STUDENT (FIRST_NAME, SECOND_NAME, KURS, group_studing) VALUES ('Stanislau', 'Bushuk', 3, 1)").executeQuery()
        }

    }
}