package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LineLengthSplitRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/LineLengthSplitRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "maxCharsPerSentence", JsonProperty.USE_DEFAULT_NAME, "(I)V", "delimiter", JsonProperty.USE_DEFAULT_NAME, "getDelimiter", "()Ljava/lang/String;", "split", JsonProperty.USE_DEFAULT_NAME, "input", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LineLengthSplitRule implements SplitRule {
    private static final int MAX_CHARS_PER_SENTENCE = 500;
    private final String delimiter;
    private final int maxCharsPerSentence;

    public LineLengthSplitRule() {
        this(0, 1, null);
    }

    public LineLengthSplitRule(int i) {
        this.maxCharsPerSentence = i;
        this.delimiter = " ";
    }

    public /* synthetic */ LineLengthSplitRule(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 500 : i);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public List<String> split(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ArrayList arrayList = new ArrayList();
        String str = input;
        while (str.length() > 500) {
            String substring = input.substring(0, this.maxCharsPerSentence);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring, " ", 0, false, 6, (Object) null);
            if (lastIndexOf$default < 0) {
                lastIndexOf$default = this.maxCharsPerSentence;
            }
            String substring2 = input.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            str = str.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            arrayList.add(substring2);
        }
        arrayList.add(str);
        return arrayList;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public String getDelimiter() {
        return this.delimiter;
    }
}
