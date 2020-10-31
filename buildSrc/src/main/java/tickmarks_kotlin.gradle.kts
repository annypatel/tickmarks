import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.Test as TestTask

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

// to run all unit tests in app with single command
tasks.register<TestTask>("testDebugUnitTest")

dependencies {
    implementation(Kotlin.jdk8)
    implementation(Rx.java)
    implementation(Hilt.core)
    kapt(Hilt.compiler)

    testImplementation(Test.junit)
    testImplementation(Test.mockito)
}
