package org.eyeleo.app.ui

import javafx.application.Application
import javafx.application.Platform
import javafx.stage.Stage
import org.eyeleo.app.EyeLeoApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ApplicationEvent
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
class UIApplication: Application() {
    private lateinit var context: ConfigurableApplicationContext

    override fun init() {
        context = SpringApplicationBuilder(EyeLeoApplication::class.java).headless(false).run()
    }

    override fun start(stage: Stage) {
        Platform.setImplicitExit(false)
        context.publishEvent(JavaFxApplicationCreatedEvent(stage))
    }

    override fun stop() {
        context.close()
    }
}

class JavaFxApplicationCreatedEvent( stage: Stage) : ApplicationEvent(stage) {
    fun getStage() = getSource() as Stage
}
