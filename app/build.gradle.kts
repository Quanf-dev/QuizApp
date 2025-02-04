plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.dacn_cr424ac_2223_hoangbaoquan_5694"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dacn_cr424ac_2223_hoangbaoquan_5694"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("se.emilsjolander:stickylistheaders:2.7.0")
    implementation("com.airbnb.android:lottie:4.2.2")
    implementation("androidx.core:core-splashscreen:1.0.0")
    implementation ("com.google.code.gson:gson:2.8.6")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.23")


}