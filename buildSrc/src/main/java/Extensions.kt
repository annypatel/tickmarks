import org.gradle.api.Project

var Project.archivesBaseName
    get() = property("archivesBaseName")
    set(value) = setProperty("archivesBaseName", value)

val Project.ci
    get() = System.getenv("CI") == "true"
