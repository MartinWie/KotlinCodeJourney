val kotlin_version: String by project
val logback_version: String by project

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.20-Beta"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

group = "de.mw"
version = "0.0.1"

repositories {
    mavenCentral()
}

sourceSets {
    create("leetcode") {
        kotlin.srcDir("LeetCode")
    }
}

dependencies {
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    "leetcodeImplementation"("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    "leetcodeRuntimeOnly"("ch.qos.logback:logback-classic:$logback_version")
}
