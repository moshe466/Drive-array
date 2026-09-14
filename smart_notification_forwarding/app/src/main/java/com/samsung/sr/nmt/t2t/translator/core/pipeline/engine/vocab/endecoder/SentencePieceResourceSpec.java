package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentencePieceResourceSpec.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/SentencePieceResourceSpec;", JsonProperty.USE_DEFAULT_NAME, "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "vocabResourceReader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResourceReader;", "unknownCharacterFilter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResourceReader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;)V", "getSpec", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "getUnknownCharacterFilter", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "getVocabResourceReader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResourceReader;", "component1", "component2", "component3", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class SentencePieceResourceSpec {
    private final VocabSpec spec;
    private final UnknownCharacterFilter unknownCharacterFilter;
    private final SentencePieceResourceReader vocabResourceReader;

    public static /* synthetic */ SentencePieceResourceSpec copy$default(SentencePieceResourceSpec sentencePieceResourceSpec, VocabSpec vocabSpec, SentencePieceResourceReader sentencePieceResourceReader, UnknownCharacterFilter unknownCharacterFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            vocabSpec = sentencePieceResourceSpec.spec;
        }
        if ((i & 2) != 0) {
            sentencePieceResourceReader = sentencePieceResourceSpec.vocabResourceReader;
        }
        if ((i & 4) != 0) {
            unknownCharacterFilter = sentencePieceResourceSpec.unknownCharacterFilter;
        }
        return sentencePieceResourceSpec.copy(vocabSpec, sentencePieceResourceReader, unknownCharacterFilter);
    }

    /* renamed from: component1, reason: from getter */
    public final VocabSpec getSpec() {
        return this.spec;
    }

    /* renamed from: component2, reason: from getter */
    public final SentencePieceResourceReader getVocabResourceReader() {
        return this.vocabResourceReader;
    }

    /* renamed from: component3, reason: from getter */
    public final UnknownCharacterFilter getUnknownCharacterFilter() {
        return this.unknownCharacterFilter;
    }

    public final SentencePieceResourceSpec copy(VocabSpec spec, SentencePieceResourceReader vocabResourceReader, UnknownCharacterFilter unknownCharacterFilter) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(vocabResourceReader, "vocabResourceReader");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        return new SentencePieceResourceSpec(spec, vocabResourceReader, unknownCharacterFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SentencePieceResourceSpec)) {
            return false;
        }
        SentencePieceResourceSpec sentencePieceResourceSpec = (SentencePieceResourceSpec) other;
        return Intrinsics.areEqual(this.spec, sentencePieceResourceSpec.spec) && Intrinsics.areEqual(this.vocabResourceReader, sentencePieceResourceSpec.vocabResourceReader) && Intrinsics.areEqual(this.unknownCharacterFilter, sentencePieceResourceSpec.unknownCharacterFilter);
    }

    public int hashCode() {
        return (((this.spec.hashCode() * 31) + this.vocabResourceReader.hashCode()) * 31) + this.unknownCharacterFilter.hashCode();
    }

    public String toString() {
        return "SentencePieceResourceSpec(spec=" + this.spec + ", vocabResourceReader=" + this.vocabResourceReader + ", unknownCharacterFilter=" + this.unknownCharacterFilter + ")";
    }

    public SentencePieceResourceSpec(VocabSpec spec, SentencePieceResourceReader vocabResourceReader, UnknownCharacterFilter unknownCharacterFilter) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(vocabResourceReader, "vocabResourceReader");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        this.spec = spec;
        this.vocabResourceReader = vocabResourceReader;
        this.unknownCharacterFilter = unknownCharacterFilter;
    }

    public final VocabSpec getSpec() {
        return this.spec;
    }

    public final SentencePieceResourceReader getVocabResourceReader() {
        return this.vocabResourceReader;
    }

    public final UnknownCharacterFilter getUnknownCharacterFilter() {
        return this.unknownCharacterFilter;
    }
}
