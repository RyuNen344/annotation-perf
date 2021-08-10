plugins {
    id("com.android.library")
    kotlin("android")
//    kotlin("kapt")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 29
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":feature:dagashi"))
    api(project(":feature:simple"))
    api(project(":feature:sunflower"))
    api(project(":feature:tivi"))

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    implementation("androidx.paging:paging-common-ktx:3.0.1")
    implementation("androidx.room:room-ktx:2.4.0-alpha04")
    ksp("androidx.room:room-compiler:2.4.0-alpha04")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
}
