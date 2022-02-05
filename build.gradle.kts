import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
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
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
    }
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
        filteringCharset = "UTF-8"
    }

    // 각별님 레포지토리 코드 남겨주셔서 감사합니다

    shadowJar {
        archiveBaseName.set(project.name)
        archiveClassifier.set("")
        archiveVersion.set("")
    }
    register<Jar>("outputJar") {
        from(shadowJar)
        into("./out")
    }
    register<Jar>("paperJar") {
        val plugins = File(rootDir, ".server/plugins/")
        into(if (File(plugins, archiveFileName.get()).exists()) File(plugins, "update") else plugins)
    }
}