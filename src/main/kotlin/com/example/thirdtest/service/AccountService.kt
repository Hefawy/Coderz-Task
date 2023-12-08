package com.example.thirdtest.service

import com.example.thirdtest.model.Account
import com.example.thirdtest.repository.AccountRepository
import org.springframework.stereotype.Service
import com.example.thirdtest.data.ResponseEntity
import com.example.thirdtest.extension.toDto
import com.example.thirdtest.extension.toEntity

@Service
class AccountService (private val accountRepository: AccountRepository){

// TODO : remove unnecessary spaces
    suspend fun createAccount(accountDTO: Account): ResponseEntity<Account> {

            val accountEntity = accountDTO.toEntity()
            val createdAccountEntity = accountRepository.save(accountEntity)
            val createdAccountDTO = createdAccountEntity.toDto()

            return ResponseEntity(200, "Success", createdAccountDTO)
    }

    suspend fun findAccountById(id: Long)= accountRepository.findById(id)

}