plugins {
    tickmarks_android_library
}

dependencies {
    implementation(OkHttp.client)
    debugImplementation(OkHttp.logging)
    implementation(Retrofit.client)
    implementation(Retrofit.adapterRxJava)
    implementation(RetroCrawler.converterJspoon)
}
