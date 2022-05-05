package com.jjc.delivery.rest

import com.fasterxml.jackson.annotation.JsonProperty
import com.jjc.core.user.CreateUserUseCase
import com.jjc.core.user.User
import javax.inject.Inject
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/user")

class UserCreationController @Inject constructor(private val createUserUseCase: CreateUserUseCase) {

    @POST
    fun register(userCreationBody: UserCreationBody): Double {
        createUserUseCase(userCreationBody.toModel())
        return 2.0
    }
}

data class UserCreationBody(
    @JsonProperty("first_name") val firstName: String = "",
    @JsonProperty("last_name") val lastName: String = ""
) {

    fun toModel(): User {
        return User(firstName = this.firstName, lastName = this.lastName)
    }
}