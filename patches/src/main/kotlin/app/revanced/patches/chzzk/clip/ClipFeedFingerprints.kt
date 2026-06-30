package app.revanced.patches.chzzk.clip

import app.morphe.patcher.Fingerprint

internal const val CLIP_POPULAR_LOAD_DATA_CLASS =
    "Lcom/navercorp/game/android/community/app/ui/home/clip/popular/ClipPopularViewModel${'$'}loadData${'$'}3;"

internal const val CHANNEL_CLIPS_LOAD_DATA_CLASS =
    "Lcom/navercorp/game/android/community/app/ui/home/channel/tab/clip/ChannelClipsViewModel${'$'}loadData${'$'}4;"

internal const val MANUAL_COMPONENT_CLIPS_LOAD_DATA_CLASS =
    "Lcom/navercorp/game/android/community/app/ui/home/streaming/sub/clip/ManualComponentClipViewModel${'$'}loadClips${'$'}2;"

internal object ClipPopularLoadDataFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == CLIP_POPULAR_LOAD_DATA_CLASS &&
            method.name == "invokeSuspend"
    }
)

internal object ChannelClipsLoadDataFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == CHANNEL_CLIPS_LOAD_DATA_CLASS &&
            method.name == "invokeSuspend"
    }
)

internal object ManualComponentClipsLoadDataFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == MANUAL_COMPONENT_CLIPS_LOAD_DATA_CLASS &&
            method.name == "invokeSuspend"
    }
)
