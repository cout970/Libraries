import org.gradle.internal.os.OperatingSystem
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*

val os = OperatingSystem.current()!!

val lwjglNatives = when {
    os.isWindows -> "natives-windows"
    os.isMacOsX -> "natives-macos"
    else -> "natives-linux"
}

version = "1.0.5"
val lwjglVersion = "3.1.6-SNAPSHOT"

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
    compile(kotlin("stdlib"))

    compile("org.lwjgl:lwjgl:$lwjglVersion")
    compile("org.lwjgl:lwjgl-glfw:$lwjglVersion")
    compile("org.lwjgl:lwjgl-opengl:$lwjglVersion")
    compile("org.lwjgl:lwjgl-stb:$lwjglVersion")

    compile("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
    compile("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
    compile("org.lwjgl:lwjgl-opengl:$lwjglVersion:$lwjglNatives")
    compile("org.lwjgl:lwjgl-stb:$lwjglVersion:$lwjglNatives")


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