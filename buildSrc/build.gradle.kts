plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.1.0")
    // Upgrading kotlin plugin? Update kotlin version in Dependencies.kt as well.
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
    // Upgrading detekt plugin? Update detekt version in Dependencies.kt as well.
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.13.1")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.33.0")
    implementation("com.gladed.androidgitversion:gradle-android-git-version:0.4.13")
    implementation("com.osacky.flank.gradle:fladle:0.12.1")
    implementation("com.google.gms:google-services:4.3.4")
    implementation("com.google.firebase:firebase-appdistribution-gradle:2.0.1")
}
