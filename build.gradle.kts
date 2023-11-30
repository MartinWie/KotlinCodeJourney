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
        kotlin.srcDirs("LeetCode")
    }
    create("AdventOfCode") {
        kotlin.srcDirs("AdventOfCode")
    }
}

tasks.register<Test>("testLeetcode") {
    testClassesDirs = sourceSets["leetcode"].output.classesDirs
    classpath = sourceSets["leetcode"].runtimeClasspath
}

tasks.register<Test>("testAdventOfCode") {
    testClassesDirs = sourceSets["AdventOfCode"].output.classesDirs
    classpath = sourceSets["AdventOfCode"].runtimeClasspath
}

dependencies {
    val commonTestDependencies = listOf(
        "org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version",
        "org.junit.jupiter:junit-jupiter-api:5.8.1",
        "org.junit.jupiter:junit-jupiter-engine:5.8.1",
    )

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Apply common dependencies to LeetCode source set
    commonTestDependencies.forEach {
        "leetcodeImplementation"(it)
        "leetcodeRuntimeOnly"("ch.qos.logback:logback-classic:$logback_version")
    }

    // Apply common dependencies to AdventOfCode source set
    commonTestDependencies.forEach {
        "AdventOfCodeImplementation"(it)
        "AdventOfCodeRuntimeOnly"("ch.qos.logback:logback-classic:$logback_version")
    }
}
