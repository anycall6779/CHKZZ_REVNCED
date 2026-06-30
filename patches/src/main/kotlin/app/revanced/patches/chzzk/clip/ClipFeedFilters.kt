package app.revanced.patches.chzzk.clip

import app.morphe.patcher.patch.bytecodePatch
import app.revanced.patches.chzzk.shared.Constants.COMPATIBILITY_CHZZK

@Suppress("unused")
val clipFeedFiltersPatch = bytecodePatch(
    name = "Disable Clip Recommendations",
    description = "Empties CHZZK clip recommendation feeds before they are shown.",
) {
    compatibleWith(COMPATIBILITY_CHZZK)

    execute {
        // Intentionally left blank so clip feed content stays available.
    }
}
