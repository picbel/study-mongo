package com.study.mongo.repository.mongo

import com.study.mongo.repository.PostEntity
import org.springframework.data.repository.CrudRepository

interface PostDao: CrudRepository<PostEntity,Long> {
}