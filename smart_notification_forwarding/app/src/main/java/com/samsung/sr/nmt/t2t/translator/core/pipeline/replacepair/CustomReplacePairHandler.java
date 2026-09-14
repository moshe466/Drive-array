package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomReplacePairHandler.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/CustomReplacePairHandler;", JsonProperty.USE_DEFAULT_NAME, "customReplacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;)V", "replacePairCache", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairUnit;", "clear", JsonProperty.USE_DEFAULT_NAME, "packageName", "clearAll", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "load", "replace", "sourceSentence", "targetSentenceBefore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CustomReplacePairHandler {
    private final CustomReplacePairLoader customReplacePairLoader;
    private final Map<String, ReplacePairUnit> replacePairCache;

    @Inject
    public CustomReplacePairHandler(CustomReplacePairLoader customReplacePairLoader) {
        Intrinsics.checkNotNullParameter(customReplacePairLoader, "customReplacePairLoader");
        this.customReplacePairLoader = customReplacePairLoader;
        this.replacePairCache = new LinkedHashMap();
    }

    public final boolean isLoaded(String packageName, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        ReplacePairUnit replacePairUnit = this.replacePairCache.get(packageName);
        return replacePairUnit != null && replacePairUnit.isLoaded(languageDirection);
    }

    public final void load(String packageName, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        if (packageName != null) {
            if (this.replacePairCache.get(packageName) == null) {
                this.replacePairCache.put(packageName, new ReplacePairUnit());
                Unit unit = Unit.INSTANCE;
            }
            List<ReplacePair> replacePairs = this.customReplacePairLoader.getReplacePairs(packageName, languageDirection.getSrcLang(), languageDirection.getTgtLang());
            ReplacePairUnit replacePairUnit = this.replacePairCache.get(packageName);
            if (replacePairUnit != null) {
                replacePairUnit.load(languageDirection, replacePairs);
            }
        }
    }

    public final String replace(String packageName, LanguageDirection languageDirection, String sourceSentence, String targetSentenceBefore) {
        String replace;
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceSentence, "sourceSentence");
        Intrinsics.checkNotNullParameter(targetSentenceBefore, "targetSentenceBefore");
        ReplacePairUnit replacePairUnit = this.replacePairCache.get(packageName);
        return (replacePairUnit == null || (replace = replacePairUnit.replace(languageDirection, sourceSentence, targetSentenceBefore)) == null) ? targetSentenceBefore : replace;
    }

    public final void clear(String packageName) {
        ReplacePairUnit replacePairUnit = this.replacePairCache.get(packageName);
        if (replacePairUnit != null) {
            replacePairUnit.clear();
        }
    }

    public final void clearAll() {
        Iterator<T> it = this.replacePairCache.values().iterator();
        while (it.hasNext()) {
            ((ReplacePairUnit) it.next()).clear();
        }
        this.replacePairCache.clear();
    }
}
