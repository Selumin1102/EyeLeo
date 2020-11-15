package org.eyeleo.app.breaks

sealed class BreakEvent {
    sealed class ShortBreak : BreakEvent() {
        abstract fun getHint(): String

        object RotateEyes : ShortBreak() {
            override fun getHint() = "Вращйте глазами"
        }
    }

    sealed class LongBreak : BreakEvent() {
        object A: LongBreak()
    }
}
