package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: PlhHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0012\u001a\u00020\u0005J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PlhHandler;", JsonProperty.USE_DEFAULT_NAME, "plhTok", JsonProperty.USE_DEFAULT_NAME, "numPlhTok", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "plhReg", "Lkotlin/text/Regex;", "plhTokPrefix", "plhTokSuffix", "findPlhTokensInText", JsonProperty.USE_DEFAULT_NAME, "Lkotlin/text/MatchResult;", "text", "getNumberInPlhToken", "tok", "samplePlhTokens", "n", "splitTextByPlh", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlhHandler {
    private final int numPlhTok;
    private final Regex plhReg;
    private final String plhTok;
    private final String plhTokPrefix;
    private final String plhTokSuffix;

    public PlhHandler(String plhTok, int i) {
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        this.plhTok = plhTok;
        this.numPlhTok = i;
        this.plhReg = new Regex(StringsKt.replace$default(plhTok, "?", "[0-9]+", false, 4, (Object) null));
        this.plhTokPrefix = (String) StringsKt.split$default((CharSequence) plhTok, new String[]{"?"}, false, 0, 6, (Object) null).get(0);
        this.plhTokSuffix = (String) StringsKt.split$default((CharSequence) plhTok, new String[]{"?"}, false, 0, 6, (Object) null).get(1);
        String str = plhTok;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '?') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        if (!(sb2.length() == 1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final List<String> samplePlhTokens(int n) {
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.take(CollectionsKt.shuffled(RangesKt.until(0, this.numPlhTok)), n).iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.replace$default(this.plhTok, "?", String.valueOf(((Number) it.next()).intValue()), false, 4, (Object) null));
        }
        return arrayList;
    }

    public final int getNumberInPlhToken(String tok) {
        Intrinsics.checkNotNullParameter(tok, "tok");
        return Integer.parseInt(StringsKt.removeSuffix(StringsKt.removePrefix(tok, (CharSequence) this.plhTokPrefix), (CharSequence) this.plhTokSuffix));
    }

    public final List<MatchResult> findPlhTokensInText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return SequencesKt.toList(Regex.findAll$default(this.plhReg, text, 0, 2, null));
    }

    public final List<String> splitTextByPlh(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        List<MatchResult> findPlhTokensInText = findPlhTokensInText(text);
        int i = 0;
        List<String> split = this.plhReg.split(text, 0);
        if (findPlhTokensInText.isEmpty() || findPlhTokensInText.size() != split.size() - 1) {
            return CollectionsKt.listOf(text);
        }
        List mutableListOf = CollectionsKt.mutableListOf(split.get(0));
        int size = findPlhTokensInText.size();
        while (i < size) {
            mutableListOf.add(findPlhTokensInText.get(i).getValue());
            i++;
            mutableListOf.add(split.get(i));
        }
        return CollectionsKt.toList(mutableListOf);
    }
}
