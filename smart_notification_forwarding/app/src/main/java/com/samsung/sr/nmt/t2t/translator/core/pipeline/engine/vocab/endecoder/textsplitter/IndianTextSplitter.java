package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: IndianTextSplitter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/IndianTextSplitter;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;", "()V", "split", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "sentence", "prependDirectionString", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IndianTextSplitter implements TextSplitter {
    private static final Regex symbolRegex = new Regex("[!\"#$%&'()*+, \\-./:;<=>?@\\[\\\\\\]^_`{|}~\\u0964\\u0965]");
    private static final Regex dateRegex = new Regex("([0-9]+ [,.:/] )+[0-9]+");
    private static final Regex tabRegex = new Regex("\t");
    private static final Regex multiSpaceRegex = new Regex("\\s+");

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitter
    public List<String> split(String sentence, String prependDirectionString) {
        Intrinsics.checkNotNullParameter(sentence, "sentence");
        Intrinsics.checkNotNullParameter(prependDirectionString, "prependDirectionString");
        String obj = StringsKt.trim((CharSequence) multiSpaceRegex.replace(symbolRegex.replace(tabRegex.replace(sentence, " "), " $0 "), " ")).toString();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (prependDirectionString.length() > 0) {
            sb.append(prependDirectionString + " ");
        }
        for (MatchResult matchResult : Regex.findAll$default(dateRegex, obj, 0, 2, null)) {
            int first = matchResult.getRange().getFirst();
            int last = matchResult.getRange().getLast() + 1;
            if (first > i) {
                sb.append(obj.subSequence(i, first));
                sb.append(multiSpaceRegex.replace(obj.subSequence(first, last), JsonProperty.USE_DEFAULT_NAME));
                i = last;
            }
        }
        sb.append(obj.subSequence(i, obj.length()));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return StringsKt.split$default((CharSequence) sb2, new String[]{" "}, false, 0, 6, (Object) null);
    }
}
