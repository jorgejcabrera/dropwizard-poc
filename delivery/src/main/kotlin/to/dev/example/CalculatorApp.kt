package to.dev.example

import CalculatorComponent
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import to.dev.example.rest.HealthCheck


class CalculatorApp : Application<CalculatorConfig>() {
    override fun run(configuration: CalculatorConfig, environment: Environment) {
        val calculatorComponent = CalculatorComponent()
        val healthCheck = HealthCheck()
        environment.healthChecks().register("health", healthCheck)
        environment.jersey().register(calculatorComponent)
    }
}