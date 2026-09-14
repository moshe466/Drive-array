package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DoubleQuoteFormattingRule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DoubleQuoteFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "quoteStyle", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DoubleQuoteStyle;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DoubleQuoteStyle;)V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "store", "translator-core", "noEndPunctuation", "lastDoubleQuote", "noInnerDoubleQuote", "noMultiplePunctuationChars"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DoubleQuoteFormattingRule implements FormattingRule {
    private final DoubleQuoteStyle quoteStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public DoubleQuoteFormattingRule() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DoubleQuoteFormattingRule(DoubleQuoteStyle quoteStyle) {
        Intrinsics.checkNotNullParameter(quoteStyle, "quoteStyle");
        this.quoteStyle = quoteStyle;
    }

    public /* synthetic */ DoubleQuoteFormattingRule(DoubleQuoteStyle doubleQuoteStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DoubleQuoteStyle.DEFAULT : doubleQuoteStyle);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String ruleName() {
        return FormattingRule.DefaultImpls.ruleName(this);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public boolean applicable(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        final boolean startsWith$default = StringsKt.startsWith$default((CharSequence) text, '\"', false, 2, (Object) null);
        final Lazy lazy = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteFormattingRule$applicable$noEndPunctuation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str;
                String str2 = text;
                int length = str2.length() - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        if (!RuleUtils.INSTANCE.isPunctuation(str2.charAt(length))) {
                            str = str2.subSequence(0, length + 1);
                            break;
                        }
                        if (i < 0) {
                            break;
                        }
                        length = i;
                    }
                    return str.toString();
                }
                return str.toString();
            }
        });
        final Lazy lazy2 = LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteFormattingRule$applicable$lastDoubleQuote$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String applicable$lambda$0;
                applicable$lambda$0 = DoubleQuoteFormattingRule.applicable$lambda$0(lazy);
                return Boolean.valueOf(StringsKt.endsWith$default((CharSequence) applicable$lambda$0, '\"', false, 2, (Object) null));
            }
        });
        return startsWith$default && applicable$lambda$1(lazy2) && applicable$lambda$2(LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteFormattingRule$applicable$noInnerDoubleQuote$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean applicable$lambda$1;
                String applicable$lambda$0;
                boolean z = false;
                if (startsWith$default) {
                    applicable$lambda$1 = DoubleQuoteFormattingRule.applicable$lambda$1(lazy2);
                    if (applicable$lambda$1) {
                        applicable$lambda$0 = DoubleQuoteFormattingRule.applicable$lambda$0(lazy);
                        String str = applicable$lambda$0;
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            if (i >= str.length()) {
                                break;
                            }
                            if (str.charAt(i) == '\"') {
                                i2++;
                            }
                            i++;
                        }
                        if (i2 == 2) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        })) && applicable$lambda$3(LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteFormattingRule$applicable$noMultiplePunctuationChars$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String str = text;
                int lastIndex = StringsKt.getLastIndex(str);
                while (true) {
                    if (-1 >= lastIndex) {
                        break;
                    }
                    char charAt = str.charAt(lastIndex);
                    if (!(charAt == '\"' || RuleUtils.INSTANCE.isPunctuation(charAt))) {
                        str = str.substring(lastIndex + 1);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                        break;
                    }
                    lastIndex--;
                }
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                int length = str2.length();
                for (int i = 0; i < length; i++) {
                    char charAt2 = str2.charAt(i);
                    if (RuleUtils.INSTANCE.isPunctuation(charAt2)) {
                        sb.append(charAt2);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
                return Boolean.valueOf(Intrinsics.areEqual(sb2, "...") || sb2.length() <= 1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applicable$lambda$0(Lazy<String> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applicable$lambda$1(Lazy<Boolean> lazy) {
        return lazy.getValue().booleanValue();
    }

    private static final boolean applicable$lambda$2(Lazy<Boolean> lazy) {
        return lazy.getValue().booleanValue();
    }

    private static final boolean applicable$lambda$3(Lazy<Boolean> lazy) {
        return lazy.getValue().booleanValue();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(String text) {
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        if (!StringsKt.startsWith$default((CharSequence) text, '\"', false, 2, (Object) null)) {
            text = this.quoteStyle.start() + text;
        } else if ('\"' != this.quoteStyle.start().charAt(0)) {
            text = this.quoteStyle.start() + StringsKt.drop(text, 1);
        }
        String str2 = text;
        int lastIndex = StringsKt.getLastIndex(str2);
        while (true) {
            if (-1 >= lastIndex) {
                break;
            }
            char charAt = text.charAt(lastIndex);
            if (!(charAt == '\"' || RuleUtils.INSTANCE.isPunctuation(charAt))) {
                text = text.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String).substring(startIndex)");
                break;
            }
            lastIndex--;
        }
        String str3 = text;
        StringBuilder sb = new StringBuilder();
        int length = str3.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str3.charAt(i);
            if (charAt2 != '\"') {
                sb.append(charAt2);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = str2.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                char charAt3 = str2.charAt(length2);
                if (!(charAt3 == '\"' || RuleUtils.INSTANCE.isPunctuation(charAt3))) {
                    str = str2.subSequence(0, length2 + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        return str.toString() + sb2 + this.quoteStyle.end();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String store(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String str = text;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }
}
