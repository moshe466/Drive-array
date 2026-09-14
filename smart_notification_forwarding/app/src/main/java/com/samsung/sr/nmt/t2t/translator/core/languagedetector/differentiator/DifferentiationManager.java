package com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DifferentiationManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B \b\u0007\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u001f\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/DifferentiationManager;", JsonProperty.USE_DEFAULT_NAME, "differentiatorMap", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/LanguageDifferentiator;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "differentiate", "language", "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DifferentiationManager {
    private final Map<String, LanguageDifferentiator> differentiatorMap;

    @Inject
    public DifferentiationManager(Map<String, LanguageDifferentiator> differentiatorMap) {
        Intrinsics.checkNotNullParameter(differentiatorMap, "differentiatorMap");
        this.differentiatorMap = differentiatorMap;
    }

    public final String differentiate(String language, String text) {
        String differentiate;
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(text, "text");
        LanguageDifferentiator languageDifferentiator = this.differentiatorMap.get(language);
        return (languageDifferentiator == null || (differentiate = languageDifferentiator.differentiate(text)) == null) ? language : differentiate;
    }
}
