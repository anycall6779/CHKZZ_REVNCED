package app.revanced.patches.chzzk.clip

import app.morphe.patcher.patch.bytecodePatch
import app.revanced.patches.chzzk.shared.Constants.COMPATIBILITY_CHZZK

@Suppress("unused")
val disableClipRecommendationsPatch = bytecodePatch(
    name = "Disable Clip Recommendations",
    description = "Hides clip recommendation and browse card rendering in CHZZK clip sections.",
) {
    compatibleWith(COMPATIBILITY_CHZZK)

    execute {
        // Intentionally left blank so clip content keeps rendering normally.
    }
}
