import org.gradle.api.Project
import java.io.File

var Project.archivesBaseName
    get() = property("archivesBaseName")
    set(value) = setProperty("archivesBaseName", value)

val ci
    get() = System.getenv("CI") == "true"

fun Project.buildDir(file: String) = File(buildDir, file)

fun Project.relativeToRoot() = projectDir.toRelativeString(rootProject.projectDir)
