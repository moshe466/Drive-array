package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitter;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WordPieceVocabEncoder.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/WordPieceVocabEncoder;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "unknownCharacterFilter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "plhHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PlhHandler;", "textSplitter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PlhHandler;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;)V", "encode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "inputSequence", JsonProperty.USE_DEFAULT_NAME, "directionToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;", "honorificToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/HonorificToken;", "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "verbose", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WordPieceVocabEncoder extends VocabEncoder {
    private final PlhHandler plhHandler;
    private final WordPieceResource resource;
    private final VocabSpec spec;
    private final TextSplitter textSplitter;
    private final UnknownCharacterFilter unknownCharacterFilter;

    public WordPieceVocabEncoder(VocabSpec spec, UnknownCharacterFilter unknownCharacterFilter, WordPieceResource wordPieceResource, PlhHandler plhHandler, TextSplitter textSplitter) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        Intrinsics.checkNotNullParameter(textSplitter, "textSplitter");
        this.spec = spec;
        this.unknownCharacterFilter = unknownCharacterFilter;
        this.resource = wordPieceResource;
        this.plhHandler = plhHandler;
        this.textSplitter = textSplitter;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabEncoder
    public EncodingResult encode(String inputSequence, DirectionToken directionToken, HonorificToken honorificToken, LanguageDirection languageDirection, boolean verbose) {
        EncodeTextWithoutPlh encodeTextWithoutPlh;
        Intrinsics.checkNotNullParameter(inputSequence, "inputSequence");
        Intrinsics.checkNotNullParameter(directionToken, "directionToken");
        Intrinsics.checkNotNullParameter(honorificToken, "honorificToken");
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        if (this.resource == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        EncodingResult encodingResult = new EncodingResult(CollectionsKt.emptyList(), false);
        RejectWithLanguageIDs<EncodingResult> rejectWithLanguageIDs = getRejectWithLanguageIDs(this.resource.getLanguageIds(), languageDirection, this.spec);
        String obj = StringsKt.trim((CharSequence) this.unknownCharacterFilter.filterUnknownCharacter(this.resource.getAlphabets(), inputSequence).getText()).toString();
        if (this.spec.getProcessPlh() & this.spec.getPreventPlhTokenSplits()) {
            encodeTextWithoutPlh = new EncodeTextWithPlh(this.resource, obj, this.plhHandler, this.textSplitter, null, rejectWithLanguageIDs, 16, null);
        } else {
            encodeTextWithoutPlh = new EncodeTextWithoutPlh(this.resource, obj, this.textSplitter, directionToken, rejectWithLanguageIDs);
        }
        return new PrependDirectionID(directionToken, new RejectWithAlphabets(inputSequence, this.resource.getAlphabets(), this.spec, this.unknownCharacterFilter, encodeTextWithoutPlh)).convert(new ArrayList(), encodingResult);
    }
}
