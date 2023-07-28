plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.androidx.navigation.safeargs)
    alias(libs.plugins.hilt)
}

android {
    namespace = "info.mschmitt.giraffetemplate.app"
    compileSdk = 33

    defaultConfig {
        applicationId = "info.mschmitt.giraffetemplate.app"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.$versionCode"
        setProperty("archivesBaseName", "$applicationId-$versionName")
    }

    buildTypes {
        debug {
            versionNameSuffix = "-SNAPSHOT"
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }

    lint {
        setOf(
            "UseSparseArrays",
            "HardcodedText",
            "GoogleAppIndexingWarning",
            "ContentDescription",
            "RtlHardcoded",
            "NestedWeights",
            "SpUsage"
        )
    }
}

dependencies {
    implementation(project(":lib"))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)
    implementation(libs.material)
    constraints {
        // https://stackoverflow.com/a/75298544
        implementation(libs.kotlin.stdtlib.jdk8) {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
}