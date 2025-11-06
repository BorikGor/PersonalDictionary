plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
    id("com.google.devtools.ksp")version "2.0.21-1.0.25" // KSP for Room
}

android {
    namespace = "com.example.personaldictionary"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.personaldictionary"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }

    buildFeatures { compose = true }

}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2025.10.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Базовые компоненты Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Activity для setContent{} (без него стартовать Compose неудобно)
    implementation("androidx.activity:activity-compose:1.9.2")

    // Glance (виджеты)
    implementation("androidx.glance:glance:1.1.0")
    implementation("androidx.glance:glance-appwidget:1.1.0") // [6](https://wiki.ling.washington.edu/bin/view/Main/PanLex)
    implementation("androidx.glance:glance-material3:1.1.1")

    // WorkManager (суточное обновление виджета)
    implementation("androidx.work:work-runtime-ktx:2.9.1") // [7](https://www.clrn.org/how-to-change-widget-size-on-samsung/)

    // Прочее (AppCompat/Material/Core KTX) — по необходимости
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")

    // Тесты (оставляем, как было)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Room dependencies
    val room = "2.8.3"
    implementation("androidx.room:room-runtime:$room")
    implementation("androidx.room:room-ktx:$room")
    ksp("androidx.room:room-compiler:$room")

    // CVS parsing
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.10.0")
}