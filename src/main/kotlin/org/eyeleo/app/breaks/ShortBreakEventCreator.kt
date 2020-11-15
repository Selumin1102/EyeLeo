package org.eyeleo.app.breaks

import org.eyeleo.app.breaks.BreakEvent.ShortBreak
import org.eyeleo.app.breaks.BreakEvent.ShortBreak.A
import org.eyeleo.app.breaks.BreakEvent.ShortBreak.RotateEyes
import org.springframework.stereotype.Component

@Component
class ShortBreakEventCreator : BreakEventCreator<ShortBreak> {
    private val allEvents = listOf(RotateEyes, A)
    private val shownEvents = mutableListOf<ShortBreak>()

    override fun createEvent(): ShortBreak {
        if (allEvents.size == shownEvents.size) {
            shownEvents.clear()
        }
        val eventToFire = allEvents.minus(shownEvents).random()
        shownEvents.add(eventToFire)
        return eventToFire
    }
}