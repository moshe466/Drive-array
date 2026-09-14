package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThresholdAppliedSplitRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/ThresholdAppliedSplitRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "threshold", JsonProperty.USE_DEFAULT_NAME, "splitRule", "(ILcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;)V", "delimiter", JsonProperty.USE_DEFAULT_NAME, "getDelimiter", "()Ljava/lang/String;", "split", JsonProperty.USE_DEFAULT_NAME, "input", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ThresholdAppliedSplitRule implements SplitRule {
    private final String delimiter;
    private final SplitRule splitRule;
    private final int threshold;

    public ThresholdAppliedSplitRule(int i, SplitRule splitRule) {
        Intrinsics.checkNotNullParameter(splitRule, "splitRule");
        this.threshold = i;
        this.splitRule = splitRule;
        this.delimiter = splitRule.getDelimiter();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public List<String> split(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() >= this.threshold) {
            return this.splitRule.split(input);
        }
        return CollectionsKt.listOf(input);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public String getDelimiter() {
        return this.delimiter;
    }
}
