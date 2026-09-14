package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece.SentencePieceVocabJni;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecodeIDsWithJni.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DecodeIDsWithJni;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", JsonProperty.USE_DEFAULT_NAME, "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "sentencePieceVocabJni", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;", "nextConvertStep", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "convertDetails", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DecodeIDsWithJni extends VocabIDsConvertStep<String> {
    private final EngineSpec engineSpec;
    private final SentencePieceVocabJni sentencePieceVocabJni;

    public /* synthetic */ DecodeIDsWithJni(EngineSpec engineSpec, SentencePieceVocabJni sentencePieceVocabJni, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(engineSpec, sentencePieceVocabJni, (i & 4) != 0 ? null : vocabIDsConvertStep);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStep
    public /* bridge */ /* synthetic */ String convertDetails(List list, String str) {
        return convertDetails2((List<Integer>) list, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodeIDsWithJni(EngineSpec engineSpec, SentencePieceVocabJni sentencePieceVocabJni, VocabIDsConvertStep<String> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(sentencePieceVocabJni, "sentencePieceVocabJni");
        this.engineSpec = engineSpec;
        this.sentencePieceVocabJni = sentencePieceVocabJni;
    }

    /* renamed from: convertDetails, reason: avoid collision after fix types in other method */
    protected String convertDetails2(List<Integer> ids, String previousResult) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        ArrayList arrayList = new ArrayList();
        for (Object obj : ids) {
            int intValue = ((Number) obj).intValue();
            if ((intValue == this.engineSpec.getPadId() || intValue == this.engineSpec.getEosId()) ? false : true) {
                arrayList.add(obj);
            }
        }
        return this.sentencePieceVocabJni.decode(CollectionsKt.toIntArray(arrayList));
    }
}
