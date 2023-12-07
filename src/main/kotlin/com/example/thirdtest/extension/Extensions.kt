package com.example.thirdtest.extension

import com.example.thirdtest.model.Account
import com.example.thirdtest.model.AccountEntity
import com.example.thirdtest.model.Post
import com.example.thirdtest.model.PostEntity
import java.time.LocalDateTime

fun Account.toEntity(): AccountEntity {
    return AccountEntity(
        id = this.id,
        username = this.username,
        password = "P@ssw0rd",
        name = this.name
    )
}

fun AccountEntity.toDto(): Account {
    return Account(
        id = this.id,
        username = this.username,
        name = this.name
    )
}

fun Post.toEntity(): PostEntity {
    return PostEntity(
        id = this.id,
        content = this.content,
        creationDate = this.creationDate,
        accountId = this.accountId
    )
}

fun PostEntity.toDTO(): Post {
    return Post(
        id = null,
        content = this.content,
        creationDate = LocalDateTime.now(),
        accountId = this.accountId
    )
}
