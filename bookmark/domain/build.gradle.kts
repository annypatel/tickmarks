plugins {
    tickmarks_kotlin
}

dependencies {
    api(project(":base:domain"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)

    testImplementation(project(":test-utils:domain"))
    testImplementation(Test.junit)
    testImplementation(Test.mockito)
}
