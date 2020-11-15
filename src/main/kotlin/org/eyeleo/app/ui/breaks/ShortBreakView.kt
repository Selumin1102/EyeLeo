package org.eyeleo.app.ui.breaks

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.effect.GaussianBlur
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import org.springframework.stereotype.Component

@Component
class ShortBreakView : ShortBreakPresenter {
    private lateinit var stage: Stage
    private lateinit var secondsLeftLabel: Label

    override fun viewShortBreakWindow(text: String, secondsLeft: Int) {
        secondsLeftLabel = Label(secondsLeft.toString())
        val root = StackPane()
        root.style = "-fx-background-color: black;"
        val blur = GaussianBlur() // 55 is just to show edge effect more clearly.
        root.effect = blur

        val panel = HBox(Label(text), secondsLeftLabel)
        panel.setPrefSize(100.0, 100.0)
        panel.alignment = Pos.CENTER
        root.children.add(panel)
        val scene = Scene(root)

        //        panel.setOnAction{ scene.fill = if (scene.fill == Color.BLACK) null else Color.BLACK }

        Platform.runLater {
            stage = Stage()
            stage.isFullScreen = true
            stage.scene = scene
            stage.show()
        }
    }

    override fun setSecondsLeft(secondsLeft: Int) {
        Platform.runLater {
            secondsLeftLabel.text = secondsLeft.toString()
        }
    }

    override fun dismiss() {
        Platform.runLater {
            stage.close()
        }
    }
}
