//object Apps {
//    const val appId = "com.texa.tmd"
//    const val compileSdk = 31
//    const val minSdk = 21
//    const val targetSdk = 31
//    const val versionCode = 1
//    const val versionName = "0.9.9"
//}
//
//object Versions {
//    const val gradle = "4.1.0"
//    const val kotlin = "1.6.10"
//    const val androidX = "1.3.0"
//    const val androidXPreferences = "1.1.1"
//    const val retrofit = "2.9.0"
//    const val archLifecycle = "2.2.0"
//    const val dagger = "2.40.5"
//    const val glide = "4.12.0"
//    const val coroutines = "1.6.0"
//    const val arrow = "1.0.1"
//    const val arrowSyntax = "0.12.0"
//    const val room = "2.4.0"
//    const val material = "1.5.0-rc01"
//}
//
//
//object Depends {
//
//    object Kotlin {
//        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
//    }
//
//    object X {
//        const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
//        const val annotation = "androidx.annotation:annotation:${Versions.androidX}"
//        const val appcompat = "androidx.appcompat:appcompat:${Versions.androidX}"
//        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.2"
//        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidX}"
//        const val preference = "androidx.preference:preference-ktx:${Versions.androidXPreferences}"
//    }
//
//    const val ktx = "androidx.core:core-ktx:1.7.10"
//    const val material = "com.google.android.material:material:${Versions.material}"
//
//    object OkHttp3 {
//        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"
//    }
//
//    object Retrofit {
//        const val gson = "com.google.code.gson:gson:2.8.6"
//        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
//        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
//        const val adapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
//    }
//
//    object LifeCycle {
//        const val runtime = "androidx.lifecycle:lifecycle-extensions:${Versions.archLifecycle}"
//        const val compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.archLifecycle}"
//        const val reactivestreams =
//            "androidx.lifecycle:lifecycle-reactivestreams:${Versions.archLifecycle}"
//    }
//
//    object RxJava2 {
//        const val android = "io.reactivex.rxjava3:rxandroid:3.0.0"
//        const val kotlin = "io.reactivex.rxjava3:rxkotlin:3.0.1"
//    }
//
//    object Dagger {
//        const val core = "com.google.dagger:dagger:${Versions.dagger}"
//        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
//        const val android = "com.google.dagger:dagger-android:${Versions.dagger}"
//        const val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
//        const val androidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
//    }
//
//    object Firebase {
//        const val core = "com.google.firebase:firebase-core:20.0.2"
//        const val messaging = "com.google.firebase:firebase-messaging:23.0.0"
//        const val analytics = "com.google.firebase:firebase-analytics-ktx:20.0.2"
//        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx:18.2.6"
//        const val authentication = "com.google.firebase:firebase-auth:21.0.1"
//        const val map = "com.google.android.gms:play-services-maps:18.0.1"
//        const val firestore = "com.google.firebase:firebase-firestore:24.0.0"
//    }
//
//    object Glide {
//        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
//        const val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
//        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
//    }
//
//    object Coroutines {
//        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
//        const val android =
//            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
//        const val rx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutines}"
//        const val arrowCore = "io.arrow-kt:arrow-core:${Versions.arrow}"
//        //        const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrowSyntax}"
//        const val arrowMeta = "io.arrow-kt:arrow-meta:${Versions.arrow}"
//    }
//
//    object Room {
//        const val room = "androidx.room:room-runtime:${Versions.room}"
//        const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
//    }
//
//    const val timber = "com.jakewharton.timber:timber:5.0.1"
//    const val segmentedControl = "com.github.ceryle:SegmentedButton:v2.0.2"
//    const val photoView = "com.github.chrisbanes:PhotoView:2.3.0"
//}