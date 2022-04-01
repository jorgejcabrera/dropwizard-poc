package to.dev.example.rest

import com.codahale.metrics.health.HealthCheck

class HealthCheck : HealthCheck() {

    @Throws(java.lang.Exception::class)
    override fun check(): Result {
        println("Processing healtcheck")
        return Result.healthy()
    }
}