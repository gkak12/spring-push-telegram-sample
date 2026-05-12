package com.telegram.sample

import com.telegram.sample.config.TelegramProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(TelegramProperties::class)
class SpringPushTelegramSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringPushTelegramSampleApplication>(*args)
}
