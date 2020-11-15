package org.eyeleo.app.breaks

import org.springframework.stereotype.Component

@Component
class BreakEventsMulticaster(
    private val shortBreakEventHandler: BreakEventHandler<BreakEvent.ShortBreak>
//    ,
//    private val longBreakEventHandler: BreakEventHandler<BreakEvent.LongBreak>
) {
    fun fireEvent(event: BreakEvent) {
        when (event) {
            is BreakEvent.ShortBreak -> shortBreakEventHandler.onEvent(event)
        }
    }
}
