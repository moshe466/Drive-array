package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PunctuationInQuoteFormattingRule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/PunctuationInQuoteFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "quoteStyle", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DoubleQuoteStyle;", "punctuationStyle", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/PunctuationQuoteStyle;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DoubleQuoteStyle;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/PunctuationQuoteStyle;)V", "restore", JsonProperty.USE_DEFAULT_NAME, "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PunctuationInQuoteFormattingRule implements FormattingRule {
    private final PunctuationQuoteStyle punctuationStyle;
    private final DoubleQuoteStyle quoteStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public PunctuationInQuoteFormattingRule() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PunctuationInQuoteFormattingRule(DoubleQuoteStyle quoteStyle, PunctuationQuoteStyle punctuationStyle) {
        Intrinsics.checkNotNullParameter(quoteStyle, "quoteStyle");
        Intrinsics.checkNotNullParameter(punctuationStyle, "punctuationStyle");
        this.quoteStyle = quoteStyle;
        this.punctuationStyle = punctuationStyle;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public boolean applicable(String str) {
        return FormattingRule.DefaultImpls.applicable(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String ruleName() {
        return FormattingRule.DefaultImpls.ruleName(this);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String store(String str) {
        return FormattingRule.DefaultImpls.store(this, str);
    }

    public /* synthetic */ PunctuationInQuoteFormattingRule(DoubleQuoteStyle doubleQuoteStyle, PunctuationQuoteStyle punctuationQuoteStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DoubleQuoteStyle.DEFAULT : doubleQuoteStyle, (i & 2) != 0 ? PunctuationQuoteStyle.DEFAULT : punctuationQuoteStyle);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(String text) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(text, "text");
        String str3 = text;
        int lastIndex = StringsKt.getLastIndex(str3);
        while (true) {
            if (-1 >= lastIndex) {
                str = text;
                break;
            }
            char charAt = text.charAt(lastIndex);
            if (!(charAt == this.quoteStyle.end().charAt(0) || RuleUtils.INSTANCE.isPunctuation(charAt))) {
                str = text.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                break;
            }
            lastIndex--;
        }
        String str4 = str;
        if (!StringsKt.contains$default((CharSequence) str4, (CharSequence) this.quoteStyle.end(), false, 2, (Object) null)) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int length = str4.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str4.charAt(i);
            if (RuleUtils.INSTANCE.isPunctuation(charAt2)) {
                sb.append(charAt2);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = str3.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                char charAt3 = str3.charAt(length2);
                if (!(charAt3 == this.quoteStyle.end().charAt(0) || RuleUtils.INSTANCE.isPunctuation(charAt3))) {
                    str2 = str3.subSequence(0, length2 + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        String obj = str2.toString();
        if (this.punctuationStyle.isInsideQuote(sb2)) {
            return obj + sb2 + this.quoteStyle.end();
        }
        return obj + this.quoteStyle.end() + sb2;
    }
}
