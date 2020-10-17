plugins {
    tickmarks_android_library
}

android {
    defaultConfig {
        javaCompileOptions.annotationProcessorOptions {
            arguments = mapOf("room.schemaLocation" to "$projectDir/schemas".toString())
        }
    }
}

dependencies {
    implementation(project(":base:data"))
    implementation(project(":bookmark:domain"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(Retrofit.client)
    implementation(RetroCrawler.jspoon)
    implementation(Room.runtime)
    implementation(Room.rx)
    kapt(Room.compiler)

    testImplementation(project(":test:data"))

    androidTestImplementation(AndroidX.Test.core)
    androidTestImplementation(AndroidX.Test.runner)
}
