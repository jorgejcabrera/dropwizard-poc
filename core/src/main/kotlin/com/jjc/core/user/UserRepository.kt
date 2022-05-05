package com.jjc.core.user

interface UserRepository {
    fun save(user: User): User
}

class UserRepositoryDump : UserRepository {
    override fun save(user: User): User {
        TODO("Not yet implemented")
    }

}