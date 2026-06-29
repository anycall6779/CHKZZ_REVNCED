group = "app.revanced"

patches {
    about {
        name = "CHZZK Patches"
        description = "Standalone CHZZK patch bundle"
        source = "local"
        author = "Codex"
        contact = "na"
        website = "na"
        license = "GNU General Public License v3.0"
    }
}

dependencies {
    implementation(libs.gson)
    implementation(libs.guava)
    implementation(libs.morphe.patches.library)
    implementation(libs.apksig)
    compileOnly(project(":patches:stub"))
}

tasks {
    register<JavaExec>("checkStringResources") {
        description = "Checks resource strings for invalid formatting"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set("app.morphe.patches.util.resource.CheckStringResourcesKt")
    }

    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set("app.morphe.util.PatchListGeneratorKt")
    }

    publish {
        dependsOn("generatePatchesList")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-parameters")
    }
}

publishing {
    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/amplerevanced/revanced-patches")
            credentials(PasswordCredentials::class)
        }
    }
}

