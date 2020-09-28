plugins {
    tickmarks_android_app
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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
