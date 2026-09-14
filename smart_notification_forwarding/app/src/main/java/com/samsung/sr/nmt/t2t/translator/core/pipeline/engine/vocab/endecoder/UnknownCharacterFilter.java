package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.UtilityKt;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: UnknownCharacterFilter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", JsonProperty.USE_DEFAULT_NAME, "()V", "filterUnknownCharacter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/FilteredResult;", "alphabets", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "sourceText", JsonProperty.USE_DEFAULT_NAME, "getUnknownCharsRatio", JsonProperty.USE_DEFAULT_NAME, "input", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UnknownCharacterFilter {
    private static final Regex punctuationRegex = new Regex("\\p{L}+");
    private static final Regex punctuationRegexForFiltering = new Regex("((\\p{P}|\\p{S}|( ))+)");

    @Inject
    public UnknownCharacterFilter() {
    }

    public final float getUnknownCharsRatio(String input, Set<Character> alphabets) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        String joinToString$default = SequencesKt.joinToString$default(SequencesKt.map(Regex.findAll$default(punctuationRegex, input, 0, 2, null), new Function1<MatchResult, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.UnknownCharacterFilter$getUnknownCharsRatio$onlyCharacters$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getValue();
            }
        }), JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null);
        if (alphabets.isEmpty()) {
            return 0.0f;
        }
        String str = joinToString$default;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!alphabets.contains(Character.valueOf(charAt))) {
                sb.append(charAt);
            }
        }
        Intrinsics.checkNotNullExpressionValue(sb.toString(), "filterTo(StringBuilder(), predicate).toString()");
        return r15.length() / joinToString$default.length();
    }

    public final FilteredResult filterUnknownCharacter(Set<Character> alphabets, String sourceText) {
        boolean z;
        IntRange range;
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Iterator it = Regex.findAll$default(punctuationRegexForFiltering, sourceText, 0, 2, null).iterator();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        MatchResult matchResult = (MatchResult) UtilityKt.nextOrNull(it);
        int i = 0;
        int i2 = 0;
        while (i < sourceText.length()) {
            while (true) {
                z = false;
                while (true) {
                    if (i >= sourceText.length() || alphabets.contains(Character.valueOf(sourceText.charAt(i)))) {
                        break;
                    }
                    int i3 = i + 1;
                    sb.append(sourceText.charAt(i));
                    i2++;
                    while (matchResult != null && matchResult.getRange().getFirst() < i3) {
                        matchResult = (MatchResult) UtilityKt.nextOrNull(it);
                    }
                    StringsKt.clear(sb2);
                    if ((matchResult == null || (range = matchResult.getRange()) == null || range.getFirst() != i3) ? false : true) {
                        sb2.append(StringsKt.substring(sourceText, matchResult.getRange()));
                        i = (matchResult.getRange().getLast() - matchResult.getRange().getFirst()) + 1 + i3;
                        if (matchResult.getGroups().get(2) != null) {
                            z = true;
                        }
                    } else {
                        i = i3;
                    }
                }
            }
            if (sb.length() == 1) {
                sb3.append(sb.toString());
            }
            if ((sb2.length() == 0) && z) {
                sb3.append(" ");
            } else {
                sb3.append(sb2.toString());
            }
            StringsKt.clear(sb2);
            while (i < sourceText.length() && alphabets.contains(Character.valueOf(sourceText.charAt(i)))) {
                sb3.append(sourceText.charAt(i));
                i++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        return new FilteredResult(sb4, i2 / sourceText.length());
    }
}
