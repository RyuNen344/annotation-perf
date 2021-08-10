pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    plugins {
        id("com.google.devtools.ksp") version "1.5.21-1.0.0-beta06"
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
