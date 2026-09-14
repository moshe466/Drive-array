package com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleRestoreSplittable;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: FirstLetterUppercaseRule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/FirstLetterUppercaseRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleLowerCasifiable;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRuleRestoreSplittable;", "()V", "advanceRestore", JsonProperty.USE_DEFAULT_NAME, "text", "Lkotlin/sequences/Sequence;", "locale", "Ljava/util/Locale;", "isApplicable", JsonProperty.USE_DEFAULT_NAME, "isNotApplicableChars", "first", JsonProperty.USE_DEFAULT_NAME, "second", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FirstLetterUppercaseRule implements RecaseRuleLowerCasifiable, RecaseRuleRestoreSplittable {
    private static final Pattern punctuationPattern = Pattern.compile("\\p{Punct}");
    private static final Pattern separatorPattern;

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleLowerCasifiable, com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String apply(String str, Locale locale) {
        return RecaseRuleLowerCasifiable.DefaultImpls.apply(this, str, locale);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public Locale getLocale(String str) {
        return RecaseRuleLowerCasifiable.DefaultImpls.getLocale(this, str);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule
    public String restore(String str, Locale locale) {
        return RecaseRuleRestoreSplittable.DefaultImpls.restore(this, str, locale);
    }

    static {
        Pattern compile = Pattern.compile("\\p{Z}");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        separatorPattern = compile;
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

    private final boolean isNotApplicableChars(char first, char second) {
        boolean isLowerCase = Character.isLowerCase(first);
        boolean isUpperCase = Character.isUpperCase(first);
        boolean isLowerCase2 = Character.isLowerCase(second);
        boolean isUpperCase2 = Character.isUpperCase(second);
        Pattern pattern = punctuationPattern;
        boolean matches = pattern.matcher(String.valueOf(first)).matches();
        Pattern pattern2 = separatorPattern;
        boolean matches2 = pattern2.matcher(String.valueOf(first)).matches();
        boolean z = pattern.matcher(String.valueOf(second)).matches() || pattern2.matcher(String.valueOf(second)).matches();
        return (!(!(isUpperCase && (isLowerCase2 || z)) && !(isLowerCase && (isLowerCase2 || z))) || (matches2 && (isUpperCase2 || z)) || matches) ? false : true;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRuleRestoreSplittable
    public String advanceRestore(Sequence<String> text, final Locale locale) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return SequencesKt.joinToString$default(SequencesKt.map(text, new Function1<String, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.FirstLetterUppercaseRule$advanceRestore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String word) {
                Intrinsics.checkNotNullParameter(word, "word");
                String substring = word.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String upperCase = substring.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                String substring2 = word.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                return upperCase + substring2;
            }
        }), " ", null, null, 0, null, null, 62, null);
    }
}
