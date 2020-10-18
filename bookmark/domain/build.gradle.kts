plugins {
    tickmarks_kotlin
}

dependencies {
    implementation(project(":base:domain"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)

    testImplementation(project(":test:domain"))
}
