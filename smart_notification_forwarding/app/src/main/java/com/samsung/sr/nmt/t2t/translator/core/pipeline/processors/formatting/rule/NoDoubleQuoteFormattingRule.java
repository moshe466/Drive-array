package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NoDoubleQuoteFormattingRule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/NoDoubleQuoteFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "()V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core", "noEndPunctuation", "lastQuote"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NoDoubleQuoteFormattingRule implements FormattingRule {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String ruleName() {
        return FormattingRule.DefaultImpls.ruleName(this);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String store(String str) {
        return FormattingRule.DefaultImpls.store(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public boolean applicable(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String str = text;
        boolean z = StringsKt.startsWith$default((CharSequence) str, '\"', false, 2, (Object) null) || StringsKt.startsWith$default((CharSequence) str, RuleUtils.QUOTE, false, 2, (Object) null);
        final Lazy lazy = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoDoubleQuoteFormattingRule$applicable$noEndPunctuation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str2;
                String str3 = text;
                int length = str3.length() - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        if (!RuleUtils.INSTANCE.isPunctuation(str3.charAt(length))) {
                            str2 = str3.subSequence(0, length + 1);
                            break;
                        }
                        if (i < 0) {
                            break;
                        }
                        length = i;
                    }
                    return str2.toString();
                }
                return str2.toString();
            }
        });
        return (z || applicable$lambda$1(LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoDoubleQuoteFormattingRule$applicable$lastQuote$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String applicable$lambda$0;
                applicable$lambda$0 = NoDoubleQuoteFormattingRule.applicable$lambda$0(lazy);
                return Boolean.valueOf(StringsKt.endsWith$default((CharSequence) applicable$lambda$0, '\"', false, 2, (Object) null));
            }
        }))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applicable$lambda$0(Lazy<String> lazy) {
        return lazy.getValue();
    }

    private static final boolean applicable$lambda$1(Lazy<Boolean> lazy) {
        return lazy.getValue().booleanValue();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(String text) {
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        String str2 = text;
        if (StringsKt.startsWith$default((CharSequence) str2, '\"', false, 2, (Object) null) || StringsKt.startsWith$default((CharSequence) str2, RuleUtils.QUOTE, false, 2, (Object) null)) {
            text = StringsKt.drop(text, 1);
        }
        String str3 = text;
        int lastIndex = StringsKt.getLastIndex(str3);
        while (true) {
            if (-1 >= lastIndex) {
                break;
            }
            char charAt = text.charAt(lastIndex);
            if (!(charAt == '\"' || charAt == '\'' || RuleUtils.INSTANCE.isPunctuation(charAt))) {
                text = text.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String).substring(startIndex)");
                break;
            }
            lastIndex--;
        }
        String str4 = text;
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
                if (!(charAt3 == '\"' || charAt3 == '\'' || RuleUtils.INSTANCE.isPunctuation(charAt3))) {
                    str = str3.subSequence(0, length2 + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
            return str.toString() + sb2;
        }
        return str.toString() + sb2;
    }
}
