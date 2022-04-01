import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "to.dev.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    group = "to.dev.example"
    version = "1.0"

    apply(plugin = "kotlin")

    val junitVersion = "5.8.2"
    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks.test {
        useJUnitPlatform {
            includeEngines("junit-jupiter")
            excludeTags("integration-tests")
        }

        failFast = false
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
        testLogging {
            events = setOf(
                FAILED,
                PASSED,
                SKIPPED
            )
        }
    }
}