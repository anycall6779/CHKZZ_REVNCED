package app.revanced.patches.chzzk.shortform

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.util.proxy.mutableTypes.MutableMethod
import app.revanced.patches.chzzk.shared.Constants.COMPATIBILITY_CHZZK

@Suppress("unused")
val disableShortFormAdsPatch = bytecodePatch(
    name = "Disable ShortForm Ads",
    description = "Skips GFP/ShortForm ad cards in the CHZZK clip feed.",
) {
    compatibleWith(COMPATIBILITY_CHZZK)

    execute {
        val pageSelectedMethods = ShortFormViewModelPageSelectedFingerprint.classDef.methods.filter { method ->
            method.definingClass == SHORT_FORM_VIEW_MODEL_CLASS &&
                method.name == "G1" &&
                method.returnType == "V"
        }

        if (pageSelectedMethods.isEmpty()) {
            throw PatchException("Could not find ShortForm page selected method.")
        }

        pageSelectedMethods.forEach { method ->
            method.skipAdCardEarly()
        }

        val adBindMethods = ShortFormAdViewHolderFingerprint.classDef.methods.filter { method ->
            method.definingClass == SHORT_FORM_AD_VIEW_HOLDER_CLASS &&
                method.returnType == "V" &&
                method.name in setOf("b", "c")
        }

        if (adBindMethods.isEmpty()) {
            throw PatchException("Could not find ShortForm ad binding methods.")
        }

        adBindMethods.forEach { method ->
            method.returnVoidEarly()
        }
    }
}

private fun MutableMethod.skipAdCardEarly() {
    addInstructions(
        0,
        """
            instance-of v0, p1, Lcom/navercorp/shortform/sdk/data/model/ShortFormItem${'$'}AdCard;
            if-eqz v0, :skip_short_form_ad_continue
            move-object v0, p1
            check-cast v0, Lcom/navercorp/shortform/sdk/data/model/ShortFormItem${'$'}AdCard;
            invoke-virtual {v0}, Lcom/navercorp/shortform/sdk/data/model/ShortFormItem${'$'}AdCard;->getPayload()Ljava/lang/String;
            move-result-object v0
            if-eqz v0, :skip_short_form_ad_return
            invoke-virtual {p0, v0}, Lcom/navercorp/shortform/sdk/ui/ShortFormViewModel;->N1(Ljava/lang/String;)V
            :skip_short_form_ad_return
            return-void
            :skip_short_form_ad_continue
        """.trimIndent()
    )
}

private fun MutableMethod.returnVoidEarly() {
    addInstructions(0, "return-void")
}
