
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project

val root = project {

    name = "Libraries"
    group = "com.cout970"
    artifactId = name
    version = "0.0.1"
    directory = "Libraries"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }
}

val vectorLib = project() {

    name = "VectorLib"
    group = "com.cout970"
    artifactId = name
    version = "0.0.1"
    directory = "VectorLib"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependenciesTest {
        compile("org.jetbrains.spek:spek-api:1.0.89")
    }

    assemble {
        jar {  }
    }
}

//this lib still requires quite a bit of work
val matrixLib = project(vectorLib) {

    name = "MatrixLib"
    group = "com.cout970"
    artifactId = name
    version = "0.0.3"
    directory = "MatrixLib"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependenciesTest {
        compile("org.jetbrains.spek:spek-api:1.0.89")
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-gradle-plugin:1.0.3")
    }

    assemble {
        jar {  }
    }
}

val raytraceLib = project(vectorLib) {

    name = "RaytraceLib"
    group = "com.cout970"
    artifactId = name
    version = "0.0.1"
    directory = "RaytraceLib"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependenciesTest {
        compile("org.jetbrains.spek:spek-api:1.0.89")
    }

    assemble {
        jar {  }
    }
}

val objLib = project(vectorLib) {

    name = "ObjLib"
    group = "com.cout970"
    artifactId = name
    version = "0.0.1"
    directory = "ObjLib"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependenciesTest {
        compile("org.jetbrains.spek:spek-api:1.0.89")
    }

    assemble {
        jar {  }
    }
}

val collisionLib = project(vectorLib) {

    name = "CollisionLib"
    group = "com.cout970"
    artifactId = name
    version = "0.0.1"
    directory = "CollisionLib"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependenciesTest {
        compile("org.jetbrains.spek:spek-api:1.0.89")
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-gradle-plugin:1.0.3")
    }

    assemble {
        jar {  }
    }
}

val glUtilitiesLib = project(vectorLib, matrixLib) {

    name = "GlUtilities"
    group = "com.cout970"
    artifactId = name
    version = "0.0.2"
    directory = "GlUtilities"
    buildDirectory = "../"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/main/kotlin")
        path("src/test/kotlin")
    }

    dependenciesTest {
        compile("org.jetbrains.spek:spek-api:1.0.89",//doesn't work :(
                "org.jetbrains.spek:spek-junit-platform-engine:1.0.89",
                "org.testng:testng:6.9.9")
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-gradle-plugin:1.0.3",
                "org.lwjgl:lwjgl:3.0.0")
    }

    assemble {
        jar {  }
    }
}