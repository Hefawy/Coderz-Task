package com.example.thirdtest.repository

import com.example.thirdtest.model.AccountEntity
import com.example.thirdtest.model.PostEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface PostRepository : CoroutineCrudRepository<PostEntity, Long> {
    fun findByAccountId(accountId: Int,pageable: Pageable): Flow<PostEntity>
}

interface AccountRepository: CoroutineCrudRepository<AccountEntity,Long> {

}