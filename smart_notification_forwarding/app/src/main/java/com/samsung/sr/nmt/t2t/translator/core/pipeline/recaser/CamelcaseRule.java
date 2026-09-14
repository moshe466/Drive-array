package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CamelcaseRule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/CamelcaseRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiable;", "()V", "isApplicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "isNotApplicableChars", "first", JsonProperty.USE_DEFAULT_NAME, "second", "restore", "locale", "Ljava/util/Locale;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CamelcaseRule implements RecaseRuleLowerCasifiable {
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
        int length = charArray.length - 1;
        int i = 0;
        while (i < length) {
            char c = charArray[i];
            i++;
            if (isNotApplicableChars(c, charArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String restore(String text, Locale locale) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(locale, "locale");
        char[] charArray = text.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        return new String(charArray);
    }

    private final boolean isNotApplicableChars(char first, char second) {
        boolean matches = Pattern.matches("\\p{Punct}", String.valueOf(first));
        boolean matches2 = Pattern.matches("\\p{Z}", String.valueOf(first));
        boolean matches3 = Pattern.matches("\\p{Punct}", String.valueOf(second));
        boolean matches4 = Pattern.matches("\\p{Z}", String.valueOf(second));
        return ((Character.isUpperCase(first) && (Character.isLowerCase(second) || matches4 || matches3)) || (Character.isLowerCase(first) && (Character.isUpperCase(second) || matches4 || matches3)) || (matches || matches2)) ? false : true;
    }
}
