package org.eyeleo.app.ui.breaks

import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.stage.Stage
import org.eyeleo.app.breaks.ShortBreakData
import org.springframework.stereotype.Component

@Component
class ShortBreakView : ShortBreakPresenter {
    private lateinit var stage: Stage
    override fun viewShortBreak(data: ShortBreakData) {
        val panel = HBox(Label(data.hint), Label(data.secondsLeft.toString()))
        val scene = Scene(panel)
        Platform.runLater {
            stage = Stage()
            stage.scene = scene
            stage.show()
        }
    }

    override fun dismiss() {
        Platform.runLater {
            stage.close()
        }
    }
}
