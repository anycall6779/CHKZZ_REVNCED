package app.revanced.patches.chzzk.clip

import app.morphe.patcher.Fingerprint

internal const val CLIP_POPULAR_SCREEN_CLASS =
    "Lcom/navercorp/game/android/community/app/ui/home/clip/popular/ClipPopularScreenKt;"

internal const val CHANNEL_CLIPS_SCREEN_CLASS =
    "Lcom/navercorp/game/android/community/app/ui/home/channel/tab/clip/ChannelClipsScreenKt;"

internal const val SUB_PAGE_CLIPS_SCREEN_CLASS =
    "Lcom/navercorp/game/android/community/app/ui/home/streaming/sub/clip/SubPageClipsScreenKt;"

internal object ClipPopularScreenFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == CLIP_POPULAR_SCREEN_CLASS &&
            method.name == "J" &&
            method.returnType == "Lkotlin/Unit;"
    }
)

internal object ChannelClipsScreenFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == CHANNEL_CLIPS_SCREEN_CLASS &&
            method.name == "Z" &&
            method.returnType == "Lkotlin/Unit;"
    }
)

internal object SubPageClipsScreenFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == SUB_PAGE_CLIPS_SCREEN_CLASS &&
            method.name == "Z" &&
            method.returnType == "Lkotlin/Unit;"
    }
)
