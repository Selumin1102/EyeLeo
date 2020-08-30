package org.eyeleo.app.ui.settings

import javafx.scene.Parent
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE
import org.eyeleo.app.settings.AppSettingsContainer
import org.springframework.stereotype.Component

@Component
class SettingWindowBuilder(
    private val appSettings: AppSettingsContainer,
    private val settingsTabBuilder: SettingsTabBuilder
) {
    fun buildAppSettingsWindow(): Parent {
        val appSettingsPanel = TabPane()

        val settingsTab = settingsTabBuilder.buildSettingsTab(appSettings.settings)
        val readmeTab = Tab("Информация")

        appSettingsPanel.tabs.addAll(settingsTab, readmeTab)

        appSettingsPanel.tabClosingPolicy = UNAVAILABLE

        return appSettingsPanel
    }
}
