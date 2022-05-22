package com.study.mongo.controller

import com.study.mongo.aggregate.Post
import com.study.mongo.usecase.PostUseCases
import com.study.mongo.util.model.PageDto
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


interface PostController {

    fun create(post: Post.Model) : ResponseEntity<Post>

    fun update(post: Post.Model) : ResponseEntity<Post>

    fun delete(id:Long, password:String) : ResponseEntity<*>

    fun get(id:Long) : ResponseEntity<Post>

    fun getAll(pageDto :PageDto) : ResponseEntity<Page<Post>>
}

@RestController
class PostControllerImpl(
    private val postUseCases: PostUseCases
):PostController{
    @PostMapping("/post")
    override fun create(post: Post.Model): ResponseEntity<Post> {
        return ResponseEntity.ok(postUseCases.save(post))
    }

    @PutMapping("/post")
    override fun update(post: Post.Model): ResponseEntity<Post> {
       return ResponseEntity.ok(postUseCases.update(post))
    }

    @DeleteMapping("/post/{id}")
    override fun delete(@PathVariable id:Long,@RequestParam password:String): ResponseEntity<*> {
        return ResponseEntity.ok(postUseCases.delete(id,password))
    }

    @GetMapping("/post/{id}")
    override fun get(@PathVariable id: Long): ResponseEntity<Post> {
        return ResponseEntity.ok(postUseCases.find(id))
    }

    @GetMapping("/post")
    override fun getAll(pageDto: PageDto): ResponseEntity<Page<Post>> {
        TODO("Not yet implemented")
    }


}
