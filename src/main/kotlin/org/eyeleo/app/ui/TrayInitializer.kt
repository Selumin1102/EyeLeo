package org.eyeleo.app.ui

import javafx.application.Platform
import javafx.stage.Stage
import org.springframework.stereotype.Component
import java.awt.*
import javax.swing.ImageIcon

@Component
class TrayInitializer {
    fun initTray(stage: Stage) {
        Toolkit.getDefaultToolkit()

        if (!SystemTray.isSupported()) {
            Platform.exit()
        }

        val tray: SystemTray = SystemTray.getSystemTray()

        val trayIcon = TrayIcon(ImageIcon(javaClass.getResource("/images/icon.png"), "EyeLeo").image)
        trayIcon.addActionListener { Platform.runLater { showStage(stage) } }

        val openItem = MenuItem("hello, world")
        openItem.addActionListener { Platform.runLater { showStage(stage) } }

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

    fun showStage(stage: Stage) {
        stage.show();
        stage.toFront();
    }
}