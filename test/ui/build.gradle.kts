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
    compileOnly(OkHttp.client)
    compileOnly(Test.rxidler)
    compileOnly(Test.okReplay)
    compileOnly(AndroidX.Test.core)
    compileOnly(AndroidX.Test.espresso)
}
