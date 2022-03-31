package to.dev.example

import io.dropwizard.Configuration

fun main(args: Array<String>) {
    CalculatorApp().run(*args) // use collection as a varargs
}
class CalculatorConfig(val name: String = "unknown") : Configuration()
