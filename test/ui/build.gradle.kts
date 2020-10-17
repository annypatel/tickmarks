plugins {
    tickmarks_android_library
}

dependencies {
    compileOnly(project(":base:ui"))
    compileOnly(project(":base:domain"))
    compileOnly(project(":base:data"))
    compileOnly(Rx.android) // TODO
    compileOnly(Dagger.runtime)
    kapt(Dagger.compiler)
    compileOnly(Google.material)

    compileOnly(AndroidX.appcompat)
    compileOnly(Test.rxidler)
    compileOnly(AndroidX.Test.core)
    compileOnly(AndroidX.Test.espresso)
    compileOnly(OkHttp.Test.mockWebServer)
}
