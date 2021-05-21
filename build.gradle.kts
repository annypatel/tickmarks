plugins {
    tickmarks_dependency_versions
    tickmarks_static_analysis
    tickmarks_firebase_testlab
    tickmarks_code_coverage
    tickmarks_copy_artifacts
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
