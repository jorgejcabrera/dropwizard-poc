package com.jjc.core.user

class CreateUserUseCase(private val userRepository: UserRepository) {

    operator fun invoke(user: User) {
        userRepository.save(user)
    }
}