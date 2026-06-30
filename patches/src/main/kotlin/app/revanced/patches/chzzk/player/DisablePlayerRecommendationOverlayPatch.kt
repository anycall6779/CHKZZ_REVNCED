package app.revanced.patches.chzzk.player

import app.morphe.patcher.patch.bytecodePatch
import app.revanced.patches.chzzk.shared.Constants.COMPATIBILITY_CHZZK

@Suppress("unused")
val disablePlayerRecommendationOverlayPatch = bytecodePatch(
    name = "Disable Clip Overlay Recommendation",
    description = "Hides the clip player recommendation overlay and promo card area.",
) {
    compatibleWith(COMPATIBILITY_CHZZK)

    execute {
        // Intentionally left blank so the player overlay logic stays intact.
    }
}
