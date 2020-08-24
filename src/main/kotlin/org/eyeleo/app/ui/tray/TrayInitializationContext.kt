package org.eyeleo.app.ui.tray

import javafx.stage.Stage
import java.awt.SystemTray
import java.awt.TrayIcon

data class TrayInitializationContext(val stage: Stage, val tray: SystemTray, val trayIcon: TrayIcon)