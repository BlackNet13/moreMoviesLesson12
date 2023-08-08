plugins {
    id("com.android.application")
}



android {
    namespace = "sg.rp.edu.rp.c346.id22038845.moremovieslesson12"
    compileSdk = 33

    defaultConfig {
        applicationId = "sg.rp.edu.rp.c346.id22038845.moremovieslesson12"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


}



dependencies {

    // Material Dialog Library
    implementation ("dev.shreyaspatil.MaterialDialog:MaterialDialog:2.2.3")

    // Material Design Library
    implementation ("com.google.android.material:material:1.0.0")

    // Lottie Animation Library
    implementation ("com.airbnb.android:lottie:3.3.6")

    implementation ("com.squareup.picasso:picasso:2.5.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}