package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTextSplitter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\n\u0010\b\u001a\u00020\t*\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/DefaultTextSplitter;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;", "()V", "split", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "sentence", "prependDirectionString", "toInt", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DefaultTextSplitter implements TextSplitter {
    public final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitter
    public List<String> split(String sentence, String prependDirectionString) {
        Intrinsics.checkNotNullParameter(sentence, "sentence");
        Intrinsics.checkNotNullParameter(prependDirectionString, "prependDirectionString");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (prependDirectionString.length() > 0) {
            sb.append(prependDirectionString + " ");
        }
        String str = sentence;
        int i = -1;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            int i3 = toInt(Character.isLetterOrDigit(charAt));
            if (i3 != i) {
                if (sb.length() > 0) {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                    arrayList.add(sb2);
                }
                sb.setLength(0);
            }
            sb.append(charAt);
            i2++;
            i = i3;
        }
        if (sb.length() > 0) {
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            arrayList.add(sb3);
        }
        return arrayList;
    }
}
