plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("**/*.kt")
        ktlint(Versions.ktlint)
    }
}
