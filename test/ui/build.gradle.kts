plugins {
    tickmarks_android_library
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    compileOnly(project(":base:domain"))
    compileOnly(Rx.android)
    compileOnly(AndroidX.appcompat)
    compileOnly(Google.material)
    compileOnly(Test.rxidler)
    compileOnly(AndroidX.Test.core)
    compileOnly(AndroidX.Test.espresso)
    compileOnly(OkHttp.Test.mockWebServer)
}
