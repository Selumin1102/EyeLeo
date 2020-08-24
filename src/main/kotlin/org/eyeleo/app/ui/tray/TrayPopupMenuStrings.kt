package org.eyeleo.app.ui.tray

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "eyeleo.strings.tray-menu")
data class TrayPopupMenuStrings(
    val openSettings: String,
    val disableFor: String,
    val disableForHour: String,
    val disableFor3Hours: String,
    val takeABreakNow: String,
    val exit: String
)