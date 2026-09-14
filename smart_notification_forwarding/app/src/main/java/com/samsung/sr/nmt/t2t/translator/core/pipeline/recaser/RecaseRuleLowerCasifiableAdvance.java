package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecaseRuleLowerCasifiableAdvance.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiableAdvance;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiable;", "advanceApply", JsonProperty.USE_DEFAULT_NAME, "text", "apply", "locale", "Ljava/util/Locale;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface RecaseRuleLowerCasifiableAdvance extends RecaseRuleLowerCasifiable {
    String advanceApply(String text);

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable, com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    String apply(String text, Locale locale);

    /* compiled from: RecaseRuleLowerCasifiableAdvance.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Locale getLocale(RecaseRuleLowerCasifiableAdvance recaseRuleLowerCasifiableAdvance, String lang) {
            Intrinsics.checkNotNullParameter(lang, "lang");
            return RecaseRuleLowerCasifiable.DefaultImpls.getLocale(recaseRuleLowerCasifiableAdvance, lang);
        }

        public static String apply(RecaseRuleLowerCasifiableAdvance recaseRuleLowerCasifiableAdvance, String text, Locale locale) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(locale, "locale");
            return recaseRuleLowerCasifiableAdvance.advanceApply(RecaseRuleLowerCasifiable.DefaultImpls.apply(recaseRuleLowerCasifiableAdvance, text, locale));
        }
    }
}
