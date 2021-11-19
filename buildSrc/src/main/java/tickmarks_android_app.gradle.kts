plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.Sdk.compile
    defaultConfig {
        minSdk = Versions.Sdk.min
        targetSdk = Versions.Sdk.target
        archivesBaseName = "${parent?.name}-$archivesBaseName"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments += "listener" to "leakcanary.FailTestOnLeakRunListener"
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

    lint {
        isAbortOnError = true
        isWarningsAsErrors = true
        htmlReport = false
        textReport = false
        xmlReport = true
        lintConfig = rootProject.file("lint-config.xml")
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
