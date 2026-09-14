package com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationMemory.kt */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;", JsonProperty.USE_DEFAULT_NAME, "translationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "translationMemoryUnit", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemoryUnit;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemoryUnit;)V", "cache", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "addMemory", JsonProperty.USE_DEFAULT_NAME, "formality", "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "sourceText", JsonProperty.USE_DEFAULT_NAME, "targetText", "clearAll", "clearMemory", "getMemory", "isLoaded", "loadMemory", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationMemory {
    private final Map<Boolean, TranslationMemoryUnit> cache;
    private final TranslationMemoryLoader translationMemoryLoader;
    private final TranslationMemoryUnit translationMemoryUnit;

    @Inject
    public TranslationMemory(TranslationMemoryLoader translationMemoryLoader, TranslationMemoryUnit translationMemoryUnit) {
        Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
        Intrinsics.checkNotNullParameter(translationMemoryUnit, "translationMemoryUnit");
        this.translationMemoryLoader = translationMemoryLoader;
        this.translationMemoryUnit = translationMemoryUnit;
        this.cache = new LinkedHashMap();
    }

    public final boolean isLoaded(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        return this.translationMemoryUnit.isLoaded(languageDirection);
    }

    public final void loadMemory(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        this.translationMemoryUnit.loadMemory(languageDirection, this.translationMemoryLoader.getAllMemories(languageDirection.getSrcLang(), languageDirection.getTgtLang()));
    }

    public final void addMemory(boolean formality, LanguageDirection languageDirection, String sourceText, String targetText) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        if (this.cache.get(Boolean.valueOf(formality)) == null) {
            this.cache.put(Boolean.valueOf(formality), new TranslationMemoryUnit());
            Unit unit = Unit.INSTANCE;
        }
        TranslationMemoryUnit translationMemoryUnit = this.cache.get(Boolean.valueOf(formality));
        if (translationMemoryUnit != null) {
            translationMemoryUnit.addMemory(languageDirection, sourceText, targetText);
        }
    }

    public final String getMemory(boolean formality, LanguageDirection languageDirection, String sourceText) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        String memory = this.translationMemoryUnit.getMemory(languageDirection, sourceText);
        if (memory != null) {
            return memory;
        }
        TranslationMemoryUnit translationMemoryUnit = this.cache.get(Boolean.valueOf(formality));
        if (translationMemoryUnit != null) {
            return translationMemoryUnit.getMemory(languageDirection, sourceText);
        }
        return null;
    }

    public final void clearMemory(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        this.translationMemoryUnit.clearMemory(languageDirection);
        Iterator<T> it = this.cache.values().iterator();
        while (it.hasNext()) {
            ((TranslationMemoryUnit) it.next()).clearMemory(languageDirection);
        }
    }

    public final void clearAll() {
        this.translationMemoryUnit.clearAll();
        Iterator<T> it = this.cache.values().iterator();
        while (it.hasNext()) {
            ((TranslationMemoryUnit) it.next()).clearAll();
        }
        this.cache.clear();
    }
}
