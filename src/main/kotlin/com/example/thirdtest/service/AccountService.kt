package com.example.thirdtest.service

import com.example.thirdtest.extension.AccountConversion
import com.example.thirdtest.model.Account
import com.example.thirdtest.repository.AccountRepository
import org.springframework.stereotype.Service
import com.example.thirdtest.data.ResponseEntity

@Service
class AccountService (private val accountRepository: AccountRepository){

    suspend fun createAccount(accountDTO: Account): ResponseEntity<Account> {
        val accountEntity = AccountConversion.toEntity(accountDTO)
        val createdAccountEntity = accountRepository.save(accountEntity)
        val createdAccountDTO = AccountConversion.toDto(createdAccountEntity)
        return ResponseEntity(200, "Success", createdAccountDTO)
    }


    suspend fun findAccountById(id : Long): ResponseEntity<Account>{
        val accountEntity = accountRepository.findById(id)
        return if(accountEntity != null){
            val accountDTO = AccountConversion.toDto(accountEntity)
            ResponseEntity(200,"Success",accountDTO)
        }else{
            return ResponseEntity(404,"Not Found",null)
        }
    }
}