package com.example.thirdtest.extension

import com.example.thirdtest.model.Post
import com.example.thirdtest.model.PostEntity

class PostConversion {
    companion object{

        fun toEntity(postDTO:Post):PostEntity{
           return PostEntity(
                id = postDTO.id,
               content = postDTO.content,
               creationDate = postDTO.creationDate,
               accountId = 0
            )
        }

        fun toDTO(postEntity: PostEntity):Post{
            return Post(
                id = postEntity.id,
                content = postEntity.content,
                creationDate = postEntity.creationDate
            )
        }
    }
}