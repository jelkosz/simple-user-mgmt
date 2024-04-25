package com.example.trainingproj

import feign.auth.BasicAuthRequestInterceptor
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@TestConfiguration
@EnableFeignClients("com.example.trainingproj")
class TestProjectConfig() {

    @Bean
    fun basicAuthRequestInterceptor(): BasicAuthRequestInterceptor = BasicAuthRequestInterceptor("testuser","pass")

}