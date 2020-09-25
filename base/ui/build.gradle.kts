plugins {
    tickmarks_android_library
}

android {
    buildFeatures {
        dataBinding = true
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
