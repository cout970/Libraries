import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
    mavenCentral()
}


dependencies {
    compile(project(":VectorLib"))
    compile(project(":MatrixLib"))
    compile(kotlin("stdlib"))
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