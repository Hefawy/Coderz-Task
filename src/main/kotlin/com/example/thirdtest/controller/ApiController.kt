package com.example.thirdtest.controller

import com.example.thirdtest.data.ResponseEntity
import com.example.thirdtest.model.Account
import com.example.thirdtest.model.Post
import com.example.thirdtest.service.AccountService
import com.example.thirdtest.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController (
    private val accountService: AccountService,
    private val postService: PostService
) {

    @PostMapping("/account")
    suspend fun createAccount(@RequestBody accountDTO: Account)
    :ResponseEntity<Account>{
        return accountService.createAccount(accountDTO)
    }

    @GetMapping("/account/{id}")
    suspend fun getAccount(@PathVariable id:Long)
        = accountService.findAccountById(id)

    @PostMapping("/post")
    suspend fun createPost(@RequestBody postDTO:Post)
    :ResponseEntity<Post>{
        return postService.createPost(postDTO)
    }

    @GetMapping("/user-posts/{accountId}")
    suspend fun getUserPosts(
        @PathVariable accountId: Int,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "50") size: Int ) =
        postService.findPostsByAccountId(accountId,page,size)
}