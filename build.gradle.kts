import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1" apply false
}

group = "to.dev.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.2.1") {
            exclude("org.jetbrains.kotlin:kotlin-reflect")
        }
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
    }
}

subprojects {
    group = "to.dev.example"
    version = "1.0"

    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        mavenCentral()
    }

    val junitVersion: String by rootProject
    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
    val copyNativeDeps by tasks.creating(Copy::class) {
        from(configurations.testRuntimeClasspath) {
            include("*.dylib")
            include("*.so")
            include("*.dll")
        }
        into("$buildDir/libs")
    }

    tasks.test {
        dependsOn(copyNativeDeps)
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