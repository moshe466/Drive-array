package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: RecaseRuleRestoreSplittable.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleRestoreSplittable;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", "advanceRestore", JsonProperty.USE_DEFAULT_NAME, "text", "Lkotlin/sequences/Sequence;", "locale", "Ljava/util/Locale;", "restore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface RecaseRuleRestoreSplittable extends RecaseRule {
    String advanceRestore(Sequence<String> text, Locale locale);

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    String restore(String text, Locale locale);

    /* compiled from: RecaseRuleRestoreSplittable.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Locale getLocale(RecaseRuleRestoreSplittable recaseRuleRestoreSplittable, String lang) {
            Intrinsics.checkNotNullParameter(lang, "lang");
            return RecaseRule.DefaultImpls.getLocale(recaseRuleRestoreSplittable, lang);
        }

        public static String restore(RecaseRuleRestoreSplittable recaseRuleRestoreSplittable, String text, Locale locale) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(locale, "locale");
            return recaseRuleRestoreSplittable.advanceRestore(SequencesKt.filter(CollectionsKt.asSequence(StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) text).toString(), new String[]{"\\s"}, false, 0, 6, (Object) null)), new Function1<String, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleRestoreSplittable$restore$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String word) {
                    Intrinsics.checkNotNullParameter(word, "word");
                    return Boolean.valueOf(word.length() > 0);
                }
            }), locale);
        }
    }
}
