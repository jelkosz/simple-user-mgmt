package com.example.trainingproj

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService (val usersRepository: UsersRepository) {

    fun loadUsers(): Iterable<UserDto> = usersRepository.findAll()

    fun saveUser(user: UserDto): UserDto {
        ensureUniqueUserName(user.name)
        return usersRepository.save(user)
    }

    fun loadUserById(id: UUID): UserDto {
        return usersRepository.findById(id).orElseThrow { UserNotFoundException("User with id $id not found") }
    }

    fun updateUser(uuid: UUID, user: UserDto): UserDto {
        ensureUniqueUserName(user.name)
        return usersRepository.save(user.copy(id = uuid))
    }

    fun ensureUniqueUserName(name: String) {
        usersRepository.findByName(name) == null || throw UserManipulationException("User with name $name already exists.")
    }
}