package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece.SentencePieceVocabJni;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SentencePieceVocabEncoder.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/SentencePieceVocabEncoder;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "sentencePieceVocabJni", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "unknownCharacterFilter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;)V", "encode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "inputSequence", JsonProperty.USE_DEFAULT_NAME, "directionToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;", "honorificToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/HonorificToken;", "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "verbose", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentencePieceVocabEncoder extends VocabEncoder {
    private static final Set<String> NEED_PREPEND = SetsKt.setOf((Object[]) new String[]{"ar", "de", "es", "esmx", "esus", "fr", "frca", "hi", "it", "pl", "ptbr"});
    private final EngineSpec engineSpec;
    private final SentencePieceResource resource;
    private final SentencePieceVocabJni sentencePieceVocabJni;
    private final VocabSpec spec;
    private final UnknownCharacterFilter unknownCharacterFilter;

    public SentencePieceVocabEncoder(EngineSpec engineSpec, SentencePieceVocabJni sentencePieceVocabJni, VocabSpec spec, UnknownCharacterFilter unknownCharacterFilter, SentencePieceResource sentencePieceResource) {
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(sentencePieceVocabJni, "sentencePieceVocabJni");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        this.engineSpec = engineSpec;
        this.sentencePieceVocabJni = sentencePieceVocabJni;
        this.spec = spec;
        this.unknownCharacterFilter = unknownCharacterFilter;
        this.resource = sentencePieceResource;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabEncoder
    public EncodingResult encode(String inputSequence, DirectionToken directionToken, HonorificToken honorificToken, LanguageDirection languageDirection, boolean verbose) {
        Intrinsics.checkNotNullParameter(inputSequence, "inputSequence");
        Intrinsics.checkNotNullParameter(directionToken, "directionToken");
        Intrinsics.checkNotNullParameter(honorificToken, "honorificToken");
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        if (this.resource == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        EncodingResult encodingResult = new EncodingResult(CollectionsKt.emptyList(), false);
        String obj = StringsKt.trim((CharSequence) inputSequence).toString();
        if ((honorificToken.getHonorificTok().length() > 0) && honorificToken.getHonorificTokId() == -1) {
            obj = honorificToken.getHonorificTok() + " " + obj;
        }
        if (directionToken.getPrependDirectionString().length() > 0) {
            obj = directionToken.getPrependDirectionString() + " " + obj;
        }
        ArrayList arrayList = new ArrayList();
        Set<String> set = NEED_PREPEND;
        if (set.contains(languageDirection.getSrcLang()) || set.contains(languageDirection.getTgtLang())) {
            arrayList.add(Integer.valueOf(this.engineSpec.getSpaceTokId()));
        }
        return new RejectWithAlphabets(inputSequence, this.resource.getAlphabets(), this.spec, this.unknownCharacterFilter, new PrependDirectionID(directionToken, new EncodeWithJni(this.engineSpec, this.sentencePieceVocabJni, obj, getRejectWithLanguageIDs(this.resource.getLanguageIds(), languageDirection, this.spec)))).convert(arrayList, encodingResult);
    }
}
