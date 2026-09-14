package com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationMemoryUnit.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0005J.\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemoryUnit;", JsonProperty.USE_DEFAULT_NAME, "()V", "loadedResources", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "memory", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "addMemory", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "sourceText", "targetText", "clearAll", "clearMemory", "getMemory", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "loadMemory", "memories", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationMemoryUnit {
    private final Map<LanguageDirection, Map<String, String>> memory = new LinkedHashMap();
    private final Set<LanguageDirection> loadedResources = new LinkedHashSet();

    public final boolean isLoaded(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        return this.loadedResources.contains(languageDirection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadMemory(LanguageDirection languageDirection, Map<LanguageDirection, ? extends Map<String, String>> memories) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(memories, "memories");
        this.loadedResources.add(languageDirection);
        this.loadedResources.add(languageDirection.reversed());
        Iterator<T> it = memories.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            this.memory.put(entry.getKey(), entry.getValue());
        }
    }

    public final void addMemory(LanguageDirection languageDirection, String sourceText, String targetText) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        if (!this.memory.containsKey(languageDirection)) {
            this.memory.put(languageDirection, MapsKt.mutableMapOf(TuplesKt.to(sourceText, targetText)));
            return;
        }
        Map<String, String> map = this.memory.get(languageDirection);
        Intrinsics.checkNotNull(map);
        map.put(sourceText, targetText);
    }

    public final String getMemory(LanguageDirection languageDirection, String sourceText) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Map<String, String> map = this.memory.get(languageDirection);
        if (map != null) {
            return map.get(sourceText);
        }
        return null;
    }

    public final void clearMemory(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        this.memory.remove(languageDirection);
        this.loadedResources.remove(languageDirection);
    }

    public final void clearAll() {
        this.memory.clear();
        this.loadedResources.clear();
    }
}
