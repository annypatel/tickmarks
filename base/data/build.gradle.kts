plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Sdk.compile)
    defaultConfig {
        minSdkVersion(Versions.Sdk.min)
        targetSdkVersion(Versions.Sdk.target)
    }
}

dependencies {
    api(Kotlin.jdk8)
    api(Rx.java)
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(OkHttp.client)
    implementation(Retrofit.client)
    implementation(Retrofit.adapterRxJava)
    implementation(RetroCrawler.converterJspoon)

    testImplementation(Test.junit)
}
