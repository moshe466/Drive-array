package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WordPieceResource.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabResource;", "subwords", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "alphabets", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "languageIds", "subwordToIds", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/List;Ljava/util/Set;Ljava/util/List;Ljava/util/Map;)V", "getAlphabets", "()Ljava/util/Set;", "getLanguageIds", "()Ljava/util/List;", "getSubwordToIds", "()Ljava/util/Map;", "getSubwords", "component1", "component2", "component3", "component4", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", JsonProperty.USE_DEFAULT_NAME, "hashCode", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class WordPieceResource implements VocabResource {
    private final Set<Character> alphabets;
    private final List<String> languageIds;
    private final Map<String, Integer> subwordToIds;
    private final List<String> subwords;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WordPieceResource copy$default(WordPieceResource wordPieceResource, List list, Set set, List list2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = wordPieceResource.subwords;
        }
        if ((i & 2) != 0) {
            set = wordPieceResource.alphabets;
        }
        if ((i & 4) != 0) {
            list2 = wordPieceResource.languageIds;
        }
        if ((i & 8) != 0) {
            map = wordPieceResource.subwordToIds;
        }
        return wordPieceResource.copy(list, set, list2, map);
    }

    public final List<String> component1() {
        return this.subwords;
    }

    public final Set<Character> component2() {
        return this.alphabets;
    }

    public final List<String> component3() {
        return this.languageIds;
    }

    public final Map<String, Integer> component4() {
        return this.subwordToIds;
    }

    public final WordPieceResource copy(List<String> subwords, Set<Character> alphabets, List<String> languageIds, Map<String, Integer> subwordToIds) {
        Intrinsics.checkNotNullParameter(subwords, "subwords");
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        Intrinsics.checkNotNullParameter(languageIds, "languageIds");
        Intrinsics.checkNotNullParameter(subwordToIds, "subwordToIds");
        return new WordPieceResource(subwords, alphabets, languageIds, subwordToIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WordPieceResource)) {
            return false;
        }
        WordPieceResource wordPieceResource = (WordPieceResource) other;
        return Intrinsics.areEqual(this.subwords, wordPieceResource.subwords) && Intrinsics.areEqual(this.alphabets, wordPieceResource.alphabets) && Intrinsics.areEqual(this.languageIds, wordPieceResource.languageIds) && Intrinsics.areEqual(this.subwordToIds, wordPieceResource.subwordToIds);
    }

    public int hashCode() {
        return (((((this.subwords.hashCode() * 31) + this.alphabets.hashCode()) * 31) + this.languageIds.hashCode()) * 31) + this.subwordToIds.hashCode();
    }

    public String toString() {
        return "WordPieceResource(subwords=" + this.subwords + ", alphabets=" + this.alphabets + ", languageIds=" + this.languageIds + ", subwordToIds=" + this.subwordToIds + ")";
    }

    public WordPieceResource(List<String> subwords, Set<Character> alphabets, List<String> languageIds, Map<String, Integer> subwordToIds) {
        Intrinsics.checkNotNullParameter(subwords, "subwords");
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        Intrinsics.checkNotNullParameter(languageIds, "languageIds");
        Intrinsics.checkNotNullParameter(subwordToIds, "subwordToIds");
        this.subwords = subwords;
        this.alphabets = alphabets;
        this.languageIds = languageIds;
        this.subwordToIds = subwordToIds;
    }

    public final List<String> getSubwords() {
        return this.subwords;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabResource
    public Set<Character> getAlphabets() {
        return this.alphabets;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabResource
    public List<String> getLanguageIds() {
        return this.languageIds;
    }

    public final Map<String, Integer> getSubwordToIds() {
        return this.subwordToIds;
    }
}
