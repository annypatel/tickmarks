plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
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
        testInstrumentationRunnerArgument("listener", "leakcanary.FailTestOnLeakRunListener")
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
    implementation(Hilt.android)
    kapt(Hilt.compiler)
    implementation(Hilt.AndroidX.viewModel)
    kapt(Hilt.AndroidX.compiler)
    debugImplementation(LeakCanary.android)

    testImplementation(Test.junit)
    testImplementation(Test.mockito)
    testImplementation(Test.mockitoInline)
    kaptTest(DataBinding.compiler)

    androidTestImplementation(Test.junit)
    androidTestImplementation(LeakCanary.instrumentation)
}
