package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecaseRuleLowerCasifiable.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiable;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", "apply", JsonProperty.USE_DEFAULT_NAME, "text", "locale", "Ljava/util/Locale;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface RecaseRuleLowerCasifiable extends RecaseRule {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    String apply(String text, Locale locale);

    /* compiled from: RecaseRuleLowerCasifiable.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Locale getLocale(RecaseRuleLowerCasifiable recaseRuleLowerCasifiable, String lang) {
            Intrinsics.checkNotNullParameter(lang, "lang");
            return RecaseRule.DefaultImpls.getLocale(recaseRuleLowerCasifiable, lang);
        }

        public static String apply(RecaseRuleLowerCasifiable recaseRuleLowerCasifiable, String text, Locale locale) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(locale, "locale");
            String lowerCase = text.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
    }
}
