package sample

import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Control
import javafx.scene.input.MouseEvent
import javafx.stage.Stage


class Main : Application(), EventHandler<MouseEvent> {

    override fun handle(p0: MouseEvent) {

        when ((p0.source as Control).id) {
            "btn_dekanat" -> {
                DekanatTable()
            }
            "btn_kafedra" -> {
            }
            "btn_lesons" -> {
                LessonsTable()
            }
            "btn_students" -> {
                StudentsTable()
            }
            "btn_teachers" -> {
            }
            "btn_groups" -> {

            }
        }
    }

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("sample.fxml"))
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 300.0, 275.0)

        primaryStage.show()
        primaryStage.scene.apply {
            (lookup("#btn_dekanat") as Button).onMouseClicked = this@Main
            (lookup("#btn_kafedra") as Button).onMouseClicked = this@Main
            (lookup("#btn_lesons") as Button).onMouseClicked = this@Main
            (lookup("#btn_students") as Button).onMouseClicked = this@Main
            (lookup("#btn_teachers") as Button).onMouseClicked = this@Main
            (lookup("#btn_groups") as Button).onMouseClicked = this@Main
        }
    }

    companion object {
        fun main(args: Array<String>) {
            Application.launch(*args)
        }
    }
}
