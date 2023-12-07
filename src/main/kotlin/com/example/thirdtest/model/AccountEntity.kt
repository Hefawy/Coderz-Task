package com.example.thirdtest.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("account")
data class AccountEntity (

    @Id
    val id: Long,
    val username: String,
    val password: String,
    val name: String
)