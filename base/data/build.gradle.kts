plugins {
    tickmarks_android_library
}

dependencies {
    implementation(OkHttp.client)
    implementation(Retrofit.client)
    implementation(Retrofit.adapterRxJava)
    implementation(RetroCrawler.converterJspoon)
}
