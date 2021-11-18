plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.android.tools.build:gradle:_")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:_")
    implementation("com.github.ben-manes:gradle-versions-plugin:_")
    implementation("com.gladed.androidgitversion:gradle-android-git-version:_")
    implementation("com.osacky.flank.gradle:fladle:_")
    implementation("com.google.gms:google-services:_")
    implementation("com.google.firebase:firebase-appdistribution-gradle:_")
    implementation("com.google.dagger:hilt-android-gradle-plugin:_")
}
