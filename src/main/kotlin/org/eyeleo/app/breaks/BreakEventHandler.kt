package org.eyeleo.app.breaks

interface BreakEventHandler<T: BreakEvent> {
    fun onEvent(event: T)
}