buildscript {
    repositories {
        google()
        mavenCentral() // Replacing jcenter() with mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2") // Ensure you have the correct version here
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31") // Ensure you have the correct Kotlin version here
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
