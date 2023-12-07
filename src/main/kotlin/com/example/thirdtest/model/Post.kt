package com.example.thirdtest.model

import java.time.LocalDateTime

data class Post (
    val id: Long,
    val content: String,
    val creationDate: LocalDateTime
)