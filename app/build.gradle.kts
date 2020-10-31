plugins {
    tickmarks_android_app
    tickmarks_firebase_appdist
    id("com.gladed.androidgitversion")
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
        }
    }
}

dependencies {
    implementation(project(":base:ui"))
    implementation(project(":base:domain"))
    implementation(project(":base:data"))
    implementation(project(":bookmark:ui"))
    implementation(project(":bookmark:domain"))
    implementation(project(":bookmark:data"))

    // for generated code
    implementation(AndroidX.appcompat)
    implementation(Retrofit.client)
    implementation(Room.runtime)
}
