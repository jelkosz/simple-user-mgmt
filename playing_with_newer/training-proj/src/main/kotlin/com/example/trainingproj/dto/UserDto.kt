package com.example.trainingproj.dto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.UUID

@Entity(name="users")
data class UserDto(
    @Id @GeneratedValue
    val id: UUID,

    val name: String) {

    constructor() : this(UUID.randomUUID(), "")

}