package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairManager.kt */
@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairManager;", JsonProperty.USE_DEFAULT_NAME, "replacePairHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairHandler;", "customReplacePairHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/CustomReplacePairHandler;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairHandler;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/CustomReplacePairHandler;)V", "load", JsonProperty.USE_DEFAULT_NAME, "packageName", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "replace", "sourceSentence", "targetSentenceBefore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ReplacePairManager {
    private final CustomReplacePairHandler customReplacePairHandler;
    private final ReplacePairHandler replacePairHandler;

    @Inject
    public ReplacePairManager(ReplacePairHandler replacePairHandler, CustomReplacePairHandler customReplacePairHandler) {
        Intrinsics.checkNotNullParameter(replacePairHandler, "replacePairHandler");
        Intrinsics.checkNotNullParameter(customReplacePairHandler, "customReplacePairHandler");
        this.replacePairHandler = replacePairHandler;
        this.customReplacePairHandler = customReplacePairHandler;
    }

    public final void load(String packageName, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        ReplacePairHandler replacePairHandler = this.replacePairHandler;
        if (!(!replacePairHandler.isLoaded(languageDirection))) {
            replacePairHandler = null;
        }
        if (replacePairHandler != null) {
            replacePairHandler.load(languageDirection);
        }
        CustomReplacePairHandler customReplacePairHandler = this.customReplacePairHandler;
        CustomReplacePairHandler customReplacePairHandler2 = customReplacePairHandler.isLoaded(packageName, languageDirection) ^ true ? customReplacePairHandler : null;
        if (customReplacePairHandler2 != null) {
            customReplacePairHandler2.load(packageName, languageDirection);
        }
    }

    public final String replace(String packageName, LanguageDirection languageDirection, String sourceSentence, String targetSentenceBefore) {
        String replace;
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceSentence, "sourceSentence");
        Intrinsics.checkNotNullParameter(targetSentenceBefore, "targetSentenceBefore");
        String replace2 = this.customReplacePairHandler.replace(packageName, languageDirection, sourceSentence, targetSentenceBefore);
        ReplacePairHandler replacePairHandler = this.replacePairHandler;
        if (!Intrinsics.areEqual(replace2, targetSentenceBefore)) {
            replacePairHandler = null;
        }
        return (replacePairHandler == null || (replace = this.replacePairHandler.replace(languageDirection, sourceSentence, targetSentenceBefore)) == null) ? replace2 : replace;
    }
}
