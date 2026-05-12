package com.telegram.sample.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@ConfigurationProperties(prefix = "telegram")
data class TelegramProperties(
    val botToken: String = ""
)

@Configuration
class TelegramConfig {

    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()
}
