import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}