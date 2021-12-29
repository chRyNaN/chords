import com.chrynan.chords.buildSrc.LibraryConstants
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

group = LibraryConstants.group
version = LibraryConstants.versionName

kotlin {
    targets {
        android()
        jvm()
    }
    sourceSets {
        all {
            languageSettings {
                languageSettings.enableLanguageFeature("InlineClasses")
                languageSettings.optIn("kotlin.RequiresOptIn")
            }
        }
        commonMain {
            dependencies {
                implementation(project(":chords-compose"))

                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.material)

                implementation("com.chrynan.colors:colors-compose:0.7.0")
                implementation("com.chrynan.presentation:presentation-compose:0.6.0")
                implementation("com.chrynan.navigation:navigation-compose:0.2.2")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
            }
        }
    }
}

android {
    compileSdk = LibraryConstants.Android.compileSdkVersion

    defaultConfig {
        applicationId = "com.chrynan.chords.sample.compose"
        minSdk = 25
        targetSdk = LibraryConstants.Android.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            // Opt-in to experimental compose APIs
            freeCompilerArgs = listOf(
                    "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].java.srcDirs("src/androidMain/kotlin")
    sourceSets["main"].res.srcDirs("src/androidMain/res")

    sourceSets["test"].java.srcDirs("src/androidTest/kotlin")
    sourceSets["test"].res.srcDirs("src/androidTest/res")
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.INHERIT }

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")

    implementation("androidx.activity:activity-compose:1.4.0")
}
