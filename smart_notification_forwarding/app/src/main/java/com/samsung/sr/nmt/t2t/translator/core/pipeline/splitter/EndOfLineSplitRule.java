package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: EndOfLineSplitRule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/EndOfLineSplitRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "()V", "delimiter", JsonProperty.USE_DEFAULT_NAME, "kotlin.jvm.PlatformType", "getDelimiter", "()Ljava/lang/String;", "split", JsonProperty.USE_DEFAULT_NAME, "input", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EndOfLineSplitRule implements SplitRule {
    private final String delimiter = System.lineSeparator();

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public List<String> split(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        List<String> lines = StringsKt.lines(input);
        if (!lines.isEmpty()) {
            return ((CharSequence) CollectionsKt.last((List) lines)).length() == 0 ? CollectionsKt.dropLast(lines, 1) : lines;
        }
        return lines;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public String getDelimiter() {
        return this.delimiter;
    }
}
