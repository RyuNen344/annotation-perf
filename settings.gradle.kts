pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    plugins {
        id("com.google.devtools.ksp") version "1.4.32-1.0.0-alpha08"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

rootProject.name = "AnnotationPerf"
include(
    ":app",
    ":db",
    ":feature:dagashi",
    ":feature:simple",
    ":feature:sunflower",
    ":feature:tivi",
)
