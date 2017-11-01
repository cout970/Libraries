import org.gradle.internal.os.OperatingSystem
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
    compile(project(":VectorLib"))
    compile(project(":MatrixLib"))
    compile(project(":CollisionLib"))
    compile(project(":ObjLib"))
    compile(project(":RaytraceLib"))
    compile(project(":GlUtilities"))
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