package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiableAdvance;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleRestoreSplittable;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: AllUppercaseWithWhitespacesRule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/AllUppercaseWithWhitespacesRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiableAdvance;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleRestoreSplittable;", "()V", "advanceApply", JsonProperty.USE_DEFAULT_NAME, "text", "advanceRestore", "Lkotlin/sequences/Sequence;", "locale", "Ljava/util/Locale;", "isApplicable", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AllUppercaseWithWhitespacesRule implements RecaseRuleLowerCasifiableAdvance, RecaseRuleRestoreSplittable {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiableAdvance, com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable, com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String apply(String str, Locale locale) {
        return RecaseRuleLowerCasifiableAdvance.DefaultImpls.apply(this, str, locale);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public Locale getLocale(String str) {
        return RecaseRuleLowerCasifiableAdvance.DefaultImpls.getLocale(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String restore(String str, Locale locale) {
        return RecaseRuleRestoreSplittable.DefaultImpls.restore(this, str, locale);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public boolean isApplicable(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        char[] charArray = text.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        Pattern compile = Pattern.compile("\\p{Punct}");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Pattern compile2 = Pattern.compile("\\p{Z}");
        Intrinsics.checkNotNullExpressionValue(compile2, "compile(...)");
        int length = charArray.length - 1;
        int i = 0;
        while (i < length) {
            boolean isLetter = Character.isLetter(charArray[i]);
            boolean isUpperCase = Character.isUpperCase(charArray[i]);
            boolean matches = compile.matcher(String.valueOf(charArray[i])).matches();
            boolean matches2 = compile2.matcher(String.valueOf(charArray[i])).matches();
            i++;
            boolean z = (isLetter && isUpperCase && (compile2.matcher(String.valueOf(charArray[i])).matches() || compile.matcher(String.valueOf(charArray[i])).matches())) ? false : true;
            boolean z2 = (((isLetter && isUpperCase) || matches2) && (matches2 || matches)) ? false : true;
            if (!z || !z2) {
                if (matches) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiableAdvance
    public String advanceApply(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new Regex("�").replace(new Regex("\\s").replace(new Regex("\\s\\s+").replace(text, "�"), JsonProperty.USE_DEFAULT_NAME), " ");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleRestoreSplittable
    public String advanceRestore(Sequence<String> text, Locale locale) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return SequencesKt.joinToString$default(SequencesKt.map(text, new Function1<String, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseWithWhitespacesRule$advanceRestore$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String word) {
                Intrinsics.checkNotNullParameter(word, "word");
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = word.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return StringsKt.trim((CharSequence) StringsKt.replace$default(upperCase, JsonProperty.USE_DEFAULT_NAME, " ", false, 4, (Object) null)).toString();
            }
        }), "  ", null, null, 0, null, null, 62, null);
    }
}
