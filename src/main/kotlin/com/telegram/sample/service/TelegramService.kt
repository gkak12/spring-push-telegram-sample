package com.telegram.sample.service

import com.telegram.sample.config.TelegramProperties
import com.telegram.sample.dto.SendMessageRequest
import com.telegram.sample.dto.SendMessageResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class TelegramService(
    private val restTemplate: RestTemplate,
    private val telegramProperties: TelegramProperties
) {

    private val telegramApiUrl = "https://api.telegram.org/bot"

    fun sendMessage(request: SendMessageRequest): SendMessageResponse {
        val url = "$telegramApiUrl${telegramProperties.botToken}/sendMessage"

        val body = mapOf(
            "chat_id" to request.chatId,
            "text" to request.message
        )

        restTemplate.postForObject(url, body, Map::class.java)

        return SendMessageResponse(
            success = true,
            chatId = request.chatId,
            message = request.message
        )
    }
}
