package com.study.mongo.controller

import com.study.mongo.aggregate.Post
import com.study.mongo.usecase.PostUseCases
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

interface PostController {
    fun create(
        @RequestBody post: Post.Model
    ) : ResponseEntity<Post>

    fun update(
        @RequestBody post: Post.Model
    ) : ResponseEntity<Post>

    fun delete() : ResponseEntity<*>

    fun get() : ResponseEntity<Post>

    fun getAll() : ResponseEntity<Page<Post>>
}

@RestController
class PostControllerImpl(
    private val postUseCases: PostUseCases
):PostController{
    override fun create(post: Post.Model): ResponseEntity<Post> {
        return ResponseEntity.ok(postUseCases.save(post))
    }

    override fun update(post: Post.Model): ResponseEntity<Post> {
       return ResponseEntity.ok(postUseCases.update(post))
    }

    override fun delete(): ResponseEntity<*> {
        TODO("Not yet implemented")
    }

    override fun get(): ResponseEntity<Post> {
        TODO("Not yet implemented")
    }

    override fun getAll(): ResponseEntity<Page<Post>> {
        TODO("Not yet implemented")
    }

}
