package com.example.thirdtest.repository

import com.example.thirdtest.model.Account
import com.example.thirdtest.model.AccountEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AccountRepository: CoroutineCrudRepository<AccountEntity,Long> {

     // TODO : findById Is already defined and implemented in CoroutineCurdRepository !
     // be aware of reactive data
     override suspend fun findById(id: Long): AccountEntity?
}