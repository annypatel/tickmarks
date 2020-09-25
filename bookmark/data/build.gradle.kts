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
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions.annotationProcessorOptions {
            arguments = mapOf("room.schemaLocation" to "$projectDir/schemas".toString())
        }
    }
}

dependencies {
    api(project(":base:data"))
    api(project(":bookmark:domain"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(Retrofit.client)
    implementation(RetroCrawler.jspoon)
    implementation(Room.runtime)
    implementation(Room.rx)
    kapt(Room.compiler)

    testImplementation(project(":test-utils:data"))
    testImplementation(Test.junit)
    testImplementation(Test.mockito)

    androidTestImplementation(AndroidX.Test.core)
    androidTestImplementation(AndroidX.Test.runner)
}
