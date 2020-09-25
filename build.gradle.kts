import com.android.build.gradle.BaseExtension
import com.diffplug.gradle.spotless.SpotlessExtension
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(Plugins.agp)
        classpath(Plugins.kotlin)
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

    val kotlinConfig: (Plugin<Any>).() -> Unit = {
        tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    plugins.withId("org.jetbrains.kotlin.jvm", kotlinConfig)
    plugins.withId("org.jetbrains.kotlin.android", kotlinConfig)

    val androidConfig: (Plugin<Any>).() -> Unit = {

        configure<BaseExtension> {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            packagingOptions {
                exclude("META-INF/*.kotlin_module")
            }
        }
    }
    plugins.withId("com.android.application", androidConfig)
    plugins.withId("com.android.library", androidConfig)

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
