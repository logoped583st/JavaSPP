package sample

import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.input.MouseButton
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import sample.pojo.LessonsTeachersGroup


class LessonsTable : Stage() {

    var table: TableView<LessonsTeachersGroup> = TableView()

    init {
        val id = TableColumn<LessonsTeachersGroup, String>("id")
        val subject = TableColumn<LessonsTeachersGroup, String>("name")
        val language = TableColumn<LessonsTeachersGroup, String>("language")
        val teacherFirstName = TableColumn<LessonsTeachersGroup, String>("teacherFirstName")
        val teacherSecondName = TableColumn<LessonsTeachersGroup, String>("teacherSecondName")
        val deegree = TableColumn<LessonsTeachersGroup, String>("deegree")
        val groupName = TableColumn<LessonsTeachersGroup, String>("groupName")

        table.columns.addAll(id, subject, language, teacherFirstName, teacherSecondName, deegree, groupName)

        val root = GridPane()
        root.children.add(table)

        val lessonFilter = TextField()
        val teacherFilter = TextField()

        val lessonFilterBtn = Button("Name filter")
        val teacherFilterBtn = Button("Teacher filter")
        val clearFilter = Button("Clear filters")

//        val g1 = Group(listOf(lessonFilter,lessonFilterBtn))
//        val g2 = Group(listOf(teacherFilter,teacherFilterBtn))

        root.addRow(1,lessonFilter,lessonFilterBtn)
        root.addRow(2,teacherFilter,teacherFilterBtn)
        root.addRow(3,clearFilter)

        val scene = Scene(root, 800.0, 600.0)

        clearFilter.setOnMouseClicked {
            lessonFilter.text = ""
            teacherFilter.text = ""
            updated()
        }

        teacherFilterBtn.setOnMouseClicked {
            table.items = DatabaseManager.selectLessonsTeacherFilter(teacherFilter.text.toString())
        }

        lessonFilterBtn.setOnMouseClicked {
            table.items = DatabaseManager.selectLessonsNameFilter(lessonFilter.text.toString())
        }

        id.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("id")
        subject.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("name")
        language.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("language")
        teacherFirstName.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("teacherFirstName")
        teacherSecondName.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("teacherSecondName")
        deegree.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("deegree")
        groupName.cellValueFactory = PropertyValueFactory<LessonsTeachersGroup, String>("groupName")

        val contextMenu1 = ContextMenu()
        val item1 = MenuItem("Insert")
        contextMenu1.items.addAll(item1)



        table.setRowFactory { tv ->
            item1.setOnAction {
                InsertView(this)
            }
            val row = TableRow<LessonsTeachersGroup>()

            row.setOnMouseClicked { event ->
                val rowData = row.item
                if (event.clickCount == 2 && !row.isEmpty && event.button == MouseButton.PRIMARY) {
                    EditView(this, rowData)
                } else {
                    if (event.button == MouseButton.SECONDARY && !row.isEmpty) {
                        MyContextMenu(row.item.id).show(this)

                    } else if (event.button == MouseButton.SECONDARY && row.isEmpty) {
                        contextMenu1.show(this)
                    }
                }
            }
            row
        }

        table.items = DatabaseManager.selectLessons()
        setScene(scene)
        show()
    }

    fun updated() {
        table.items.clear()
        table.items = DatabaseManager.selectLessons()
    }

    inner class MyContextMenu(id: Int) : ContextMenu() {

        init {

            val item = MenuItem("Delete")
            item.setOnAction { event ->
                DatabaseManager.removeLesson(id)
                updated()
            }
            items.add(item)

        }

    }

}

