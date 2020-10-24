@file:Suppress("MagicNumber")

import com.osacky.flank.gradle.FlankGradleExtension
import com.osacky.flank.gradle.RunFlankTask

// Fulladle plugin must br only applied to root project, so can't use plugins { } syntax.
rootProject.plugins.apply("com.osacky.fulladle")

configure<FlankGradleExtension> {
    flankVersion.set("_")
    serviceAccountCredentials.set(rootProject.file("gcloud-service-key.json"))
    resultsBucket.set("staging.tickmarks-5b34c.appspot.com")
    devices.set(listOf(mapOf("model" to "Pixel2", "version" to "28")))
    repeatTests.set(1)
    flakyTestAttempts.set(0)
    disableSharding.set(true)

    configs {
        // Use this to check if a test is flaky. Change the test target below and run
        // `./gradlew runFlankFlaky` or `./gradlew flankFlakyAndroidTest` to repeatedly run the test
        // on firebase. All filters supported by AndroidJUnitRunner are supported here as well.
        // Refer - https://developer.android.com/reference/android/support/test/runner/AndroidJUnitRunner
        create("flaky") {
            repeatTests.set(5)
            testTargets.set(
                listOf(
                    "class tickmarks.sample.MyFlakyTest"
                )
            )
        }
    }
}

afterEvaluate {
    tasks.withType<RunFlankTask>().forEach {
        registerFlankTasks(it)
    }
}

fun registerFlankTasks(flankTask: RunFlankTask) {
    val flankTaskName = flankTask.name.replace("run", "")

    val assembleFlankTask = tasks.register("assemble${flankTaskName.capitalize()}") {
        group = flankTask.group
        description = "Assemble debug and test APKs for app and library(only with android tests)"
        dependsOn(findAssembleDependents())
    }

    tasks.register("${flankTaskName.decapitalize()}AndroidTest") {
        group = flankTask.group
        description = "Assemble and run tests on Firebase"
        dependsOn(assembleFlankTask)
        dependsOn(flankTask)
    }
}

fun findAssembleDependents(): List<Task> {
    val tasks = mutableListOf<Task>()
    subprojects.forEach { project ->
        val hasAndroidAppPlugin = project.plugins.hasPlugin("com.android.application")
        val hasAndroidTest = project.file("./src/androidTest").exists()
        project.tasks.filterTo(tasks) { task ->
            when (task.name) {
                "assembleDebug" -> hasAndroidAppPlugin
                "assembleDebugAndroidTest" -> hasAndroidAppPlugin || hasAndroidTest
                else -> false
            }
        }
    }
    return tasks
}
