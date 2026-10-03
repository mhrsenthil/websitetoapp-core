plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val websiteUrl = providers.gradleProperty("WEB_URL").orElse("https://example.com")
val appName = providers.gradleProperty("APP_NAME").orElse("Website App")
val packageName = providers.gradleProperty("PACKAGE_NAME").orElse("com.example.websiteapp")
val versionNameValue = providers.gradleProperty("VERSION_NAME").orElse("1.0.0")
val versionCodeValue = providers.gradleProperty("VERSION_CODE").orElse("1").map { it.toInt() }

android {
    namespace = "com.websitetoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = packageName.get()
        minSdk = 23
        targetSdk = 35
        versionCode = versionCodeValue.get()
        versionName = versionNameValue.get()
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

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        resValue("string", "app_name", appName.get())
    }

    buildTypes.all {
        buildConfigField(
            "String",
            "WEB_URL",
            "\"${websiteUrl.get().replace("\", "\\").replace(""", "\"")}\""
        )
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.activity:activity-ktx:1.10.0")
    implementation("androidx.webkit:webkit:1.12.1")
}
