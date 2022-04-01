plugins {
    application
    kotlin("jvm")
    java
}

group = "to.dev.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val dropwizardVersion = "2.0.28"
apply(plugin = "application")

application {
    mainClassName = "to.dev.example.MainAppKt"
}

tasks {
    named<JavaExec>("run") {
        args = listOf("server", "config/server_configuration.yaml")
    }
}
dependencies {
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}