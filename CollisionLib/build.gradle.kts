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