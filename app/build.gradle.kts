plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Sdk.compile)
    defaultConfig {
        minSdkVersion(Versions.Sdk.min)
        targetSdkVersion(Versions.Sdk.target)
        applicationId = "tickmarks.app"
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":bookmark:ui"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(Dagger.Android.runtime)
    kapt(Dagger.Android.compiler)
    implementation(AndroidX.appcompat)
    implementation(DataBinding.lint)

    // for dagger generated code
    implementation(Retrofit.client)
    implementation(Room.runtime)
}
