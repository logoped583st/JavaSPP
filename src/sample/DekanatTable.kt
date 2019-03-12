package sample

import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.stage.Stage
import sample.pojo.Dekanat


class DekanatTable : Stage() {

    init {
        val table = TableView<Dekanat>()
        val userNameCol = TableColumn<Dekanat, String>("id")
        val emailCol = TableColumn<Dekanat, String>("name")
        table.columns.addAll(userNameCol, emailCol)
        val root = Group()
        root.children.add(table)
        val scene = Scene(root, 450.0, 300.0)

        userNameCol.cellValueFactory = PropertyValueFactory<Dekanat, String>("id")
        emailCol.cellValueFactory = PropertyValueFactory<Dekanat, String>("name")
        table.items = DatabaseManager.selectDekanats()
        setScene(scene)
        show()


    }

}
