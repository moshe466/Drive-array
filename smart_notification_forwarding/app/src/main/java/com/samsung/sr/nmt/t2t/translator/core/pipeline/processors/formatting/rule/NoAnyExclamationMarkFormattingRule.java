package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NoAnyExclamationMarkFormattingRule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/NoAnyExclamationMarkFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "()V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NoAnyExclamationMarkFormattingRule implements FormattingRule {
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
        return !StringsKt.contains$default((CharSequence) text, RuleUtils.EXCLAMATION_MARK, false, 2, (Object) null);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String str = text;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '!')) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }
}
