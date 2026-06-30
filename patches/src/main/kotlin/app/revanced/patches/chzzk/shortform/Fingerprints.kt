package app.revanced.patches.chzzk.shortform

import app.morphe.patcher.Fingerprint

internal const val RECOMMENDED_CARDS_MODEL_CLASS =
    "Lcom/navercorp/shortform/sdk/data/model/RecommendedCardsModel;"

internal const val SHORT_FORM_VIEW_MODEL_CLASS =
    "Lcom/navercorp/shortform/sdk/ui/ShortFormViewModel;"

internal const val SHORT_FORM_AD_VIEW_HOLDER_CLASS =
    "Lcom/navercorp/shortform/sdk/ui/ad/ShortFormAdViewHolder;"

internal object RecommendedCardsModelFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == RECOMMENDED_CARDS_MODEL_CLASS &&
            method.name == "getAdCards" &&
            method.returnType == "Ljava/util/List;"
    }
)

internal object ShortFormViewModelPageSelectedFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == SHORT_FORM_VIEW_MODEL_CLASS &&
            method.name == "G1" &&
            method.returnType == "V"
    }
)

internal object ShortFormAdViewHolderFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.type == SHORT_FORM_AD_VIEW_HOLDER_CLASS &&
            method.name in setOf("b", "c")
    }
)
