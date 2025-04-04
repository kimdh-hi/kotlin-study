
plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.noarg") version "2.1.0"
    kotlin("plugin.serialization") version "2.1.0"
}

noArg {
    annotation("com.toy.basic.common.NoArg")
    invokeInitializers = true
}

group = "com.toy"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.commons:commons-math3:3.6.1")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.0")
}

kotlin {
    compilerOptions {
        languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_1)
        apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_1)
    }
}
