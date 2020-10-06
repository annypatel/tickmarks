plugins {
    tickmarks_android_app
    id("com.gladed.androidgitversion")
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution")
}

androidGitVersion {
    codeFormat = "MMNNPPBBB"
    format = "%tag%%.count%%-commit%%-dirty%"
}

android {
    defaultConfig {
        applicationId = "tickmarks.app"
        versionName = androidGitVersion.name()
        versionCode = androidGitVersion.code()
    }

    buildFeatures {
        dataBinding = true
    }

    signingConfigs {
        named("debug") {
            storeFile = rootProject.file("signing/debug.jks")
        }

        create("release") {
            storeFile = rootProject.file("signing/release.jks")
            keyAlias = "tickmarks"
            storePassword = properties["RELEASE_KEYSTORE_PWD"] as? String
            keyPassword = properties["RELEASE_KEY_PWD"] as? String
        }
    }

    buildTypes {
        named("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debug")
        }

        named("release") {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            firebaseAppDistribution {
                serviceCredentialsFile = "gcloud-service-key.json"
                groups = "all"
                releaseNotes = ""
            }
        }
    }
}

dependencies {
    implementation(project(":bookmark:ui"))
    implementation(Dagger.runtime)
    kapt(Dagger.compiler)
    implementation(Dagger.Android.runtime)
    kapt(Dagger.Android.compiler)
    implementation(AndroidX.appcompat)
    implementation(DataBinding.lint)

    // for dagger generated code
    implementation(Retrofit.client)
    implementation(Room.runtime)
}
