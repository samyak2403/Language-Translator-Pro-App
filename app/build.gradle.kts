plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.arrowwould.workout.languagetranslatorproapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.arrowwould.workout.languagetranslatorproapp"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures{
        viewBinding = true
    }



}

val mlkitOCRLanguages = listOf(
    "chinese",
    "devanagari",
    "japanese",
    "korean"
)
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")

    // translate
    implementation ("com.google.mlkit:translate:17.0.2")
    // language detection
    implementation ("com.google.mlkit:language-id:17.0.5")
    // text detection
    implementation ("com.google.mlkit:text-recognition:16.0.0" )// this is for latin
    mlkitOCRLanguages.forEach { lang ->
        implementation("com.google.mlkit:text-recognition-$lang:16.0.0")
    }
    // image cropper ( text recognition works without this too)
    implementation("com.vanniktech:android-image-cropper:4.5.0")
}