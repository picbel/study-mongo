package com.study.mongo.repository

import com.study.mongo.aggregate.Post
import com.study.mongo.repository.mongo.PostDao
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PostReadonlyRepositoryImpl(
    private val postDao: PostDao
):PostReadonlyRepository {
    override fun findById(id: Long): Post {
        return postDao.findById(id).orElseGet { throw NoSuchElementException() }
    }
}
