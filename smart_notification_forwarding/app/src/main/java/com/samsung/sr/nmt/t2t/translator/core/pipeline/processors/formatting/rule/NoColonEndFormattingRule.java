package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NoColonEndFormattingRule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/NoColonEndFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "()V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NoColonEndFormattingRule implements FormattingRule {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String ruleName() {
        return FormattingRule.DefaultImpls.ruleName(this);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String store(String str) {
        return FormattingRule.DefaultImpls.store(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public boolean applicable(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int lastIndex = StringsKt.getLastIndex(text);
        while (true) {
            if (-1 >= lastIndex) {
                break;
            }
            char charAt = text.charAt(lastIndex);
            if (!(charAt == ':' || charAt == '\"' || charAt == '\'')) {
                text = text.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String).substring(startIndex)");
                break;
            }
            lastIndex--;
        }
        return !StringsKt.contains$default((CharSequence) text, RuleUtils.COLON, false, 2, (Object) null);
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
            if (!(charAt == ':' || charAt == '\"' || charAt == '\'')) {
                str = text.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                break;
            }
            lastIndex--;
        }
        String str4 = str;
        if (!StringsKt.contains$default((CharSequence) str4, RuleUtils.COLON, false, 2, (Object) null)) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int length = str4.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str4.charAt(i);
            if (charAt2 != ':') {
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
                if (!(charAt3 == ':' || charAt3 == '\"' || charAt3 == '\'')) {
                    str2 = str3.subSequence(0, length2 + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        return str2.toString() + sb2;
    }
}
