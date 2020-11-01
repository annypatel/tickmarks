plugins {
    tickmarks_kotlin
}

dependencies {
    implementation(project(":base:domain"))

    testImplementation(project(":test:domain"))
}
