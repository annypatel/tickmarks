plugins {
    tickmarks_dependency_versions
    tickmarks_static_analysis
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.named<Delete>("clean") {
    delete(rootProject.buildDir)
}
