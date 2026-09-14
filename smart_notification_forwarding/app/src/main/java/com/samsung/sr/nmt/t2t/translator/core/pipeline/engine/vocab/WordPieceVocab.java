package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.PlaceholderSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.PlhHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.UnknownCharacterFilter;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabDecoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabEncoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.WordPieceVocabDecoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.WordPieceVocabEncoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitter;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitterFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WordPieceVocab.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/WordPieceVocab;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/Vocab;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "vocabResourceReader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResourceReader;", "unknownCharacterFilter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResourceReader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;)V", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "()Z", "plhHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PlhHandler;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "textSplitter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;", "vocabDecoder", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", "getVocabDecoder", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", "vocabEncoder", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", "getVocabEncoder", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", "clear", JsonProperty.USE_DEFAULT_NAME, "getPlaceholderSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/PlaceholderSpec;", "load", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WordPieceVocab extends Vocab {
    private PlhHandler plhHandler;
    private WordPieceResource resource;
    private final VocabSpec spec;
    private final TextSplitter textSplitter;
    private final UnknownCharacterFilter unknownCharacterFilter;
    private final WordPieceResourceReader vocabResourceReader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WordPieceVocab(VocabSpec spec, WordPieceResourceReader vocabResourceReader, UnknownCharacterFilter unknownCharacterFilter) {
        super(spec.getEosId());
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(vocabResourceReader, "vocabResourceReader");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        this.spec = spec;
        this.vocabResourceReader = vocabResourceReader;
        this.unknownCharacterFilter = unknownCharacterFilter;
        this.textSplitter = TextSplitterFactory.INSTANCE.createTextSplitter(spec.isIndian());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public void load() {
        if (isLoaded()) {
            return;
        }
        this.resource = this.vocabResourceReader.getResource(this.spec);
        if (this.spec.getProcessPlh()) {
            this.plhHandler = new PlhHandler(this.spec.getPlhTok(), this.spec.getNumPlhTok());
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public boolean isLoaded() {
        return this.resource != null;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public VocabEncoder getVocabEncoder() {
        return new WordPieceVocabEncoder(this.spec, this.unknownCharacterFilter, this.resource, this.plhHandler, this.textSplitter);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public VocabDecoder getVocabDecoder() {
        return new WordPieceVocabDecoder(this.spec, this.resource);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public PlaceholderSpec getPlaceholderSpec() {
        return new PlaceholderSpec(this.spec.getProcessPlh(), this.spec.getPlhTok(), this.spec.getNumPlhTok(), this.spec.getPreventPlhTokenSplits());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public void clear() {
        this.resource = null;
        this.plhHandler = null;
    }
}
