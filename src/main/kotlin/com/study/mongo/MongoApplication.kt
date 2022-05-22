package com.study.mongo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class MongoApplication

fun main(args: Array<String>) {
    runApplication<MongoApplication>(*args)
}
