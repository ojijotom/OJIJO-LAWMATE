plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("kotlin-kapt")


}

android {
    namespace = "com.ojijo.ojijolawmate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ojijo.ojijolawmate"
        minSdk = 21
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.navigation:navigation-compose:2.7.7")

    implementation ("androidx.compose.material:material-icons-extended:<version>")




    // SQLite database support
    implementation("androidx.sqlite:sqlite:2.1.0") // SQLite support for local databases in Android

    // Coroutine support for asynchronous tasks
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4") // Kotlin Coroutines for Android

    // Unit and UI Testing libraries
    testImplementation(libs.junit) // Unit testing
    androidTestImplementation(libs.androidx.junit) // JUnit Android test dependencies
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI tests

    //Room
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")

    // AndroidTest dependencies for Jetpack Compose
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM for Compose in tests
    androidTestImplementation(libs.androidx.ui.test.junit4) // Jetpack Compose UI testing
    debugImplementation(libs.androidx.ui.tooling) // Debugging support for Compose UI
    debugImplementation(libs.androidx.ui.test.manifest) // Manifest support for testing in Compose

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.1")
    implementation ("androidx.navigation:navigation-compose:2.5.0") // Make sure the version is correct













}