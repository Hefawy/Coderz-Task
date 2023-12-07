package com.example.thirdtest.repository

import com.example.thirdtest.model.Account
import com.example.thirdtest.model.AccountEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AccountRepository: CoroutineCrudRepository<AccountEntity,Long> {

     override suspend fun findById(id: Long): AccountEntity?
}