plugins {
    application
    kotlin("jvm") version "1.6.10"
}

group = "to.dev.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

apply(plugin = "application")

application {
    mainClassName = "to.dev.example.MainAppKt"
}

tasks {
    named<JavaExec>("run") {
        args = listOf("server", "config/local.yaml")
    }
}

val dropwizardVersion = "2.0.28"
dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")

}