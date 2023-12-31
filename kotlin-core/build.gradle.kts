import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.noarg") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

noArg {
    annotation("com.toy.basic.common.NoArg")
    invokeInitializers = true
}

group = "com.toy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.vdurmont:emoji-java:5.1.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.0")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.9"
    freeCompilerArgs = listOf("-Xcontext-receivers")
}
