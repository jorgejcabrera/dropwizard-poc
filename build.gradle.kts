plugins {
    kotlin("jvm") version "1.6.10"
}

group = "to.dev.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
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
}