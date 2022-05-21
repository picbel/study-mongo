package com.study.mongo.aggregate

interface Post {
    val id: Long?
    val title: String
    val content: String
    val writer: String
    val postPassword: String

    fun assertPassword(password:String)

    open class Model(
        override val id: Long?,
        override val title: String,
        override val content: String,
        override val writer: String,
        override val postPassword: String
    ):Post {
        override fun assertPassword(password:String) {
            if (postPassword != password) throw IllegalArgumentException()
        }
    }

}
