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
}

dependencies {
    implementation(project(":base:ui"))
    implementation(project(":base:domain"))
    implementation(project(":base:data"))
    implementation(Google.material)
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)

    implementation(AndroidX.appcompat)
    implementation(Test.rxidler)
    implementation(AndroidX.Test.core)
    implementation(AndroidX.Test.espresso)
    implementation(OkHttp.Test.mockWebServer)
}
