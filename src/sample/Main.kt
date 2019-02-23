package sample

import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlin.concurrent.thread

class Main : Application() {

    lateinit var pauseOrResumeButton: Button
    lateinit var playButton: Button
    lateinit var stopButton: Button
    lateinit var label: Text
    lateinit var inputField: TextField
    lateinit var thread: Thread
    @Volatile
    var isRuning = false

    companion object {
        fun main(args: Array<String>) {
            Application.launch(*args)
        }
    }

    var stepPassed = 0
    var initValue: Float = 0.0F
    var stepCount = 0

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("sample.fxml"))
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 300.0, 275.0)
        setupUi(primaryStage.scene)
        primaryStage.show()
    }

    fun setupUi(scene: Scene) {
        scene.apply {
            pauseOrResumeButton = lookup("#btn_pause_resume") as Button
            playButton = lookup("#btn_play") as Button
            stopButton = lookup("#btn_stop") as Button
            inputField = lookup("#n_param") as TextField

            label = lookup("#result_text") as Text
            pauseOrResumeButton.setOnMouseClicked {
                if (pauseOrResumeButton.text == "Pause") {
                    pauseOrResumeButton.text = "Resume"
                    isRuning = true

                } else {
                    pauseOrResumeButton.text = "Pause"
                    isRuning = false
                }
                playButton.isDisable = true
            }
            playButton.setOnMouseClicked {
                stepCount = inputField.text.toInt()
                stepPassed = 0
                initValue = 0.0F
                isRuning = false
                playButton.isDisable = true
                stopButton.isDisable = false
                pauseOrResumeButton.isDisable = false

                calculateFunction()
            }
            stopButton.setOnMouseClicked {
                playButton.isDisable = false
                stepPassed = 0
                initValue = 0.0F
                stepCount = 0
                pauseOrResumeButton.isDisable = true
                stopButton.isDisable = true
                isRuning = true
            }
        }

    }


    fun calculateFunction() {
        thread = thread {

            for (i in stepPassed..stepCount) {
                while (isRuning){}
                var stepFactorial: Long = 1
                for (g in 1..i) {
                    stepFactorial *= g.toLong()
                }
                // stepPassed++
                println(Thread.currentThread().name + Thread.currentThread().id + "Thread")
                initValue += 1/stepFactorial.toFloat()

                Platform.runLater {
                    println(Thread.currentThread().name + Thread.currentThread().id + "Thread")
                    label.text = initValue.toString()
                }

                try {
                    Thread.sleep(1000)
                } catch (ex: InterruptedException) {
                    //excep
                }

            }
        }
    }
}
