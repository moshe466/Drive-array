package com.samsung.sr.nmt.t2t.translator.core.pipeline.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: Trie.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"isWord", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "startIndex", JsonProperty.USE_DEFAULT_NAME, "endIndex", "translator-core"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TrieKt {
    public static final boolean isWord(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(i >= 0 && i2 < str.length())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i == 0 || CharsKt.isWhitespace(str.charAt(i - 1))) {
            return i2 == str.length() - 1 || CharsKt.isWhitespace(str.charAt(i2 + 1));
        }
        return false;
    }
}
