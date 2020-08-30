package org.eyeleo.app.settings

import org.springframework.stereotype.Component

@Component
class AppSettingsContainer(@Volatile var settings: AppSettings = AppSettings())