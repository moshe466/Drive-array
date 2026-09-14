package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecaseRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", JsonProperty.USE_DEFAULT_NAME, "apply", JsonProperty.USE_DEFAULT_NAME, "text", "locale", "Ljava/util/Locale;", "getLocale", "lang", "isApplicable", JsonProperty.USE_DEFAULT_NAME, "restore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface RecaseRule {
    String apply(String text, Locale locale);

    Locale getLocale(String lang);

    boolean isApplicable(String text);

    String restore(String text, Locale locale);

    /* compiled from: RecaseRule.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Locale getLocale(RecaseRule recaseRule, String lang) {
            Intrinsics.checkNotNullParameter(lang, "lang");
            Locale forLanguageTag = Locale.forLanguageTag(lang);
            Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(...)");
            return forLanguageTag;
        }
    }
}
