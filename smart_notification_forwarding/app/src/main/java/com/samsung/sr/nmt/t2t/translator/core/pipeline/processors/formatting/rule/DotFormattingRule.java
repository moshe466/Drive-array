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

/* compiled from: DotFormattingRule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DotFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "()V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core", "punctuationAndQuote", "hasQuestionMark", "hasMoreThanOnePunctuationChar"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DotFormattingRule implements FormattingRule {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String ruleName() {
        return FormattingRule.DefaultImpls.ruleName(this);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String store(String str) {
        return FormattingRule.DefaultImpls.store(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(String text) {
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        final String obj = StringsKt.trimEnd((CharSequence) text).toString();
        String str2 = obj;
        boolean z = StringsKt.last(str2) == '.';
        final Lazy lazy = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DotFormattingRule$restore$punctuationAndQuote$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3 = obj;
                for (int lastIndex = StringsKt.getLastIndex(str3); -1 < lastIndex; lastIndex--) {
                    char charAt = str3.charAt(lastIndex);
                    if (!(charAt == '\"' || charAt == '\'' || RuleUtils.INSTANCE.isPunctuation(charAt))) {
                        String substring = str3.substring(lastIndex + 1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                }
                return str3;
            }
        });
        Lazy lazy2 = LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DotFormattingRule$restore$hasQuestionMark$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String restore$lambda$2;
                restore$lambda$2 = DotFormattingRule.restore$lambda$2(lazy);
                return Boolean.valueOf(StringsKt.contains$default((CharSequence) restore$lambda$2, RuleUtils.QUESTION_MARK, false, 2, (Object) null));
            }
        });
        Lazy lazy3 = LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DotFormattingRule$restore$hasMoreThanOnePunctuationChar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String restore$lambda$2;
                restore$lambda$2 = DotFormattingRule.restore$lambda$2(lazy);
                String str3 = restore$lambda$2;
                StringBuilder sb = new StringBuilder();
                int length = str3.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str3.charAt(i);
                    if (RuleUtils.INSTANCE.isPunctuation(charAt)) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
                return Boolean.valueOf(sb2.length() > 1);
            }
        });
        if (z || restore$lambda$3(lazy2) || restore$lambda$4(lazy3)) {
            return obj;
        }
        String restore$lambda$2 = restore$lambda$2(lazy);
        StringBuilder sb = new StringBuilder();
        int length = restore$lambda$2.length();
        for (int i = 0; i < length; i++) {
            char charAt = restore$lambda$2.charAt(i);
            if (!RuleUtils.INSTANCE.isPunctuation(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = str2.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                char charAt2 = str2.charAt(length2);
                if (!(charAt2 == '\"' || charAt2 == '\'' || RuleUtils.INSTANCE.isPunctuation(charAt2))) {
                    str = str2.subSequence(0, length2 + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        return str.toString() + sb2 + ".";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String restore$lambda$2(Lazy<String> lazy) {
        return lazy.getValue();
    }

    private static final boolean restore$lambda$3(Lazy<Boolean> lazy) {
        return lazy.getValue().booleanValue();
    }

    private static final boolean restore$lambda$4(Lazy<Boolean> lazy) {
        return lazy.getValue().booleanValue();
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
            if (!(charAt == '\"' || charAt == '\'' || RuleUtils.INSTANCE.isPunctuation(charAt))) {
                text = text.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String).substring(startIndex)");
                break;
            }
            lastIndex--;
        }
        String str = text;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (RuleUtils.INSTANCE.isPunctuation(charAt2)) {
                sb.append(charAt2);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2.length() == 1 && sb2.charAt(0) == '.';
    }
}
