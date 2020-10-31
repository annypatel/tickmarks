plugins {
    tickmarks_android_library
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":base:ui"))
    implementation(project(":base:domain"))
    implementation(project(":bookmark:domain"))
    implementation(AndroidX.appcompat)
    implementation(AndroidX.fragment)
    implementation(Google.material)

    testImplementation(project(":test:ui"))
    testImplementation(project(":test:domain"))
    testImplementation(Test.robolectric)
    testImplementation(Test.bindingMapper)
    testImplementation(AndroidX.Test.junit)
    testImplementation(AndroidX.Test.espresso)

    androidTestImplementation(project(":test:ui"))
    androidTestImplementation(Hilt.Test.runtime)
    kaptAndroidTest(Hilt.compiler)
    androidTestImplementation(Test.rxidler)
    androidTestImplementation(AndroidX.Test.core)
    androidTestImplementation(AndroidX.Test.runner)
    androidTestImplementation(AndroidX.Test.espresso)
    androidTestImplementation(OkHttp.Test.mockWebServer)

    // for generated code
    androidTestImplementation(project(":base:data"))
    androidTestImplementation(project(":bookmark:data"))
    androidTestImplementation(Retrofit.client)
    androidTestImplementation(Room.runtime)
}
