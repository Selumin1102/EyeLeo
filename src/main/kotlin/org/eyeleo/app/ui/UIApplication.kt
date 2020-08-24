package org.eyeleo.app.ui

import javafx.application.Application
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.StageStyle
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.awt.*
import javax.swing.ImageIcon
import javax.swing.SwingUtilities

@Component
class UIApplication: Application() {
    private lateinit var stage: Stage

    override fun start(stage: Stage) {
        this.stage = stage

        Platform.setImplicitExit(false)

        SwingUtilities.invokeLater { addAppToTray() }

        stage.initStyle(StageStyle.TRANSPARENT)

        // create the layout for the javafx stage.

        // create the layout for the javafx stage.
        val layout = StackPane(createContent())
        layout.style = "-fx-background-color: rgba(255, 255, 255, 0.5);"
        layout.setPrefSize(300.0, 200.0)

        // this dummy app just hides itself when the app screen is clicked.
        // a real app might have some interactive UI and a separate icon which hides the app window.

        // this dummy app just hides itself when the app screen is clicked.
        // a real app might have some interactive UI and a separate icon which hides the app window.
        layout.onMouseClicked = EventHandler { stage.hide() }

        // a scene with a transparent fill is necessary to implement the translucent app window.

        // a scene with a transparent fill is necessary to implement the translucent app window.
        val scene = Scene(layout)
        scene.fill = Color.TRANSPARENT

        stage.scene = scene
    }

    private fun createContent(): Node {
        val hello = Label("hello, world")
        hello.setStyle("-fx-font-size: 40px; -fx-text-fill: #228b22;")
        val instructions = Label("(click to hide)")
        instructions.setStyle("-fx-font-size: 12px; -fx-text-fill: orange;")
        val content = VBox(10.0, hello, instructions)
        content.alignment = Pos.CENTER
        return content
    }

    fun showStage() {
        stage.show();
        stage.toFront();
    }

    private fun addAppToTray() {
        Toolkit.getDefaultToolkit()

        if (!SystemTray.isSupported()) {
            Platform.exit()
        }

        val tray: SystemTray = SystemTray.getSystemTray()

        val trayIcon = TrayIcon(ImageIcon(javaClass.getResource("/images/icon.png"), "EyeLeo").image)
        trayIcon.addActionListener { Platform.runLater { showMenu() } }

        val openItem = MenuItem("hello, world")
        openItem.addActionListener { Platform.runLater { showStage() } }

        val exitItem = MenuItem("Exit")
        exitItem.addActionListener {
            Platform.exit()
            tray.remove(trayIcon)
        }

        val popup = PopupMenu()
        popup.add(openItem)
        popup.addSeparator()
        popup.add(exitItem)
        trayIcon.popupMenu = popup

        tray.add(trayIcon)
    }

    private fun showMenu() {

    }

    @EventListener(ApplicationStartedEvent::class)
    fun launchApp() {
        launch()
    }
}