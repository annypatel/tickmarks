plugins {
    tickmarks_android_library
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(AndroidX.extensions) // TODO
    implementation(Google.material)

    testImplementation(project(":test:ui"))
    testImplementation(Test.robolectric)
    testImplementation(AndroidX.Test.junit)
    testImplementation(AndroidX.Test.espresso)
}
