package com.study.mongo.usecase

import com.study.mongo.aggregate.Post
import com.study.mongo.repository.PostRepository
import org.springframework.stereotype.Service


interface PostUseCases {
    fun save(post: Post): Post
    fun update(post: Post): Post
    fun delete(id: Long, password: String): Boolean
    fun find(id: Long): Post
}

@Service
class PostUseCasesImpl(
    private val postRepo: PostRepository
): PostUseCases{
    override fun save(post: Post): Post {
        return postRepo.save(post)
    }

    override fun update(post: Post): Post {
        return (post.id?: throw IllegalArgumentException()).let { id ->
            postRepo.findById(id).let {
                it.assertPassword(post.postPassword)
                postRepo.update(post)
            }
        }
    }

    override fun delete(id: Long, password: String): Boolean {
        return (postRepo.findById(id)).let {
            it.assertPassword(password)
            postRepo.delete(it)
        }.run {
            true
        }
    }

    override fun find(id: Long): Post {
        return postRepo.findById(id)
    }

}
