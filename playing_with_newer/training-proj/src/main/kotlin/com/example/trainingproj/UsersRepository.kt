package com.example.trainingproj

import com.example.trainingproj.dto.UserDto
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UsersRepository : CrudRepository<UserDto, UUID> {

    fun findByName(username: String): UserDto?

}