package org.eyeleo.app.ui.views

import javafx.geometry.Pos
import tornadofx.*

class SettingsView : Fragment() {
    override val root = tabpane {
        tab("Настройки") {
            titledpane("Общие") {
                hbox {
                    add(vbox(spacing = 30, alignment = Pos.BASELINE_LEFT) {

                    })
                    add(vbox {

                    })
                }

            }
//            graphic = ImageIcon(javaClass.getResource("/images/icon.png"), "EyeLeo")
        }
    }
}