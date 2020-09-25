import com.diffplug.gradle.spotless.SpotlessExtension
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(Plugins.spotless)
        classpath(Plugins.gvp)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

subprojects {
    apply {
        plugin("com.diffplug.spotless")
        plugin("com.github.ben-manes.versions")
    }

    configure<SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            ktlint(Versions.ktlint)
        }
    }

    fun isNonStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }

    tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {

        rejectVersionIf {
            !isNonStable(currentVersion) && isNonStable(candidate.version)
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
