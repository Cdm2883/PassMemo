plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    js {
        browser {
        }
        binaries.executable()
    }

    sourceSets {
        jsMain.dependencies {
            implementation(project(":shared"))
        }
    }
}
