plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.noarg") version "1.8.0"
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
}