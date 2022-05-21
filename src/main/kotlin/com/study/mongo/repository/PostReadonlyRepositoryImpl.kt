package com.study.mongo.repository

import com.study.mongo.repository.mongo.PostDao
import org.springframework.stereotype.Repository

@Repository
class PostReadonlyRepositoryImpl(
    private val postDao: PostDao
) {
}
