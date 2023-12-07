package com.example.thirdtest.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("post")
data class PostEntity (
    @Id
    val id: Long,
    val content: String,
    val creationDate: LocalDateTime,
    val accountId: Int
)