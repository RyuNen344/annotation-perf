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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.room:room-runtime:2.3.0")
    ksp("androidx.room:room-compiler:2.3.0")
}
