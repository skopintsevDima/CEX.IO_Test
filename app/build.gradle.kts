import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    buildToolsVersion(Config.Android.buildToolsVersion)

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName

        val propsFile = file("apikey.properties")
        val apiKeyProperties = Properties()
        apiKeyProperties.load(FileInputStream(propsFile))
        val apiKey = apiKeyProperties.getProperty(Config.Android.API_KEY_PROP_NAME)
        buildConfigField("String", Config.Android.API_KEY_PROP_NAME, apiKey)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(Config.Tools.kotlinStd)
    implementation(Config.Tools.ktxCore)

    implementation(Config.Android.appcompat)
    implementation(Config.Android.material)
    implementation(Config.Android.constraintLayout)
    implementation(Config.Android.recyclerView)
    implementation(Config.Android.swipeRefreshLayout)
    implementation(Config.Android.viewModel)
    implementation(Config.Android.room)
    kapt(Config.Android.roomCompiler)
    implementation(Config.Android.roomRxJava)

    implementation(Config.ThirdPartyLibs.picasso)
    implementation(Config.ThirdPartyLibs.retrofit)
    implementation(Config.ThirdPartyLibs.retrofitRxJavaAdapter)
    implementation(Config.ThirdPartyLibs.retrofitGsonConverter)
    implementation(Config.ThirdPartyLibs.gson)
    implementation(Config.ThirdPartyLibs.rxAndroid)
    implementation(Config.ThirdPartyLibs.rxJava)
    implementation(Config.ThirdPartyLibs.dagger)
    kapt(Config.ThirdPartyLibs.daggerCompiler)
}
