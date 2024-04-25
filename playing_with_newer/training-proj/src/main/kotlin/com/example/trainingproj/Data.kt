package com.example.trainingproj

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import java.util.*

@Entity(name="users")
data class UserDto(
    @Id @GeneratedValue
    val id: UUID,

    val name: String) {

    constructor() : this(UUID.randomUUID(), "")
}

interface UsersRepository : CrudRepository<UserDto, UUID> {

    fun findByName(username: String): UserDto?

}