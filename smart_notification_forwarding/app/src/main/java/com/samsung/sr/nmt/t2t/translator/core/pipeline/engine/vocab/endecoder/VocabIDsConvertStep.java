package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VocabIDsConvertStep.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0004J!\u0010\b\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ#\u0010\u000e\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00028\u0000H$¢\u0006\u0002\u0010\rR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "T", JsonProperty.USE_DEFAULT_NAME, "nextConvertStep", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "getNextConvertStep", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "setNextConvertStep", "convert", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "(Ljava/util/List;Ljava/lang/Object;)Ljava/lang/Object;", "convertDetails", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class VocabIDsConvertStep<T> {
    private VocabIDsConvertStep<T> nextConvertStep;

    /* JADX WARN: Multi-variable type inference failed */
    public VocabIDsConvertStep() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    protected abstract T convertDetails(List<Integer> ids, T previousResult);

    public VocabIDsConvertStep(VocabIDsConvertStep<T> vocabIDsConvertStep) {
        this.nextConvertStep = vocabIDsConvertStep;
    }

    public /* synthetic */ VocabIDsConvertStep(VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : vocabIDsConvertStep);
    }

    protected final VocabIDsConvertStep<T> getNextConvertStep() {
        return this.nextConvertStep;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setNextConvertStep(VocabIDsConvertStep<T> vocabIDsConvertStep) {
        this.nextConvertStep = vocabIDsConvertStep;
    }

    public final T convert(List<Integer> ids, T previousResult) {
        T convert;
        Intrinsics.checkNotNullParameter(ids, "ids");
        T convertDetails = convertDetails(ids, previousResult);
        VocabIDsConvertStep<T> vocabIDsConvertStep = this.nextConvertStep;
        return (vocabIDsConvertStep == null || (convert = vocabIDsConvertStep.convert(ids, convertDetails)) == null) ? convertDetails : convert;
    }
}
