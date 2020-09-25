plugins {
    id("io.gitlab.arturbosch.detekt")
}

subprojects {
    apply { plugin("io.gitlab.arturbosch.detekt") }
    detekt {
        config = files(rootProject.file("detekt-config.yml"))
        autoCorrect = true
        input = files(
            "src/main/java",
            "src/debug/java",
            "src/release/java",
            "src/test/java",
            "src/androidTest/java"
        )
        reports {
            xml { enabled = true }
            html { enabled = false }
            txt { enabled = false }
        }
    }

    dependencies {
        detektPlugins(Detekt.formatting)
    }
}
