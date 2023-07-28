plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "info.mschmitt.giraffetemplate"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
}