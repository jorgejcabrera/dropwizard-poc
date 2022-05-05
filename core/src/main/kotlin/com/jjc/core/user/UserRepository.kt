package com.jjc.core.user

interface UserRepository {
    fun save(user: User): User
}