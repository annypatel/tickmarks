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
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(Dagger.Android.runtime)
    kapt(Dagger.Android.compiler)
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
    androidTestImplementation(Test.rxidler)
    androidTestImplementation(AndroidX.Test.core)
    androidTestImplementation(AndroidX.Test.runner)
    androidTestImplementation(AndroidX.Test.espresso)
    androidTestImplementation(OkHttp.Test.mockWebServer)

    // for dagger generated code
    androidTestImplementation(project(":base:data"))
    androidTestImplementation(project(":bookmark:data"))
    kaptAndroidTest(Dagger.compiler)
    androidTestImplementation(Retrofit.client)
    androidTestImplementation(Room.runtime)
}
