plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.services)
}

//val admobAppId: String = project.findProperty("ADMOB_APP_ID") as? String ?: ""
//val interstitialAdId: String = project.findProperty("INTERSTITIAL_AD_ID") as? String ?: ""

//These are test IDs only if app fails
val admobAppId: String = project.findProperty("ADMOB_APP_ID") as? String
    ?:"ca-app-pub-3940256099942544~3347511713"

val interstitialAdId: String = project.findProperty("INTERSTITIAL_AD_ID") as? String
    ?:"ca-app-pub-3940256099942544/1033173712"

val feedBackAds: String = project.findProperty("FEEDBACK_EMAIL") as? String ?:"your@email.com"

//test banner ad id
val bannerAdsID: String = project.findProperty("BANNER_ADS_ID")as? String ?:"ca-app-pub-3940256099942544/6300978111"


android {
    namespace = "com.example.audiotrimmer"
    compileSdk =36

    defaultConfig {
        manifestPlaceholders["ADMOB_APP_ID"] = admobAppId
        buildConfigField("String", "ADMOB_APP_ID", "\"$admobAppId\"")
        buildConfigField("String", "INTERSTITIAL_AD_ID", "\"$interstitialAdId\"")
        buildConfigField("String","FEEDBACK_EMAIL","\"$feedBackAds\"")
        buildConfigField("String","BANNER_ADS_ID","\"$bannerAdsID\"")
        applicationId = "com.example.audiotrimmer"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.play.services.ads.api)
//    implementation(libs.firebase.messaging.ktx)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.messaging)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation (libs.androidx.media3.transformer)
    implementation (libs.androidx.media3.exoplayer)
    implementation (libs.androidx.media3.ui)
    implementation (libs.androidx.media3.common)
    implementation (libs.androidx.media3.session)
    implementation(libs.androidx.media3.effect)

    // Navigation
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)

    // Room components
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)


    // Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.kotlinx.serialization.json)

  // DataStore
    implementation(libs.androidx.datastore.preferences)

    //RevenueCat
    implementation("com.revenuecat.purchases:purchases:9.27.0")
    implementation("com.revenuecat.purchases:purchases-ui:9.27.0")

//    Firebase Notification
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)

}