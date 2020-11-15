package org.eyeleo.app.breaks

import org.eyeleo.app.breaks.BreakEvent.ShortBreak
import org.eyeleo.app.settings.AppSettingsContainer
import org.eyeleo.app.ui.breaks.ShortBreakPresenter
import org.springframework.stereotype.Component

@Component
class ShortBreakEventHandler(
    private val shortBreakPresenter: ShortBreakPresenter,
    private val appSettingsContainer: AppSettingsContainer
) : BreakEventHandler<ShortBreak> {
    override fun onEvent(event: ShortBreak) {
        val settings = appSettingsContainer.settings.shortBreakSettings
        for (i in settings.lengthSeconds downTo 0) {
            shortBreakPresenter.viewShortBreak(ShortBreakData(event.getHint(), i))
            Thread.sleep(1000)
            shortBreakPresenter.dismiss()
        }
    }
}