package org.eyeleo.app.settings

data class AppSettings(
    val longBreakSettings: LongBreakSettings = LongBreakSettings(),
    val shortBreakSettings: ShortBreakSettings = ShortBreakSettings(),
    val soundsEnabled: Boolean = true,
    val strictModeEnabled: Boolean = false,
    val closingOfNotificationsEnabled: Boolean = false,
    val haveAWindowNear: Boolean = true,
    val trackingActivityEnabled: Boolean = true
)

data class LongBreakSettings(
    val enabled: Boolean = true,
    val intervalMinutes: Int = 50,
    val lengthMinutes: Int = 5,
    val notificationEnabled: Boolean = true,
    val notifyDelaySeconds: Int = 30
)

data class ShortBreakSettings(
    val enabled: Boolean = true, val intervalMinutes: Int = 1, val lengthSeconds: Int = 8
)
