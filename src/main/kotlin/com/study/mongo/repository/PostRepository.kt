package com.study.mongo.repository

import com.study.mongo.aggregate.Post

interface PostRepository : PostReadonlyRepository{
    fun save(post: Post) : Post
    fun update(post: Post): Post
    fun delete(post: Post)
}