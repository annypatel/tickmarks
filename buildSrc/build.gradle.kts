plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    // Upgrading kotlin plugin? Update kotlin version in Dependencies.kt as well.
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
    implementation("com.android.tools.build:gradle:4.0.1")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.33.0")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.5.2")
}