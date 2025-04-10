
plugins {
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.noarg") version "2.1.20"
    kotlin("plugin.serialization") version "2.1.20"
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
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.3")
}

kotlin {
    compilerOptions {
        languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_1)
        apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_1)
    }
}
