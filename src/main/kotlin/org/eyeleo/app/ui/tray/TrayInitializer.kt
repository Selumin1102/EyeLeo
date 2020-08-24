package org.eyeleo.app.ui.tray

import javafx.application.Platform
import org.eyeleo.app.ui.UIInitializationContext
import org.eyeleo.app.ui.showAtFront
import org.springframework.stereotype.Component
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon
import javax.swing.ImageIcon

@Component
class TrayInitializer(
    private val trayPopupMenuInitializer: TrayPopupMenuInitializer
) {
    fun initTray(context: UIInitializationContext) {
        Toolkit.getDefaultToolkit()

        if (!SystemTray.isSupported()) {
            Platform.exit()
        }

        val tray: SystemTray = SystemTray.getSystemTray()

        val trayIcon = TrayIcon(ImageIcon(javaClass.getResource("/images/icon.png"), "EyeLeo").image)
        trayIcon.addActionListener { Platform.runLater { context.stage.showAtFront() } }

        trayPopupMenuInitializer.initPopupMenu(TrayInitializationContext(context.stage, tray, trayIcon))

        tray.add(trayIcon)
    }
}