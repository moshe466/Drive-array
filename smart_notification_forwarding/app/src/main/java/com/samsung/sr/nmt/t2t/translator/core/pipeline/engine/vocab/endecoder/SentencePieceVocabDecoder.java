package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece.SentencePieceVocabJni;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentencePieceVocabDecoder.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/SentencePieceVocabDecoder;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "sentencePieceVocabJni", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;)V", "decode", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "verbose", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentencePieceVocabDecoder implements VocabDecoder {
    private final EngineSpec engineSpec;
    private final SentencePieceResource resource;
    private final SentencePieceVocabJni sentencePieceVocabJni;

    public SentencePieceVocabDecoder(EngineSpec engineSpec, SentencePieceVocabJni sentencePieceVocabJni, SentencePieceResource sentencePieceResource) {
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(sentencePieceVocabJni, "sentencePieceVocabJni");
        this.engineSpec = engineSpec;
        this.sentencePieceVocabJni = sentencePieceVocabJni;
        this.resource = sentencePieceResource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabDecoder
    public String decode(int[] ids, LanguageDirection languageDirection, boolean verbose) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        SentencePieceResource sentencePieceResource = this.resource;
        if (sentencePieceResource == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        List<String> languageIds = sentencePieceResource.getLanguageIds();
        List<Integer> mutableList = ArraysKt.toMutableList(ids);
        DecodeIDsWithJni decodeIDsWithJni = new DecodeIDsWithJni(this.engineSpec, this.sentencePieceVocabJni, null, 4, null);
        if (!languageIds.isEmpty()) {
            return (String) new RejectWithLanguageIDs(languageIds, languageDirection.getSrcLang(), this.engineSpec.getInvalidLanguageIdRejectionRatioThreshold(), new Function1<String, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.SentencePieceVocabDecoder$decode$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String str) {
                    System.out.println((Object) "Rejected by Language IDs (Decode)");
                    return null;
                }
            }, decodeIDsWithJni).convert(mutableList, null);
        }
        return decodeIDsWithJni.convert(mutableList, null);
    }
}
