plugins {
    application
    id("com.github.johnrengelman.shadow")
}

application {
    mainClassName = "to.dev.example.MainAppKt"
}
val dropwizardVersion: String by rootProject
dependencies {
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")
}

tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        archiveBaseName.set("dropwizard-poc")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "to.dev.example.MainAppKt"))
        }
    }
    named<JavaExec>("run") {
        args = listOf("server", "config/server_configuration.yaml")
    }
}



tasks.getByName<Test>("test") {
    useJUnitPlatform()
}