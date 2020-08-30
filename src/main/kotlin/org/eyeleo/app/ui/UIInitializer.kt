package org.eyeleo.app.ui

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import org.eyeleo.app.ui.tray.TrayInitializer
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import javax.swing.SwingUtilities

@Component
class UIInitializer(
        private val trayInitializer: TrayInitializer
) {
    @EventListener(JavaFxApplicationCreatedEvent::class)
    fun initializeUI(event: JavaFxApplicationCreatedEvent) {
        val stage = event.getStage()

        SwingUtilities.invokeLater { trayInitializer.initTray(UIInitializationContext(stage)) }

//        stage.initStyle(StageStyle.TRANSPARENT)
//
//        val layout = StackPane(createContent())
//        layout.style = "-fx-background-color: rgba(255, 255, 255, 0.5);"
//        layout.setPrefSize(300.0, 200.0)
//
//        layout.onMouseClicked = EventHandler { stage.hide() }
//
//        val scene = Scene(layout)
//        scene.fill = Color.TRANSPARENT
//
//        stage.scene = scene
    }

    private fun createContent(): Node {
        val hello = Label("hello, world")
        hello.style = "-fx-font-size: 40px; -fx-text-fill: #228b22;"
        val instructions = Label("(click to hide)")
        instructions.style = "-fx-font-size: 12px; -fx-text-fill: orange;"
        val content = VBox(10.0, hello, instructions)
        content.alignment = Pos.CENTER
        return content
    }
}