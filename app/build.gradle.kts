plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	kotlin("kapt") version "2.0.0"
	alias(libs.plugins.compose.compiler)
	alias(libs.plugins.hilt)
}

android {
	namespace = "com.georgije.architecturetraining"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.georgije.architecturetraining"
		minSdk = 33
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
	composeCompiler {
		enableStrongSkippingMode = true
	}
}

dependencies {
	implementation(libs.converter.jackson)
	// Jackson for JSON Parsing
	implementation(libs.jackson.module.kotlin)
// https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
	implementation(libs.retrofit)
	implementation(libs.androidx.runtime.livedata)
	// implementation(libs.google.dagger.dagger)
	// implementation(libs.google.dagger.compiler)
	// implementation(libs.google.dagger.android)
	// implementation(libs.google.dagger.support)
	// implementation(libs.google.dagger.processor)
	// kapt(libs.hilt.android.compiler)
	kapt(libs.bundles.di.kapt)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(libs.google.dagger.hilt.android.android)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	implementation(libs.androidx.navigation.compose)
	// implementation(libs.google.dagger.hilt.compiler)
	kapt(libs.androidx.hilt.compiler)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
	implementation(libs.javapoet)
}
hilt {
	enableAggregatingTask = false
}
