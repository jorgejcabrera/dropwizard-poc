package to.dev.example

import CalculatorComponent
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class CalculatorApp : Application<CalculatorConfig>() {
    override fun run(configuration: CalculatorConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val calculatorComponent = CalculatorComponent()
        environment.jersey().register(calculatorComponent)
    }
}