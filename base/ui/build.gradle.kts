plugins {
    tickmarks_android_library
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":base:domain"))
    implementation(Rx.android)
    implementation(AndroidX.viewModel)
    implementation(Google.material)

    testImplementation(project(":test:ui"))
    testImplementation(Test.robolectric)
    testImplementation(AndroidX.Test.junit)
    testImplementation(AndroidX.Test.espresso)
}
