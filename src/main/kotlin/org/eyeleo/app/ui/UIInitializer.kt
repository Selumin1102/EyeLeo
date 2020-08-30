package org.eyeleo.app.ui

import org.eyeleo.app.ui.tray.TrayInitializer
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import javax.swing.SwingUtilities

@Component
class UIInitializer(
        private val trayInitializer: TrayInitializer
) {
    @EventListener(JavaFxApplicationCreatedEvent::class)
    fun initializeUI(event: JavaFxApplicationCreatedEvent) {
        val stage = event.getStage()

        SwingUtilities.invokeLater { trayInitializer.initTray(UIInitializationContext(stage)) }
    }
}