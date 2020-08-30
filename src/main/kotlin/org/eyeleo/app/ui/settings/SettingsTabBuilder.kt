package org.eyeleo.app.ui.settings

import javafx.scene.control.CheckBox
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import org.eyeleo.app.settings.AppSettings
import org.springframework.stereotype.Component

@Component
class SettingsTabBuilder {
    fun buildSettingsTab(settings: AppSettings): Tab {
        val panel = VBox(
            10.0,
            buildFirstRow(),
            buildSecondRow(),
            buildThirdRow(),
            buildFourthRow(),
            buildFifthRow(),
            buildSixthRow(),
            buildSeventhRow(),
            buildEightRow()
        ).also {
            it.fillWidthProperty().set(true)
        }
        return Tab("Настройки", panel)
    }
}

private fun buildFirstRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Делать большой перерыв каждые")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 мин", "25 мин")
        it.value = "20 мин"
    }
    val firstLabel2 = Label("на")
    val firstChooseBox2 = ChoiceBox<String>().also {
        it.items.addAll("2 мин", "5 мин")
    }
    val row = HBox(
        10.0, firstCheckbox, firstLabel1, firstChooseBox1, firstLabel2, firstChooseBox2
    )
    row.isFillHeight = true

    return row
}

private fun buildSecondRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}

private fun buildThirdRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}

private fun buildFourthRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}

private fun buildFifthRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}

private fun buildSixthRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}

private fun buildSeventhRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}

private fun buildEightRow(): HBox {
    val firstCheckbox = CheckBox()
    val firstLabel1 = Label("Предупреждать о большом перерыве за")
    val firstChooseBox1 = ChoiceBox<String>().also {
        it.items.addAll("20 сек", "30 сек")
    }
    val row = HBox(10.0, firstCheckbox, firstLabel1, firstChooseBox1)
    row.isFillHeight = true

    return row
}