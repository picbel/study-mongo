package com.study.mongo.repository

import com.study.mongo.aggregate.Post
import com.study.mongo.repository.mongo.PostDao
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl(
    @Qualifier("postReadonlyRepositoryImpl") private val readonlyRepository: PostReadonlyRepository,
    private val postDao: PostDao
): PostRepository, PostReadonlyRepository by readonlyRepository {
    override fun save(post: Post): Post {
        return postDao.save(PostEntity.from(post))
    }

    override fun update(post: Post): Post {
        return (post.id?: throw IllegalArgumentException()).run {
            postDao.save(PostEntity.from(post))
        }
    }

    override fun delete(post: Post) {
        return (post.id?: throw IllegalArgumentException()).run {
            postDao.delete(PostEntity.from(post))
        }
    }
}
