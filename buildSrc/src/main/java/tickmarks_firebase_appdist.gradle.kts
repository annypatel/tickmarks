import com.android.build.gradle.AppExtension
import com.google.firebase.appdistribution.gradle.AppDistributionExtension
import com.google.firebase.appdistribution.gradle.UploadDistributionTask

plugins {
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution")
}

configure<AppExtension> {
    buildTypes {
        named("release") {
            configure<AppDistributionExtension> {
                serviceCredentialsFile = "gcloud-service-key.json"
                releaseNotesFile = buildDir("release-notes.txt").path
                groups = "all"
            }
        }
    }
}

val appDistributionReleaseNotes = project.tasks.register("appDistributionReleaseNotes") {
    val notes = buildDir("release-notes.txt")
    notes.delete()
    doLast {
        println("Generating release notes...")
        notes.outputStream().use { os ->
            exec {
                commandLine("git log --format=%B -n 1".split(" "))
                standardOutput = os
            }
        }
    }
}

tasks.withType<UploadDistributionTask>().configureEach {
    dependsOn(appDistributionReleaseNotes)
}
