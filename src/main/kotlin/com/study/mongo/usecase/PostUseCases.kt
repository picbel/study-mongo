package com.study.mongo.usecase

import com.study.mongo.aggregate.Post
import com.study.mongo.repository.PostRepository
import org.springframework.stereotype.Service


interface PostUseCases {
    fun save(post: Post): Post
    fun update(post: Post.Model): Post
}

@Service
class PostUseCasesImpl(
    private val postRepo: PostRepository
): PostUseCases{
    override fun save(post: Post): Post {
        return postRepo.save(post)
    }

    override fun update(post: Post.Model): Post {
        return postRepo.update(post)
    }

}
