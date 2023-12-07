package com.example.thirdtest.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("account")
data class AccountEntity (
    @Id
    val id: Long,
    val username: String,
    val password: String,
    val name: String
)

data class Account (
    val id: Long,
    val username: String,
    val name: String
)

@Table("post")
data class PostEntity(
    @Id
    val id: Long? = null,
    val content: String,
    val creationDate: LocalDateTime,
    val accountId: Int
)

data class Post (
    val id: Long ?,
    val content: String,
    val creationDate: LocalDateTime,
    val accountId: Int
)

