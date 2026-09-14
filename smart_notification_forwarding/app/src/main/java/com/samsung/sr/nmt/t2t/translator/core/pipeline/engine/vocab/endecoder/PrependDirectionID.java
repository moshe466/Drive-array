package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrependDirectionID.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PrependDirectionID;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "directionToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;", "nextConvertStep", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "convertDetails", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PrependDirectionID extends VocabIDsConvertStep<EncodingResult> {
    private final DirectionToken directionToken;

    public /* synthetic */ PrependDirectionID(DirectionToken directionToken, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(directionToken, (i & 2) != 0 ? null : vocabIDsConvertStep);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStep
    public /* bridge */ /* synthetic */ EncodingResult convertDetails(List list, EncodingResult encodingResult) {
        return convertDetails2((List<Integer>) list, encodingResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrependDirectionID(DirectionToken directionToken, VocabIDsConvertStep<EncodingResult> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(directionToken, "directionToken");
        this.directionToken = directionToken;
    }

    /* renamed from: convertDetails, reason: avoid collision after fix types in other method */
    protected EncodingResult convertDetails2(List<Integer> ids, EncodingResult previousResult) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(previousResult, "previousResult");
        if (this.directionToken.getPrependDirectionId() != -1) {
            ids.add(Integer.valueOf(this.directionToken.getPrependDirectionId()));
        }
        return previousResult;
    }
}
