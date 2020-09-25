plugins {
    tickmarks_android_library
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    api(project(":base:ui"))
    api(project(":bookmark:domain"))
    api(project(":bookmark:data"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(Dagger.Android.runtime)
    kapt(Dagger.Android.compiler)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.fragment)
    implementation(AndroidX.extensions)
    implementation(Google.material)
    implementation(DataBinding.lint)

    testImplementation(project(":test-utils:ui"))
    testImplementation(Test.junit)
    testImplementation(Test.mockito)
    testImplementation(Test.robolectric)
    testImplementation(Test.bindingMapper)
    testImplementation(AndroidX.Test.junit)

    androidTestImplementation(project(":test-utils:ui"))
    androidTestImplementation(AndroidX.Test.core)
    androidTestImplementation(AndroidX.Test.runner)
    androidTestImplementation(AndroidX.Test.rules)
    androidTestImplementation(AndroidX.Test.espresso)
    androidTestImplementation(OkHttp.Test.mockWebServer)

    // for dagger generated code
    androidTestImplementation(project(":base:data"))
    kaptAndroidTest(Dagger.compiler)
    androidTestImplementation(Retrofit.client)
    androidTestImplementation(Room.runtime)
}
