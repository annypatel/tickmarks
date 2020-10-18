plugins {
    tickmarks_android_library
}

dependencies {
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(OkHttp.client)
    implementation(Retrofit.client)
    implementation(Retrofit.adapterRxJava)
    implementation(RetroCrawler.converterJspoon)
}
