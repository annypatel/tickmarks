plugins {
    tickmarks_dependency_versions
    tickmarks_static_analysis
    tickmarks_firebase_testlab
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
