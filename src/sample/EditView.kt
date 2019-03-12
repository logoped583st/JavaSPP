package sample

import javafx.collections.FXCollections
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage
import sample.pojo.LessonsTeachersGroup

class EditView(val lessonsTable: LessonsTable, val lessonsTeachersGroup: LessonsTeachersGroup) : Stage() {

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
            (lookup("#lbl_id") as Label).text = lessonsTeachersGroup.id.toString()
            btnUpdate = (lookup("#btn_update") as Button)

            show()
        }
        lessonsTeachersGroup.let {
            name.text = it.name
            language.text = it.language

            val groupNames = FXCollections.observableArrayList<String>(listOfGroup.map { it.name })
            group.items = groupNames
            group.value = lessonsTeachersGroup.groupName

            val teacherNames = FXCollections.observableArrayList<String>(listOfTeachers.map { "${it.teacherFirstName} ${it.teacherSecondName}" })
            teacher.items = teacherNames
            teacher.value = lessonsTeachersGroup.teacherFirstName + " " + lessonsTeachersGroup.teacherSecondName
        }

        btnUpdate.setOnMouseClicked {
            DatabaseManager.updateLesson(lessonsTeachersGroup.id, name.text.toString(), language.text.toString(),
                    listOfGroup[group.selectionModel.selectedIndex].idGroup, listOfTeachers[teacher.selectionModel.selectedIndex].id)

            lessonsTable.updated()
            this.hide()
        }
    }

}
