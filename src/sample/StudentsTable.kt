package sample

import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.stage.Stage
import sample.pojo.StudentWithGroup


class StudentsTable : Stage() {

    init {
        val table = TableView<StudentWithGroup>()
        val id = TableColumn<StudentWithGroup, String>("id")
        val firstName = TableColumn<StudentWithGroup, String>("firstName")
        val secondName = TableColumn<StudentWithGroup, String>("secondName")
        val kurs = TableColumn<StudentWithGroup, String>("kurs")
        val groupName = TableColumn<StudentWithGroup, String>("groupName")



        table.columns.addAll(id, firstName, secondName, kurs, groupName)
        val root = Group()
        root.children.add(table)

        val scene = Scene(root, 450.0, 300.0)
        id.cellValueFactory = PropertyValueFactory<StudentWithGroup, String>("id")
        firstName.cellValueFactory = PropertyValueFactory<StudentWithGroup, String>("firstName")
        secondName.cellValueFactory = PropertyValueFactory<StudentWithGroup, String>("secondName")
        kurs.cellValueFactory = PropertyValueFactory<StudentWithGroup, String>("kurs")
        groupName.cellValueFactory = PropertyValueFactory<StudentWithGroup, String>("name")


        table.items = DatabaseManager.selectStudents()
        setScene(scene)
        show()
    }

}
