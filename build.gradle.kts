plugins {
    kotlin("jvm") version "1.5.30"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    mavenCentral()
    maven("https://jitpack.io/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("com.github.monun:tap:3.7.1")
    implementation("io.github.monun:kommand:1.2.1")
}

tasks {
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
        filteringCharset = "UTF-8"
    }
    jar {
        archiveClassifier.set("dist")
        archiveVersion.set("")
    }
    create<Copy>("dist") {
        from (jar)
        into(".\\.server\\plugins")
    }
}