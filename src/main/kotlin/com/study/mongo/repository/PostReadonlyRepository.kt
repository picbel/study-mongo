package com.study.mongo.repository

import com.study.mongo.aggregate.Post

interface PostReadonlyRepository {
    fun findById(id:Long): Post
}