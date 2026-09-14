package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharCategory;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: EUSentenceSplitRule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/EUSentenceSplitRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "abbreviations", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/Set;)V", "delimiter", "getDelimiter", "()Ljava/lang/String;", "addMissingSpace", "input", "isAbbreviation", JsonProperty.USE_DEFAULT_NAME, "lastWord", "split", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EUSentenceSplitRule implements SplitRule {
    private static final String CHAR_BASED_UNICODE = "\\u3040-\\u30ff\\u4e00-\\u9fff\\u0100-\\u024F\\u1e00-\\u1eff\\u0590-\\u05ff\\u0600-\\u06ff\\uac00-\\ud7a3¿";
    public static final int PRIMARY_ADDITIONAL_PUNCTUATION_GROUP = 3;
    private static final Pattern REGEX_LAST_WORD;
    private static final Pattern REGEX_MISSING_SPACE;
    private static final Pattern REGEX_SINGLE_LETTER;
    private static final Pattern REGEX_SINGLE_LETTERS_PERIODS;
    private static final Pattern REGEX_SINGLE_SENTENCE;
    public static final int SECONDARY_ADDITIONAL_PUNCTUATION_GROUP = 5;
    private final Set<String> abbreviations;
    private final String delimiter;

    public EUSentenceSplitRule(Set<String> abbreviations) {
        Intrinsics.checkNotNullParameter(abbreviations, "abbreviations");
        this.abbreviations = abbreviations;
        this.delimiter = " ";
    }

    static {
        Pattern compile = Pattern.compile("(.)([.!?。\\u061f])([\\D&&\\S&&[^.\"”»'`)}\\]!]])", 0);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(this, flags)");
        REGEX_MISSING_SPACE = compile;
        Pattern compile2 = Pattern.compile("(['\"“«\\[\\<`]*[\\(\\{\\[]?[a-zA-Z0-9\\u0400-\\u04FF\\u3040-\\u30ff\\u4e00-\\u9fff\\u0100-\\u024F\\u1e00-\\u1eff\\u0590-\\u05ff\\u0600-\\u06ff\\uac00-\\ud7a3¿]+.*?)([\\u061f。\\.!?:])(?:(?=([\\(\\[\\{\"“”«»'`\\)\\}\\]<]*[ ]+)[\\(\\[\\{\"“”«»'`\\)\\}\\]]*([A-Z0-9\\u0400-\\u042F\\u3040-\\u30ff\\u4e00-\\u9fff\\u0100-\\u024F\\u1e00-\\u1eff\\u0590-\\u05ff\\u0600-\\u06ff\\uac00-\\ud7a3¿][a-z\\u0430-\\u045F\\u3040-\\u30ff\\u4e00-\\u9fff\\u0100-\\u024F\\u1e00-\\u1eff\\u0590-\\u05ff\\u0600-\\u06ff\\uac00-\\ud7a3¿]*))|(?=([\\(\\)\"“”«»—'`\\)\\}<\\] ]+)\\s))", 0);
        Intrinsics.checkNotNullExpressionValue(compile2, "compile(this, flags)");
        REGEX_SINGLE_SENTENCE = compile2;
        Pattern compile3 = Pattern.compile("\\b([\\w0-9\\u0400-\\u045F.']+)$", 0);
        Intrinsics.checkNotNullExpressionValue(compile3, "compile(this, flags)");
        REGEX_LAST_WORD = compile3;
        Pattern compile4 = Pattern.compile("([a-zA-Z\\u0400-\\u04FF][\\.])+", 0);
        Intrinsics.checkNotNullExpressionValue(compile4, "compile(this, flags)");
        REGEX_SINGLE_LETTERS_PERIODS = compile4;
        Pattern compile5 = Pattern.compile("^[A-Za-z\\\\u0400-\\\\u04FF]$", 0);
        Intrinsics.checkNotNullExpressionValue(compile5, "compile(this, flags)");
        REGEX_SINGLE_LETTER = compile5;
    }

    private final boolean isAbbreviation(String lastWord) {
        String str = lastWord;
        return new Regex(REGEX_SINGLE_LETTERS_PERIODS).matches(str) || new Regex(REGEX_SINGLE_LETTER).matches(str) || this.abbreviations.contains(lastWord);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        if (r6.equals("!") == false) goto L49;
     */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.String> split(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.EUSentenceSplitRule.split(java.lang.String):java.util.List");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public String getDelimiter() {
        return this.delimiter;
    }

    private final String addMissingSpace(String input) {
        Matcher matcher = REGEX_MISSING_SPACE.matcher(input);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            if (!this.abbreviations.contains(matcher.group(0))) {
                Intrinsics.checkNotNull(group3);
                String str = group3;
                if (Character.isUpperCase(StringsKt.first(str)) || CharsKt.getCategory(StringsKt.first(str)) == CharCategory.OTHER_LETTER) {
                    String substring = input.substring(i, matcher.start());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append(group + group2 + " " + group3);
                    i = matcher.end();
                }
            }
        }
        if (i < input.length()) {
            String substring2 = input.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
