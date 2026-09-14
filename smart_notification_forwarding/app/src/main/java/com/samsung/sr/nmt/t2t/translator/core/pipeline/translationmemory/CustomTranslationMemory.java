package com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTranslationMemory.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\nJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/CustomTranslationMemory;", JsonProperty.USE_DEFAULT_NAME, "customTranslationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;)V", "memory", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemoryUnit;", "clear", JsonProperty.USE_DEFAULT_NAME, "packageName", "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "clearAll", "getMemory", "sourceText", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "loadMemory", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CustomTranslationMemory {
    private final CustomTranslationMemoryLoader customTranslationMemoryLoader;
    private final Map<String, TranslationMemoryUnit> memory;

    @Inject
    public CustomTranslationMemory(CustomTranslationMemoryLoader customTranslationMemoryLoader) {
        Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
        this.customTranslationMemoryLoader = customTranslationMemoryLoader;
        this.memory = new LinkedHashMap();
    }

    public final boolean isLoaded(String packageName, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        TranslationMemoryUnit translationMemoryUnit = this.memory.get(packageName);
        return translationMemoryUnit != null && translationMemoryUnit.isLoaded(languageDirection);
    }

    public final void loadMemory(String packageName, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        if (packageName != null) {
            if (this.memory.get(packageName) == null) {
                this.memory.put(packageName, new TranslationMemoryUnit());
                Unit unit = Unit.INSTANCE;
            }
            Map<LanguageDirection, Map<String, String>> allMemories = this.customTranslationMemoryLoader.getAllMemories(packageName, languageDirection.getSrcLang(), languageDirection.getTgtLang());
            TranslationMemoryUnit translationMemoryUnit = this.memory.get(packageName);
            if (translationMemoryUnit != null) {
                translationMemoryUnit.loadMemory(languageDirection, allMemories);
            }
        }
    }

    public final String getMemory(String packageName, LanguageDirection languageDirection, String sourceText) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        TranslationMemoryUnit translationMemoryUnit = this.memory.get(packageName);
        if (translationMemoryUnit != null) {
            return translationMemoryUnit.getMemory(languageDirection, sourceText);
        }
        return null;
    }

    public final void clear(String packageName, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        TranslationMemoryUnit translationMemoryUnit = this.memory.get(packageName);
        if (translationMemoryUnit != null) {
            translationMemoryUnit.clearMemory(languageDirection);
        }
    }

    public final void clearAll() {
        Iterator<T> it = this.memory.values().iterator();
        while (it.hasNext()) {
            ((TranslationMemoryUnit) it.next()).clearAll();
        }
        this.memory.clear();
    }
}
