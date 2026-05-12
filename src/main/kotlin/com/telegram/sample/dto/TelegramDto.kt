package com.telegram.sample.dto

data class SendMessageRequest(
    val chatId: String,
    val message: String
)

data class SendMessageResponse(
    val success: Boolean,
    val chatId: String,
    val message: String
)
