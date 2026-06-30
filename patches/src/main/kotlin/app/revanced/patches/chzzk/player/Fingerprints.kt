package app.revanced.patches.chzzk.player

import app.morphe.patcher.Fingerprint

internal const val PLAYER_RECOMMENDED_SCREEN_CLASS =
    "Lcom/navercorp/game/android/community/app/feature/player/playlist/CzzPlayerRecommendedScreenKt;"

internal object PlayerRecommendedScreenFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == PLAYER_RECOMMENDED_SCREEN_CLASS &&
            method.name == "G" &&
            method.returnType == "V"
    }
)
