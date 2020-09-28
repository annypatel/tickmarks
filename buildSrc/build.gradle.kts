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
    implementation("com.android.tools.build:gradle:4.0.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10") // Upgrading kotlin plugin? Update kotlin version in Dependencies.kt as well.
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.13.1") // Upgrading detekt plugin? Update detekt version in Dependencies.kt as well.
    implementation("com.github.ben-manes:gradle-versions-plugin:0.33.0")
    implementation("com.gladed.androidgitversion:gradle-android-git-version:0.4.13")
}