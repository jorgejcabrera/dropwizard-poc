plugins {
    application
}

val dropwizardVersion = "2.0.28"
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