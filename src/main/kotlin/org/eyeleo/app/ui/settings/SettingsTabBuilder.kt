package org.eyeleo.app.ui.settings

import javafx.geometry.Pos
import javafx.scene.control.CheckBox
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.layout.HBox
import org.eyeleo.app.settings.AppSettings
import org.springframework.stereotype.Component

@Component
class SettingsTabBuilder {
    fun buildSettingsTab(settings: AppSettings): Tab {
        val firstCheckbox = CheckBox()
        val firstLabel1 = Label(" Делать большой перерыв каждые ")
        val firstChooseBox1 = ChoiceBox<String>().also {
            it.items.addAll("20 мин", "25 мин")
        }
        val firstLabel2 = Label(" на ")
        val firstChooseBox2 = ChoiceBox<String>().also {
            it.items.addAll("2 мин", "5 мин")
        }
        val firstRow = HBox(
            10.0, firstCheckbox, firstLabel1, firstChooseBox1, firstLabel2, firstChooseBox2
        )
        firstRow.alignment = Pos.CENTER
        return Tab("Настройки", firstRow)
    }
}