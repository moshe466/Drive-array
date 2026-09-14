package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* compiled from: ThaiSentenceSplitRule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u0019\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0014\u0010\u000e\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0014\u0010\u0011\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0014\u0010\u0012\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0014\u0010\u0013\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000bH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/ThaiSentenceSplitRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "()V", "delimiter", JsonProperty.USE_DEFAULT_NAME, "getDelimiter", "()Ljava/lang/String;", "split", JsonProperty.USE_DEFAULT_NAME, "input", "isDoubleSpace", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "index", "isEndOfSentence", "currentIdx", "isNextCharMarked", "thaiEOSRule13", "thaiEOSRule2", "thaiEOSRule4", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ThaiSentenceSplitRule implements SplitRule {
    private static final int RULE13_LENGTH = 4;
    private static final int RULE2_LENGTH = 5;
    private static final int RULE4_LENGTH = 3;

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public String getDelimiter() {
        return " ";
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule
    public List<String> split(String input) {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(input, "input");
        ArrayList arrayList = new ArrayList();
        char[] charArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            int isEndOfSentence = isEndOfSentence(charArray, i);
            if (isEndOfSentence == 0) {
                sb2.append(charArray[i]);
                i++;
            } else {
                int i2 = isEndOfSentence + i;
                Iterator<T> it = ArraysKt.slice(charArray, new IntRange(i, i2 - 1)).iterator();
                while (it.hasNext()) {
                    sb2.append(((Character) it.next()).charValue());
                }
                sb = sb2.length() > 0 ? sb2 : null;
                if (sb != null) {
                    String sb3 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                    arrayList.add(StringsKt.trimStart((CharSequence) sb3).toString());
                    StringsKt.clear(sb2);
                    i = i2;
                }
            }
        }
        sb = sb2.length() > 0 ? sb2 : null;
        if (sb != null) {
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
            arrayList.add(StringsKt.trimStart((CharSequence) sb4).toString());
            StringsKt.clear(sb2);
        }
        return arrayList;
    }

    private final int isEndOfSentence(char[] cArr, int i) {
        char c = cArr[i];
        if (c == ' ') {
            return isDoubleSpace(cArr, i);
        }
        boolean z = true;
        if (c == '\n' || c == '\r') {
            return 1;
        }
        if (c != '?' && c != '!') {
            z = false;
        }
        if (z) {
            return isNextCharMarked(cArr, i);
        }
        if (c == 3588) {
            return Math.max(thaiEOSRule13(cArr, i), Math.max(thaiEOSRule2(cArr, i), thaiEOSRule4(cArr, i)));
        }
        if (c == 3621) {
            return thaiEOSRule13(cArr, i);
        }
        return 0;
    }

    private final int isDoubleSpace(char[] cArr, int i) {
        int i2 = i + 1;
        return (cArr.length <= i2 || cArr[i2] != ' ') ? 0 : 2;
    }

    private final int isNextCharMarked(char[] cArr, int i) {
        int i2 = i + 1;
        return (cArr.length <= i2 || cArr[i2] != '\"') ? 1 : 2;
    }

    private final int thaiEOSRule13(char[] cArr, int i) {
        int i2 = i + 4;
        return (cArr.length <= i2 || !Intrinsics.areEqual(StringsKt.concatToString(cArr, i + 1, i2), "่ะ ")) ? 0 : 4;
    }

    private final int thaiEOSRule2(char[] cArr, int i) {
        int i2 = i + 5;
        return (cArr.length <= i2 || !Intrinsics.areEqual(StringsKt.concatToString(cArr, i, i2), "ครับ ")) ? 0 : 5;
    }

    private final int thaiEOSRule4(char[] cArr, int i) {
        int i2 = i + 3;
        return (cArr.length <= i2 || !Intrinsics.areEqual(StringsKt.concatToString(cArr, i, i2), "คะ ")) ? 0 : 3;
    }
}
