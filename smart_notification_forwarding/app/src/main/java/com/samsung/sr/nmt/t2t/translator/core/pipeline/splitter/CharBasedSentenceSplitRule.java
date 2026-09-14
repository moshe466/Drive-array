package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: CharBasedSentenceSplitRule.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\b\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001e\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00060\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0014\u0010\u0019\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u001c\u0010\u001b\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\fH\u0002J\f\u0010\u001c\u001a\u00020\u0003*\u00020\u001dH\u0002J\f\u0010\u001e\u001a\u00020\u0003*\u00020\u001dH\u0002J\u0014\u0010\u001f\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0014\u0010 \u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0014\u0010!\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0014\u0010\"\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\f\u0010#\u001a\u00020\u0003*\u00020\u001dH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/CharBasedSentenceSplitRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "shortest", JsonProperty.USE_DEFAULT_NAME, "abbreviations", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(ZLjava/util/Set;)V", "delimiter", "getDelimiter", "()Ljava/lang/String;", "lastProcessedIndex", JsonProperty.USE_DEFAULT_NAME, "split", JsonProperty.USE_DEFAULT_NAME, "input", "insertBuilder", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isAbbreviationExisted", JsonProperty.USE_DEFAULT_NAME, "currentIdx", "isContinuousDigitsWithClose", "closeIdx", "isEndOfSentence", "isLeftBracket", JsonProperty.USE_DEFAULT_NAME, "isMarked", "isMeaningLessPendingSpaces", "isNextCharBlank", "isNextCharMarked", "isNextCharNotAsciiOrLeftBracket", "isNotAscii", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CharBasedSentenceSplitRule implements SplitRule {
    public static final int MAX_ASCII = 128;
    private final Set<String> abbreviations;
    private final String delimiter;
    private int lastProcessedIndex;
    private final boolean shortest;

    private final boolean isLeftBracket(char c) {
        return c == '(' || c == '{' || c == '[' || c == 12298;
    }

    private final boolean isMarked(char c) {
        return ((((((((c == '!' || c == 65281) || c == '?') || c == 65311) || c == 12301) || c == 8221) || c == 12290) || c == 12299) || c == '\"') || c == 2404;
    }

    private final boolean isNotAscii(char c) {
        return c > 128;
    }

    public CharBasedSentenceSplitRule(boolean z, Set<String> abbreviations) {
        Intrinsics.checkNotNullParameter(abbreviations, "abbreviations");
        this.shortest = z;
        this.abbreviations = abbreviations;
        this.delimiter = " ";
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public List<String> split(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ArrayList arrayList = new ArrayList();
        char[] charArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        this.lastProcessedIndex = 0;
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (!(sb.length() == 0) || !CharsKt.isWhitespace(charArray[i])) {
                sb.append(charArray[i]);
                if (isEndOfSentence(charArray, this.shortest, i)) {
                    insertBuilder(arrayList, sb);
                    Unit unit = Unit.INSTANCE;
                    StringsKt.clear(sb);
                    this.lastProcessedIndex = i + 1;
                }
            }
        }
        insertBuilder(arrayList, sb);
        Unit unit2 = Unit.INSTANCE;
        StringsKt.clear(sb);
        return arrayList;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public String getDelimiter() {
        return this.delimiter;
    }

    private final boolean isEndOfSentence(char[] cArr, boolean z, int i) {
        char c = cArr[i];
        if (c != '.') {
            if (!(((c == 65292 || c == ',') || c == ';') || c == 65307)) {
                if ((((((((c == '!' || c == 65281) || c == '?') || c == 65311) || c == 8230) || c == 12301) || c == 8221) || c == 12290) || c == 2404) {
                    if (isNextCharMarked(cArr, i)) {
                        return false;
                    }
                } else {
                    if (c == '\"') {
                        return isNextCharBlank(cArr, i);
                    }
                    if (!(((c == 1567 || c == 9674) || c == '\n') || c == '\r')) {
                        return false;
                    }
                }
            } else if (!z || isNextCharMarked(cArr, i)) {
                return false;
            }
        } else {
            if (isAbbreviationExisted(cArr, i)) {
                return false;
            }
            if ((!isNextCharBlank(cArr, i) || isContinuousDigitsWithClose(cArr, i) || isMeaningLessPendingSpaces(cArr, i)) && (!isNextCharNotAsciiOrLeftBracket(cArr, i) || isNextCharMarked(cArr, i))) {
                return false;
            }
        }
        return true;
    }

    private final boolean isContinuousDigitsWithClose(char[] cArr, int i) {
        int i2;
        int i3 = i - 1;
        return i3 >= 0 && Character.isDigit(cArr[i3]) && (i2 = i + 2) < cArr.length && Character.isDigit(cArr[i2]);
    }

    private final boolean isMeaningLessPendingSpaces(char[] cArr, int i) {
        int i2;
        return isNextCharBlank(cArr, i) && (((i2 = i + 2) < cArr.length && isMarked(cArr[i2])) || isNextCharBlank(cArr, i + 1));
    }

    private final boolean isAbbreviationExisted(char[] cArr, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = i - 1; i2 >= this.lastProcessedIndex && Character.isLetterOrDigit(cArr[i2]); i2--) {
            sb.append(cArr[i2]);
        }
        return this.abbreviations.contains(sb.reverse().toString());
    }

    private final boolean isNextCharBlank(char[] cArr, int i) {
        return i < cArr.length - 1 && cArr[i + 1] == ' ';
    }

    private final boolean isNextCharNotAsciiOrLeftBracket(char[] cArr, int i) {
        if (i < cArr.length - 1) {
            int i2 = i + 1;
            if (isNotAscii(cArr[i2]) || isLeftBracket(cArr[i2])) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNextCharMarked(char[] cArr, int i) {
        return i < cArr.length - 1 && isMarked(cArr[i + 1]);
    }

    private final void insertBuilder(List<String> list, StringBuilder sb) {
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        String obj = StringsKt.trim((CharSequence) sb2).toString();
        if (obj.length() > 0) {
            list.add(obj);
        }
    }
}
