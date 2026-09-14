package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairHandler.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairHandler;", JsonProperty.USE_DEFAULT_NAME, "replacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "replacePairUnit", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairUnit;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairUnit;)V", "clear", JsonProperty.USE_DEFAULT_NAME, "isLoaded", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "load", "replace", JsonProperty.USE_DEFAULT_NAME, "sourceSentence", "targetSentenceBefore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ReplacePairHandler {
    private final ReplacePairLoader replacePairLoader;
    private final ReplacePairUnit replacePairUnit;

    @Inject
    public ReplacePairHandler(ReplacePairLoader replacePairLoader, ReplacePairUnit replacePairUnit) {
        Intrinsics.checkNotNullParameter(replacePairLoader, "replacePairLoader");
        Intrinsics.checkNotNullParameter(replacePairUnit, "replacePairUnit");
        this.replacePairLoader = replacePairLoader;
        this.replacePairUnit = replacePairUnit;
    }

    public final boolean isLoaded(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        return this.replacePairUnit.isLoaded(languageDirection);
    }

    public final void load(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        this.replacePairUnit.load(languageDirection, this.replacePairLoader.getReplacePairs(languageDirection.getSrcLang(), languageDirection.getTgtLang()));
    }

    public final String replace(LanguageDirection languageDirection, String sourceSentence, String targetSentenceBefore) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceSentence, "sourceSentence");
        Intrinsics.checkNotNullParameter(targetSentenceBefore, "targetSentenceBefore");
        return this.replacePairUnit.replace(languageDirection, sourceSentence, targetSentenceBefore);
    }

    public final void clear() {
        this.replacePairUnit.clear();
    }
}
