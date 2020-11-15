package org.eyeleo.app.breaks

import org.eyeleo.app.settings.AppSettingsContainer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.concurrent.Executors.newSingleThreadScheduledExecutor
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

@Component
class BreaksSchedulingManager(
    private val appSettingsContainer: AppSettingsContainer,
    @Qualifier("shortBreaksExecutor") private val shortBreaksExecutor: ScheduledExecutorService,
    private val shortBreakEventCreator: BreakEventCreator<BreakEvent.ShortBreak>,
    private val breakEventsMulticaster: BreakEventsMulticaster
) {
    @EventListener(ApplicationStartedEvent::class)
    fun init() {
        val shortBreakSettings = appSettingsContainer.settings.shortBreakSettings
        shortBreaksExecutor.scheduleAtFixedRate(
            { breakEventsMulticaster.fireEvent(shortBreakEventCreator.createEvent()) },
            shortBreakSettings.intervalMinutes.toLong(),
            shortBreakSettings.intervalMinutes.toLong(),
            TimeUnit.MINUTES
        )
    }
}

@Configuration
class BreakSchedulersConfig {
    @Bean
    fun shortBreaksExecutor(): ScheduledExecutorService = newSingleThreadScheduledExecutor()
}