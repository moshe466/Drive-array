package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VocabIDsConvertStepRejectable.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\rH$J\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStepRejectable;", "T", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "nextConvertStep", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "convertDetails", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "(Ljava/util/List;Ljava/lang/Object;)Ljava/lang/Object;", "isRejectable", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "resultWhenFail", "(Ljava/lang/Object;)Ljava/lang/Object;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class VocabIDsConvertStepRejectable<T> extends VocabIDsConvertStep<T> {
    /* JADX WARN: Multi-variable type inference failed */
    public VocabIDsConvertStepRejectable() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    protected abstract boolean isRejectable(List<Integer> ids);

    protected abstract T resultWhenFail(T previousResult);

    public /* synthetic */ VocabIDsConvertStepRejectable(VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : vocabIDsConvertStep);
    }

    public VocabIDsConvertStepRejectable(VocabIDsConvertStep<T> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStep
    protected T convertDetails(List<Integer> ids, T previousResult) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        if (!isRejectable(ids)) {
            return previousResult;
        }
        setNextConvertStep(null);
        return resultWhenFail(previousResult);
    }
}
