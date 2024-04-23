package com.example.trainingproj

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.cloud.openfeign.EnableFeignClients

@TestConfiguration
@EnableFeignClients("com.example.trainingproj")
class TestProjectConfig {

}