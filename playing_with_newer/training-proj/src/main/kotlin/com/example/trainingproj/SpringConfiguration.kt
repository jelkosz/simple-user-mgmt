package com.example.trainingproj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@Configuration
class ProjectConfig {

}

@SpringBootApplication
class TrainingProjApplication

fun main(args: Array<String>) {
    runApplication<TrainingProjApplication>(*args)
}
