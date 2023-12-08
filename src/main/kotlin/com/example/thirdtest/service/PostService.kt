package com.example.thirdtest.service

import com.example.thirdtest.data.ResponseEntity
import com.example.thirdtest.extension.toDTO
import com.example.thirdtest.extension.toEntity
import com.example.thirdtest.model.Post
import com.example.thirdtest.repository.PostRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository) {
    // TODO : remove unnecessary spaces
    suspend fun createPost(postDto: Post): ResponseEntity<Post> {
        val postEntity = postDto.toEntity()
        val createdPostEntity = postRepository.save(postEntity)
        val createdPostDTO = createdPostEntity.toDTO()
        return ResponseEntity(200, "Success", createdPostDTO)
    }

    suspend fun findPostsByAccountId(accountId: Int, page: Int, size: Int) =
        postRepository.findByAccountId(accountId, PageRequest.of(page, size))

}