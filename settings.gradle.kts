import de.fayard.refreshVersions.bootstrapRefreshVersions

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
    }
}

bootstrapRefreshVersions()

include(":app")
include(":base:ui")
include(":base:domain")
include(":base:data")
include(":test:ui")
include(":test:domain")
include(":test:data")
include(":bookmark:ui")
include(":bookmark:domain")
include(":bookmark:data")
