package com.jjc.delivery

import com.jjc.core.user.CreateUserUseCase
import com.jjc.core.user.UserRepositoryDump
import com.jjc.delivery.rest.CalculatorComponent
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import com.jjc.delivery.rest.HealthCheck
import com.jjc.delivery.rest.UserCreationController

//TODO revisar GUICE para inyectar dependencias
class CalculatorApp : Application<CalculatorConfig>() {

    override fun run(configuration: CalculatorConfig, environment: Environment) {
        val calculatorComponent = CalculatorComponent()
        val userRepository = UserRepositoryDump()
        val userCreateUserUseCase = CreateUserUseCase(userRepository)
        val userCreationController = UserCreationController(userCreateUserUseCase)

        val healthCheck = HealthCheck()
        environment.healthChecks().register("health", healthCheck)
        environment.jersey().register(calculatorComponent)
        environment.jersey().register(userCreationController)
    }
}