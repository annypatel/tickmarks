plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Sdk.compile)
    defaultConfig {
        minSdkVersion(Versions.Sdk.min)
        targetSdkVersion(Versions.Sdk.target)
        archivesBaseName = "${parent?.name}-$archivesBaseName"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    lintOptions {
        isAbortOnError = true
        isWarningsAsErrors = true
        htmlReport = false
        textReport = false
        xmlReport = true
        lintConfig = File("lint-config.xml")
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

    dexOptions {
        // don't pre-dex on CI
        preDexLibraries = !ci
    }
}

dependencies {
    implementation(Kotlin.jdk8)
    implementation(Rx.java)
    implementation(Rx.kotlin)
    implementation(DataBinding.lint)

    testImplementation(Test.junit)
    testImplementation(Test.mockito)
    kaptTest(DataBinding.compiler)
}
