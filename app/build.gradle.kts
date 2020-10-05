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

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }

        getByName("release") {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            firebaseAppDistribution {
                serviceCredentialsFile = "gcloud-service-key.json"
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
