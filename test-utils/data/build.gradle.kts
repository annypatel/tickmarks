plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(Versions.Sdk.compile)
    defaultConfig {
        minSdkVersion(Versions.Sdk.min)
        targetSdkVersion(Versions.Sdk.target)
    }
}

dependencies {
    implementation(project(":base:data"))
}
