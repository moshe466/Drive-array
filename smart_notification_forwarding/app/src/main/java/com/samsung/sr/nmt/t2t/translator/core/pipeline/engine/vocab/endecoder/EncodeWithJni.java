package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece.SentencePieceVocabJni;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EncodeWithJni.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodeWithJni;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "sentencePieceVocabJni", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;", "inputSentenceWithPrepend", JsonProperty.USE_DEFAULT_NAME, "nextVocabIDsConvertStep", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "convertDetails", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EncodeWithJni extends VocabIDsConvertStep<EncodingResult> {
    private final EngineSpec engineSpec;
    private final String inputSentenceWithPrepend;
    private final SentencePieceVocabJni sentencePieceVocabJni;

    public /* synthetic */ EncodeWithJni(EngineSpec engineSpec, SentencePieceVocabJni sentencePieceVocabJni, String str, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(engineSpec, sentencePieceVocabJni, str, (i & 8) != 0 ? null : vocabIDsConvertStep);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStep
    public /* bridge */ /* synthetic */ EncodingResult convertDetails(List list, EncodingResult encodingResult) {
        return convertDetails2((List<Integer>) list, encodingResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncodeWithJni(EngineSpec engineSpec, SentencePieceVocabJni sentencePieceVocabJni, String inputSentenceWithPrepend, VocabIDsConvertStep<EncodingResult> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(sentencePieceVocabJni, "sentencePieceVocabJni");
        Intrinsics.checkNotNullParameter(inputSentenceWithPrepend, "inputSentenceWithPrepend");
        this.engineSpec = engineSpec;
        this.sentencePieceVocabJni = sentencePieceVocabJni;
        this.inputSentenceWithPrepend = inputSentenceWithPrepend;
    }

    /* renamed from: convertDetails, reason: avoid collision after fix types in other method */
    protected EncodingResult convertDetails2(List<Integer> ids, EncodingResult previousResult) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(previousResult, "previousResult");
        ids.addAll(ArraysKt.toList(this.sentencePieceVocabJni.encode(this.inputSentenceWithPrepend)));
        ids.add(Integer.valueOf(this.engineSpec.getEosId()));
        return previousResult.copy(ids, false);
    }
}
