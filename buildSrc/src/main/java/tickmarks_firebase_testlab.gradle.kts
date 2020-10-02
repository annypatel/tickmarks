@file:Suppress("MagicNumber")

import com.osacky.flank.gradle.FlankGradleExtension

// Fulladle plugin must br only applied to root project, so can't use plugins { } syntax.
rootProject.plugins.apply("com.osacky.fulladle")

configure<FlankGradleExtension> {
    serviceAccountCredentials.set(rootProject.file("gcloud-service-key.json"))
    resultsBucket = "staging.tickmarks-5b34c.appspot.com"
    devices = listOf(mapOf("model" to "Pixel2", "version" to "28"))
    repeatTests = 1
    flakyTestAttempts = 0
    disableSharding = true

    configs {
        // Use this to check if a test is flaky. Change the test target below and run
        // `./gradlew runFlankFlaky` to repeatedly run the test on firebase.
        // All filters supported by AndroidJUnitRunner are supported here as well. Refer -
        // https://developer.android.com/reference/android/support/test/runner/AndroidJUnitRunner
        create("flaky") {
            repeatTests = 5
            testTargets = listOf(
                "class tickmarks.sample.MyFlakyTest"
            )
        }
    }
}
