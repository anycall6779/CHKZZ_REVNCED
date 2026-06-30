# CHZZ standalone patch project

This folder is now set up as a CHZZ-only patch project.

Source basis:

- `chkzz_more-main`
- `revanced-patches-1.2.0-dev.8`

Included patch sources:

- `cheatkey/UnlockCheatKeyPatch.kt`
- `cheatkey/DisableReplayAdsPatch.kt`
- `cheatkey/Fingerprints.kt`
- `p2p/DisableP2PPatch.kt`
- `p2p/Fingerprints.kt`
- `tongpow/AutoClaimTongPowPatch.kt`
- `tongpow/Fingerprints.kt`
- `tongpow/TongPowAutoClaimResolver.kt`
- `shared/Constants.kt`

Build entry points:

- `settings.gradle.kts`
- `build.gradle.kts`
- `patches/build.gradle.kts`
- `patches/stub/build.gradle.kts`

Compatibility metadata in this bundle is set for CHZZK.

To build, run the Gradle wrapper from this folder after setting the Morphe/GitHub package credentials required by the upstream patch toolchain.

Requirements:

- Java 17 or newer
- Access to the Morphe/GitHub package repositories used by the upstream patch toolchain
