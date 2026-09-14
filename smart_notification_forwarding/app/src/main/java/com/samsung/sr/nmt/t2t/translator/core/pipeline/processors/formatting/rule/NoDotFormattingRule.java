package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NoDotFormattingRule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/NoDotFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "()V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NoDotFormattingRule implements FormattingRule {
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
        Character lastOrNull = StringsKt.lastOrNull(StringsKt.trimEnd((CharSequence) text).toString());
        return lastOrNull == null || lastOrNull.charValue() != '.';
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String restore(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = kotlin.text.StringsKt.getLastIndex(r0)
        Lc:
            r2 = 39
            r3 = 34
            r4 = 46
            r5 = -1
            r6 = 1
            r7 = 0
            if (r5 >= r1) goto L35
            char r8 = r11.charAt(r1)
            if (r8 == r4) goto L24
            if (r8 == r3) goto L24
            if (r8 != r2) goto L22
            goto L24
        L22:
            r8 = r7
            goto L25
        L24:
            r8 = r6
        L25:
            if (r8 != 0) goto L32
            int r1 = r1 + r6
            java.lang.String r1 = r11.substring(r1)
            java.lang.String r8 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            goto L36
        L32:
            int r1 = r1 + (-1)
            goto Lc
        L35:
            r1 = r11
        L36:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8 = 2
            r9 = 0
            boolean r8 = kotlin.text.StringsKt.contains$default(r1, r4, r7, r8, r9)
            if (r8 != 0) goto L41
            return r11
        L41:
            int r11 = r0.length()
            int r11 = r11 + r5
            if (r11 < 0) goto L65
        L48:
            int r5 = r11 + (-1)
            char r8 = r0.charAt(r11)
            if (r8 == r4) goto L57
            if (r8 == r3) goto L57
            if (r8 != r2) goto L55
            goto L57
        L55:
            r8 = r7
            goto L58
        L57:
            r8 = r6
        L58:
            if (r8 != 0) goto L60
            int r11 = r11 + r6
            java.lang.CharSequence r11 = r0.subSequence(r7, r11)
            goto L69
        L60:
            if (r5 >= 0) goto L63
            goto L65
        L63:
            r11 = r5
            goto L48
        L65:
            java.lang.String r11 = ""
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
        L69:
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Appendable r0 = (java.lang.Appendable) r0
            int r2 = r1.length()
            r3 = r7
        L79:
            if (r3 >= r2) goto L8c
            char r5 = r1.charAt(r3)
            if (r5 == r4) goto L83
            r8 = r6
            goto L84
        L83:
            r8 = r7
        L84:
            if (r8 == 0) goto L89
            r0.append(r5)
        L89:
            int r3 = r3 + 1
            goto L79
        L8c:
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "filterTo(StringBuilder(), predicate).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r11 = r1.append(r11)
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.String r11 = r11.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoDotFormattingRule.restore(java.lang.String):java.lang.String");
    }
}
