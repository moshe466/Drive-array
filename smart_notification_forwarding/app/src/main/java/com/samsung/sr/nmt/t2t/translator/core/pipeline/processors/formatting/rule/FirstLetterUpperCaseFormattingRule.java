package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FirstLetterUpperCaseFormattingRule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FirstLetterUpperCaseFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "()V", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core", "c", JsonProperty.USE_DEFAULT_NAME}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FirstLetterUpperCaseFormattingRule implements FormattingRule {
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
        Character ch;
        Intrinsics.checkNotNullParameter(text, "text");
        String str = text;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                ch = null;
                break;
            }
            char charAt = str.charAt(i);
            if (Character.isLetter(charAt)) {
                ch = Character.valueOf(charAt);
                break;
            }
            i++;
        }
        if (ch != null) {
            return Character.isUpperCase(ch.charValue());
        }
        return false;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String str = text;
        int length = str.length();
        final int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (Character.isLetter(str.charAt(i))) {
                break;
            }
            i++;
        }
        Lazy lazy = LazyKt.lazy(new Function0<Character>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FirstLetterUpperCaseFormattingRule$restore$c$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Character invoke() {
                return Character.valueOf(text.charAt(i));
            }
        });
        if (i == -1 || Character.isUpperCase(restore$lambda$3(lazy))) {
            return text;
        }
        String valueOf = String.valueOf(restore$lambda$3(lazy));
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return StringsKt.replaceRange((CharSequence) str, i, i + 1, (CharSequence) upperCase).toString();
    }

    private static final char restore$lambda$3(Lazy<Character> lazy) {
        return lazy.getValue().charValue();
    }
}
