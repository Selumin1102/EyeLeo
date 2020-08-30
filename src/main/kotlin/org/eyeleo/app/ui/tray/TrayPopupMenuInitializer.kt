package org.eyeleo.app.ui.tray

import javafx.application.Platform
import javafx.scene.Scene
import javafx.stage.Stage
import org.eyeleo.app.ui.settings.SettingWindowBuilder
import org.eyeleo.app.ui.showAtFront
import org.springframework.stereotype.Component
import java.awt.*

@Component
class TrayPopupMenuInitializer(
    private val trayPopupMenuStrings: TrayPopupMenuStrings,
    private val settingsWindowBuilder: SettingWindowBuilder
) {
    fun initPopupMenu(context: TrayInitializationContext) {
        val (stage, tray, trayIcon) = context

        val openSettingsMenuItem = buildOpenSettingsMenuItem(stage)
        val disableForMenuItem = buildDisableForMenuItem()
        val takeABreakNowMenuItem = buildTakeABreakNowMenuItem()
        val exitMenuItem = buildExitMenuItem(tray, trayIcon)

        val popup = PopupMenu()
        popup.add(openSettingsMenuItem)
        popup.add(disableForMenuItem)
        popup.add(takeABreakNowMenuItem)
        popup.addSeparator()
        popup.add(exitMenuItem)
        trayIcon.popupMenu = popup
    }

    private fun buildOpenSettingsMenuItem(stage: Stage): MenuItem =
        MenuItem(trayPopupMenuStrings.openSettings).also {
            it.addActionListener {
                val appSettingsWindow = settingsWindowBuilder.buildAppSettingsWindow()
                Platform.runLater {
                    stage.scene = Scene(appSettingsWindow)
                    stage.title= "EyeLeo настройки"
                    stage.resizableProperty().set(false)
                    stage.showAtFront()
                }
            }
        }

    private fun buildDisableForMenuItem(): MenuItem =
        Menu(trayPopupMenuStrings.disableFor).also {
            val disableForHour = MenuItem(trayPopupMenuStrings.disableForHour)
            val disableFor3Hours = MenuItem(trayPopupMenuStrings.disableFor3Hours)

            it.add(disableForHour)
            it.add(disableFor3Hours)
        }

    private fun buildTakeABreakNowMenuItem(): MenuItem = MenuItem(trayPopupMenuStrings.takeABreakNow)
    private fun buildExitMenuItem(tray: SystemTray, trayIcon: TrayIcon): MenuItem =
        MenuItem(trayPopupMenuStrings.exit).also {
            it.addActionListener {
                Platform.exit()
                tray.remove(trayIcon)
            }
        }
}