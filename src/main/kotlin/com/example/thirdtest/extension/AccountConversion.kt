package com.example.thirdtest.extension

import com.example.thirdtest.model.Account
import com.example.thirdtest.model.AccountEntity

class AccountConversion {
    companion object{
        fun toEntity(accountDTO: Account):AccountEntity{
            return AccountEntity(
                id = accountDTO.id,
                username = accountDTO.username,
                password = "P@ssw0rd",
                name = accountDTO.name
            )
        }

        fun toDto(accountEntity: AccountEntity):Account{
            return Account(
                id = accountEntity.id,
                username = accountEntity.username,
                name = accountEntity.name
            )
        }
    }
}