package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AllUppercaseRule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/AllUppercaseRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiable;", "()V", "isApplicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "locale", "Ljava/util/Locale;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AllUppercaseRule implements RecaseRuleLowerCasifiable {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable, com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String apply(String str, Locale locale) {
        return RecaseRuleLowerCasifiable.DefaultImpls.apply(this, str, locale);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public Locale getLocale(String str) {
        return RecaseRuleLowerCasifiable.DefaultImpls.getLocale(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public boolean isApplicable(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        char[] charArray = text.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        for (char c : charArray) {
            if (Character.isLetter(c) && Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String restore(String text, Locale locale) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = text.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
