
allprojects {
    group = "com.cout970"
    version = "1.0"

//    repositories {
//        jcenter()
//        mavenCentral()
//    }
}

plugins {
    base
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}