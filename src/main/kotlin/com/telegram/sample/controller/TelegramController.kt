package com.telegram.sample.controller

import com.telegram.sample.dto.SendMessageRequest
import com.telegram.sample.dto.SendMessageResponse
import com.telegram.sample.service.TelegramService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/telegram")
class TelegramController(
    private val telegramService: TelegramService
) {

    @PostMapping("/send")
    fun sendMessage(@RequestBody request: SendMessageRequest): ResponseEntity<SendMessageResponse> {
        val response = telegramService.sendMessage(request)
        return ResponseEntity.ok(response)
    }
}
