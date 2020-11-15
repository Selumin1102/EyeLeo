package org.eyeleo.app.breaks

interface BreakEventCreator<T : BreakEvent> {
    fun createEvent(): T
}