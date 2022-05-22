package com.study.mongo.repository

import com.study.mongo.aggregate.Post
import org.springframework.data.annotation.Id

class PostEntity(
    @Id
    override val id: Long?,
    override val title: String,
    override val content: String,
    override val writer: String,
    override val postPassword: String
) : Post.Model(
    id, title, content, writer, postPassword
){
    companion object {
        fun from(src: Post): PostEntity = with(src) {
            PostEntity(
                id = id,
                title = title,
                content = content,
                writer = writer,
                postPassword = postPassword
            )
        }
    }
}