
import org.gradle.kotlin.dsl.archives
import org.gradle.kotlin.dsl.base
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.java

allprojects {
    group = "com.cout970"
    version = "1.0.7"
}

plugins {
    base
    java
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}