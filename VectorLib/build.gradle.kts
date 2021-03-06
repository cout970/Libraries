import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
    mavenCentral()
    maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    compile(kotlin("stdlib"))
    testCompile("org.joml:joml:1.9.3-SNAPSHOT")
    testCompile("junit:junit:4.11")
}

tasks {
    "sourceJar"(Jar::class) {
        from(java.sourceSets["main"].allSource, java.sourceSets["main"].output)
    }
    "build"{
        dependsOn("sourceJar")
    }
}