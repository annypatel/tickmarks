plugins {
    tickmarks_android_library
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
