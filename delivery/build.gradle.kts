plugins {
    application
}

val dropwizardVersion: String by rootProject
dependencies {
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")
    implementation(project(":infrastructure"))
    implementation(project(":core"))
}

tasks {
    named<JavaExec>("run") {
        args = listOf("server", "config/server_configuration.yaml")
    }
}

apply(plugin = "application")

application {
    mainClassName = "com.jjc.delivery.MainAppKt"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}