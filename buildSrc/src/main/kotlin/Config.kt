object Config {
    //TODO: Remove unused dependencies
    private object Versions {
        // Tools
        const val kotlinVersion = "1.3.61"
        const val androidGradleVersion = "3.5.3"
        const val ktxCoreVersion = "1.1.0"

        // Android
        const val appcompatVersion = "1.1.0"
        const val materialVersion = "1.1.0"
        const val constraintLayoutVersion = "1.1.3"
        const val recyclerViewVersion = "1.1.0"
        const val swipeRefreshLayoutVersion = "1.0.0"
        const val viewModelVersion = "2.2.0"
        const val roomVersion = "2.2.5"

        // Third-party libs
        const val retrofitVersion = "2.8.1"
        const val gsonVersion = "2.8.6"
        const val daggerVersion = "2.27"
        const val rxAndroidVersion = "2.1.1"
        const val rxJavaVersion = "2.2.19"
        const val picassoVersion = "2.71828"

        // Testing libs
        const val junitVersion = "4.12"
        const val androidxJunitVersion = "1.1.1"
        const val espressoCoreVersion = "3.2.0"
    }

    object Tools {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradleVersion}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
        const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCoreVersion}"
    }

    object Android {
        const val buildToolsVersion = "29.0.2"
        const val minSdkVersion = 21
        const val targetSdkVersion = 29
        const val compileSdkVersion = 29
        const val applicationId = "com.test.cexiotest"
        const val versionCode = 1
        const val versionName = "1.0"

        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}"
        const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomRxJava = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    }

    object ThirdPartyLibs {
        const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    }

    object TestingLibs {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunitVersion}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    }
}