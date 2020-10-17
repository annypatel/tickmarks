import com.android.build.gradle.BaseExtension

configureRootProject()

subprojects {
    val project = this
    if (shouldNotIgnore(project)) {
        plugins.withId("org.jetbrains.kotlin.jvm") { configureKotlinProject(project) }
        plugins.withId("com.android.library") { configureAndroidProject(project) }
        plugins.withId("com.android.application") { configureAndroidProject(project) }
    }
}

fun configureRootProject() {
    applyJacoco(rootProject)

    val jacocoMerge = tasks.create<JacocoMerge>("jacocoMerge") {
        destinationFile = file("$buildDir/jacoco/jacocoMerge.exec")
        executionData(allExecutionData())
    }

    tasks.create<JacocoReport>("mergeJacocoTestReport") {
        configure(
            dependsOn = listOf(jacocoMerge),
            classDirs = allClassDirs(),
            sourceDirs = sourceDirs(),
            execData = files(jacocoMerge.destinationFile)
        )
    }
}

fun configureKotlinProject(project: Project) {
    applyJacoco(project)

    project.tasks.named<JacocoReport>("jacocoTestReport") {
        configure(
            dependsOn = listOf("testDebugUnitTest"),
            classDirs = kotlinClassDirs(project),
            sourceDirs = sourceDirs(),
            execData = kotlinExecutionData(project)
        )
    }
}

fun configureAndroidProject(project: Project) {
    applyJacoco(project)

    project.configure<BaseExtension> {
        // AGP should use same jacoco version
        jacoco {
            version = Versions.jacoco
        }

        buildTypes {
            getByName("debug") {
                isTestCoverageEnabled = true
            }
        }
    }

    // isIncludeNoLocationClasses is required for robolectric tests
    project.tasks.withType<org.gradle.api.tasks.testing.Test> {
        extensions.configure<JacocoTaskExtension>() {
            isIncludeNoLocationClasses = true
            // https://github.com/gradle/gradle/issues/5184
            excludes = listOf("jdk.internal.*")
        }
    }

    project.tasks.create<JacocoReport>("jacocoTestReport") {
        configure(
            dependsOn = listOf("testDebugUnitTest", "createDebugCoverageReport"),
            classDirs = androidClassDirs(project),
            sourceDirs = sourceDirs(),
            execData = androidExecutionData(project)
        )
    }
}

fun applyJacoco(project: Project) {
    project.plugins.apply("jacoco")
    project.configure<JacocoPluginExtension> {
        toolVersion = Versions.jacoco
        reportsDir = file("${project.buildDir}/reports")
    }
}

@Suppress("UnstableApiUsage")
fun JacocoReport.configure(
    dependsOn: Iterable<Any>,
    classDirs: Iterable<*>,
    sourceDirs: Iterable<*>,
    execData: Iterable<*>
) {
    group = "Reporting"
    description = "Generate Jacoco coverage reports"

    dependsOn(dependsOn)

    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.isEnabled = true
    }

    classDirectories.setFrom(classDirs)
    additionalClassDirs.setFrom(classDirs)
    sourceDirectories.setFrom(sourceDirs)
    additionalSourceDirs.setFrom(sourceDirs)
    executionData.setFrom(execData)
}

fun sourceDirs(): List<String> {
    return listOf(
        "src/main/java",
        "src/main/kotlin"
    )
}

fun kotlinClassDirs(project: Project): ConfigurableFileTree {
    return fileTree(project.buildDir) {
        setExcludes(excluded())
        setIncludes(listOf("**/classes/**/main/**"))
    }
}

fun androidClassDirs(project: Project): ConfigurableFileTree {
    return fileTree(project.buildDir) {
        setExcludes(excluded())
        setIncludes(
            listOf(
                "**/intermediates/classes/debug/**",
                "**/intermediates/javac/debug/*/classes/**",
                "**/tmp/kotlin-classes/debug/**"
            )
        )
    }
}

fun allClassDirs(): FileCollection {
    val files = files()
    subprojects {
        val project = this
        if (shouldNotIgnore(project)) {
            files.from(kotlinClassDirs(project))
            files.from(androidClassDirs(project))
        }
    }
    return files
}

fun kotlinExecutionData(project: Project): FileCollection {
    return files(
        "${project.buildDir}/jacoco/testDebugUnitTest.exec"
    )
}

fun androidExecutionData(project: Project): FileCollection {
    return fileTree(project.buildDir) {
        setIncludes(
            listOf(
                "jacoco/testDebugUnitTest.exec",
                "outputs/code_coverage/**/*.ec"
            )
        )
    }
}

fun allExecutionData(): FileCollection {
    val files = files()
    subprojects {
        val project = this
        if (shouldNotIgnore(project)) {
            files.from(kotlinExecutionData(project).filter { it.exists() })
            files.from(androidExecutionData(project).filter { it.exists() })
        }
    }
    return files
}

fun shouldNotIgnore(project: Project): Boolean {
    val ignored = listOf(
        ":app",
        ":test:ui",
        ":test:domain",
        ":test:data"
    )
    return !ignored.contains(project.path)
}

fun excluded() = listOf(
    "**/R.class",
    "**/R$*.class",
    "**/*\$*\$*.*",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    // dagger
    "**/*Dagger*.*",
    "**/*Module*.*",
    "**/*MembersInjector*.*",
    "**/*_Provide*Factory*.*",
    "**/*_Factory*.*",
    // data binding
    "**/BR.class",
    "**/*Binding.*",
    "**/*BindingImpl*.*",
    "**/DataBinderMapperImpl*.*",
    "**/DataBindingInfo.*",
    "**/generated/callback/*",
    // navigation safe-args
    "**/*FragmentDirections*.*",
    "**/*FragmentArgs*.*",
    "**/*DialogArgs*.*"
)
