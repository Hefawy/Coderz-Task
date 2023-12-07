package com.example.thirdtest.service

import com.example.thirdtest.data.ResponseEntity
import com.example.thirdtest.extension.PostConversion
import com.example.thirdtest.model.Post
import com.example.thirdtest.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository) {

    suspend fun createPost(postDto:Post):ResponseEntity<Post>{
        val postEntity = PostConversion.toEntity(postDto)
        val createdPostEntity = postRepository.save(postEntity)
        val createdPostDTO = PostConversion.toDTO(createdPostEntity)
        return ResponseEntity(200,"Success",createdPostDTO)
    }

    suspend fun findPostsByAccountId(accountId: Int, page: Int, size: Int)
    : ResponseEntity<Flow<Post>> {
        val effectivePageable = PageRequest.of(page, size)
        val userPosts = postRepository.findByAccountId(accountId,effectivePageable)
        val userPostsDTO = userPosts.map { PostConversion.toDTO(it) }
        return ResponseEntity(200,"Success",userPostsDTO)
    }
}