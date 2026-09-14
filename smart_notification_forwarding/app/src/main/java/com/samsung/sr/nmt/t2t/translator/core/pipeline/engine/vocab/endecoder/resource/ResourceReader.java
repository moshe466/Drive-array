package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceReader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceReader;", JsonProperty.USE_DEFAULT_NAME, "languageIdsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;", "alphabetsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;)V", "getAlphabetsResourceLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;", "getLanguageIdsResourceLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;", "getResource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabResource;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class ResourceReader {
    private final AlphabetsResourceLoader alphabetsResourceLoader;
    private final LanguageIdsResourceLoader languageIdsResourceLoader;

    public abstract VocabResource getResource(VocabSpec spec);

    public ResourceReader(LanguageIdsResourceLoader languageIdsResourceLoader, AlphabetsResourceLoader alphabetsResourceLoader) {
        Intrinsics.checkNotNullParameter(languageIdsResourceLoader, "languageIdsResourceLoader");
        Intrinsics.checkNotNullParameter(alphabetsResourceLoader, "alphabetsResourceLoader");
        this.languageIdsResourceLoader = languageIdsResourceLoader;
        this.alphabetsResourceLoader = alphabetsResourceLoader;
    }

    public final LanguageIdsResourceLoader getLanguageIdsResourceLoader() {
        return this.languageIdsResourceLoader;
    }

    public final AlphabetsResourceLoader getAlphabetsResourceLoader() {
        return this.alphabetsResourceLoader;
    }
}
