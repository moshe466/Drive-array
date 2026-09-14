package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentencePieceResource.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabResource;", "alphabets", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "languageIds", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/Set;Ljava/util/List;)V", "getAlphabets", "()Ljava/util/Set;", "getLanguageIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", JsonProperty.USE_DEFAULT_NAME, "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class SentencePieceResource implements VocabResource {
    private final Set<Character> alphabets;
    private final List<String> languageIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SentencePieceResource copy$default(SentencePieceResource sentencePieceResource, Set set, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            set = sentencePieceResource.alphabets;
        }
        if ((i & 2) != 0) {
            list = sentencePieceResource.languageIds;
        }
        return sentencePieceResource.copy(set, list);
    }

    public final Set<Character> component1() {
        return this.alphabets;
    }

    public final List<String> component2() {
        return this.languageIds;
    }

    public final SentencePieceResource copy(Set<Character> alphabets, List<String> languageIds) {
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        Intrinsics.checkNotNullParameter(languageIds, "languageIds");
        return new SentencePieceResource(alphabets, languageIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SentencePieceResource)) {
            return false;
        }
        SentencePieceResource sentencePieceResource = (SentencePieceResource) other;
        return Intrinsics.areEqual(this.alphabets, sentencePieceResource.alphabets) && Intrinsics.areEqual(this.languageIds, sentencePieceResource.languageIds);
    }

    public int hashCode() {
        return (this.alphabets.hashCode() * 31) + this.languageIds.hashCode();
    }

    public String toString() {
        return "SentencePieceResource(alphabets=" + this.alphabets + ", languageIds=" + this.languageIds + ")";
    }

    public SentencePieceResource(Set<Character> alphabets, List<String> languageIds) {
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        Intrinsics.checkNotNullParameter(languageIds, "languageIds");
        this.alphabets = alphabets;
        this.languageIds = languageIds;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabResource
    public Set<Character> getAlphabets() {
        return this.alphabets;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabResource
    public List<String> getLanguageIds() {
        return this.languageIds;
    }
}
