package org.eyeleo.app.ui.breaks

interface ShortBreakPresenter {
    fun viewShortBreakWindow(text: String, secondsLeft: Int)
    fun setSecondsLeft(secondsLeft: Int)
    fun dismiss()
}