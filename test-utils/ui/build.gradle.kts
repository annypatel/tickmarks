plugins {
    tickmarks_android_library
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
