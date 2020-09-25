plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Sdk.compile)
    defaultConfig {
        minSdkVersion(Versions.Sdk.min)
        targetSdkVersion(Versions.Sdk.target)
    }

    buildFeatures {
        dataBinding = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    api(Kotlin.jdk8)
    api(Rx.java)
    api(Rx.kotlin)
    api(Rx.android)
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(AndroidX.extensions)
    implementation(Google.material)
    implementation(DataBinding.lint)

    testImplementation(project(":test-utils:ui"))
    testImplementation(Test.junit)
    testImplementation(Test.mockito)
    testImplementation(Test.robolectric)
    testImplementation(AndroidX.Test.arch)
    testImplementation(AndroidX.Test.junit)
}
