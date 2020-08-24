package org.eyeleo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class EyeLeoApplication

fun main() {
    SpringApplicationBuilder(EyeLeoApplication::class.java)
            .headless(false)
            .run()
}
