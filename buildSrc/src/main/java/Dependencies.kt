@file:Suppress("SpellCheckingInspection")

object Versions {

    object Sdk {
        const val min = 21
        const val compile = 28
        const val target = 28
    }

    const val jacoco = "0.8.4"
}

object Kotlin {
    const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:_"
}

object Detekt {
    const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:_"
}

object Rx {
    const val java = "io.reactivex.rxjava2:rxjava:_"
    const val kotlin = "io.reactivex.rxjava2:rxkotlin:_"
    const val android = "io.reactivex.rxjava2:rxandroid:_"
}

object Dagger {
    const val runtime = "com.google.dagger:dagger:_"
    const val compiler = "com.google.dagger:dagger-compiler:_"

    object Android {
        const val runtime = "com.google.dagger:dagger-android-support:_"
        const val compiler = "com.google.dagger:dagger-android-processor:_"
    }
}

object OkHttp {
    const val client = "com.squareup.okhttp3:okhttp:_"

    object Test {
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:_"
    }
}

object Retrofit {
    const val client = "com.squareup.retrofit2:retrofit:_"
    const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:_"
}

object RetroCrawler {
    const val converterJspoon = "com.github.annypatel.retrocrawler:converter-jspoon:_"
    const val jspoon =  "pl.droidsonroids:jspoon:_"
}

object AndroidX {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:_"
    const val appcompat =  "androidx.appcompat:appcompat:_"
    const val fragment = "androidx.fragment:fragment-ktx:_"

    object Test {
        const val junit = "androidx.test.ext:junit:_"
        const val core = "androidx.test:core-ktx:_"
        const val runner = "androidx.test:runner:_"
        const val espresso = "androidx.test.espresso:espresso-core:_"
    }
}

object Room {
    const val runtime =  "androidx.room:room-runtime:_"
    const val compiler = "androidx.room:room-compiler:_"
    const val rx = "androidx.room:room-rxjava2:_"
}

object Google {
    const val material = "com.google.android.material:material:_"
}

object DataBinding {
    const val compiler = "androidx.databinding:databinding-compiler:_"
    const val lint = "com.github.annypatel.databinding:lint-checks:_"
}

object Test {
    const val junit = "junit:junit:_"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:_"
    const val robolectric = "org.robolectric:robolectric:_"
    const val bindingMapper =  "com.github.annypatel.databinding:binding-mapper:_"
    const val rxidler = "com.squareup.rx.idler:rx2-idler:_"
}
