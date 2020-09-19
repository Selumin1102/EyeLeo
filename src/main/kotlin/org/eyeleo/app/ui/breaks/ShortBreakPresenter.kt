package org.eyeleo.app.ui.breaks

import org.eyeleo.app.breaks.ShortBreakData

interface ShortBreakPresenter {
    fun viewShortBreak(data: ShortBreakData)
    fun dismiss()
}