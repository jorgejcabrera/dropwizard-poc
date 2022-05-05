package com.jjc.delivery.rest

import com.codahale.metrics.health.HealthCheck

class HealthCheck : HealthCheck() {

    @Throws(java.lang.Exception::class)
    override fun check(): Result {
        return Result.healthy()
    }
}