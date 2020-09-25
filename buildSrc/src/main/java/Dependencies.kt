@file:Suppress("ClassName", "ClassNaming", "SpellCheckingInspection")

object Versions {

    object Sdk {
        const val min = 21
        const val compile = 28
        const val target = 28
    }

    const val ktlint = "0.23.1"
}

object Kotlin {
    // Upgrading kotlin version? Update kotlin plugin in buildSrc/build.gradle.kts as well.
    const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10"
}

object Rx {
    const val java = "io.reactivex.rxjava2:rxjava:2.2.19"
    const val kotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    const val android = "io.reactivex.rxjava2:rxandroid:2.1.1"
}

object Dagger {
    private const val version = "2.29.1"
    const val runtime = "com.google.dagger:dagger:$version"
    const val compiler = "com.google.dagger:dagger-compiler:$version"

    object Android {
        const val runtime = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-android-processor:$version"
    }
}

object OkHttp {
    private const val version = "3.14.9"
    const val client = "com.squareup.okhttp3:okhttp:$version"

    object Test {
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
    }
}

object Retrofit {
    private const val version = "2.9.0"
    const val client = "com.squareup.retrofit2:retrofit:$version"
    const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:$version"
}

object RetroCrawler {
    const val converterJspoon = "com.github.annypatel.retrocrawler:converter-jspoon:1.0.0-alpha1"
    const val jspoon = "pl.droidsonroids:jspoon:1.3.2"
}

object AndroidX {
    const val extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val fragment = "androidx.fragment:fragment-ktx:1.2.5"

    object Test {
        const val junit = "androidx.test.ext:junit:1.1.2"
        const val core = "androidx.test:core-ktx:1.3.0"
        const val runner = "androidx.test:runner:1.3.0"
        const val rules = "androidx.test:rules:1.3.0"
        const val arch = "androidx.arch.core:core-testing:2.1.0"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}

object Room {
    private const val version = "2.2.5"
    const val runtime = "androidx.room:room-runtime:$version"
    const val compiler = "androidx.room:room-compiler:$version"
    const val rx = "androidx.room:room-rxjava2:$version"
}

object Google {
    const val material = "com.google.android.material:material:1.2.1"
}

object DataBinding {
    const val lint = "com.github.annypatel.databinding:lint-checks:1.0.0-alpha1"
}

object Test {
    const val junit = "junit:junit:4.13"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
    const val robolectric = "org.robolectric:robolectric:4.2"
    const val bindingMapper = "com.github.annypatel.databinding:binding-mapper:1.0.0-alpha1"
    const val rxidler = "com.squareup.rx.idler:rx2-idler:0.11.0"
}
