/**
 * Copy lint report of all modules into project level build directory.
 */
tasks.register<Copy>("copyLintReports") {
    rootProject.subprojects.forEach { project ->
        from(project.buildDir("reports")) {
            into(project.relativeToRoot())
        }
    }
    includeEmptyDirs = false
    include("lint-results*.xml")
    into(rootProject.buildDir("lint"))
}

/**
 * Copy detekt report of all modules into project level build directory.
 */
tasks.register<Copy>("copyDetektReports") {
    rootProject.subprojects.forEach { project ->
        from(project.buildDir("reports/detekt")) {
            into(project.relativeToRoot())
        }
    }
    includeEmptyDirs = false
    include("*.xml")
    into(rootProject.buildDir("detekt"))
}

/**
 * Copy unit test report of all modules into project level build directory.
 */
tasks.register<Copy>("copyUnitTestReports") {
    rootProject.subprojects.forEach { project ->
        from(project.buildDir("test-results")) {
            into(project.relativeToRoot())
        }
    }
    includeEmptyDirs = false
    exclude("**/binary")
    include("**/*.xml")
    into(rootProject.buildDir("unit-tests"))
}

/**
 * Copy release artifact of app modules into project level build directory.
 */
tasks.register<Copy>("copyReleaseArtifacts") {
    rootProject.subprojects.forEach { project ->
        from(project.buildDir("outputs")) {
            into(project.relativeToRoot())
        }
    }
    includeEmptyDirs = false
    include("**/release/*.apk")
    include("**/release/mapping.txt")
    into(rootProject.buildDir("release"))
}

// Why no task for flank and dependency updates?
// Both flank and dependency version plugin generate report into project level build directory.
