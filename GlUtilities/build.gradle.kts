import org.gradle.internal.os.OperatingSystem
import org.gradle.kotlin.dsl.*

val os = OperatingSystem.current()!!

val lwjglNatives = when {
    os.isWindows -> "natives-windows"
    os.isMacOsX -> "natives-macos"
    else -> "natives-linux"
}

val lwjglVersion = "3.1.2-SNAPSHOT"

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
    compile( "org.lwjgl:lwjgl-stb:$lwjglVersion")


    runtime("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
    runtime("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
    runtime("org.lwjgl:lwjgl-stb:$lwjglVersion:$lwjglNatives")


    testCompile("junit:junit:4.11")
}