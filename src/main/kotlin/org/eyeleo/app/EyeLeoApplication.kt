package org.eyeleo.app

import javafx.application.Application
import org.eyeleo.app.ui.UIApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication
@ConfigurationPropertiesScan
class EyeLeoApplication

fun main() {
    Application.launch(UIApplication::class.java)
}
