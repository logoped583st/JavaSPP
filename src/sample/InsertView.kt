package sample

import javafx.collections.FXCollections
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ChoiceBox
import javafx.scene.control.TextField
import javafx.stage.Stage

class InsertView(val lessonsTable: LessonsTable) : Stage() {

    val name: TextField
    val language: TextField
    val teacher: ChoiceBox<String>
    val group: ChoiceBox<String>
    val listOfGroup = DatabaseManager.selectGroups()
    val listOfTeachers = DatabaseManager.selectTeachers()
    val btnUpdate: Button

    init {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("edit_lessons.fxml"))
        title = "Edit"

        scene = Scene(root, 600.0, 300.0)
        scene.apply {
            name = (lookup("#area_name") as TextField)
            language = (lookup("#area_language") as TextField)
            teacher = (lookup("#spin_teacher") as ChoiceBox<String>)
            group = (lookup("#spin_group") as ChoiceBox<String>)
            btnUpdate = (lookup("#btn_update") as Button)

            show()
        }

        btnUpdate.text = "Insert"

        val groupNames = FXCollections.observableArrayList<String>(listOfGroup.map { it.name })
        group.items = groupNames

        val teacherNames = FXCollections.observableArrayList<String>(listOfTeachers.map { "${it.teacherFirstName} ${it.teacherSecondName}" })
        teacher.items = teacherNames


        btnUpdate.setOnMouseClicked {
            DatabaseManager.insertLesson(name.text.toString(), language.text.toString(),
                    listOfGroup[group.selectionModel.selectedIndex].idGroup, listOfTeachers[teacher.selectionModel.selectedIndex].id)
            lessonsTable.updated()
            this.hide()
        }
    }

}
