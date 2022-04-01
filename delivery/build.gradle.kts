plugins {
    application
}

val dropwizardVersion: String by rootProject
dependencies {
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")
}

tasks {
    named<JavaExec>("run") {
        args = listOf("server", "config/server_configuration.yaml")
    }
}

apply(plugin = "application")

application {
    mainClassName = "to.dev.example.MainAppKt"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}