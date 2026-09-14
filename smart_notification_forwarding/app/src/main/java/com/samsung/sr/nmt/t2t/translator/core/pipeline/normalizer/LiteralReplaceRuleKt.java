package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiteralReplaceRule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"createLiteralRule", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/LiteralCharReplaceRule;", "literal", JsonProperty.USE_DEFAULT_NAME, "replaceTo", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/LiteralStringReplaceRule;", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LiteralReplaceRuleKt {
    public static final LiteralStringReplaceRule createLiteralRule(String literal, String replaceTo) {
        Intrinsics.checkNotNullParameter(literal, "literal");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        return new LiteralStringReplaceRule(literal, replaceTo);
    }

    public static final LiteralCharReplaceRule createLiteralRule(char c, char c2) {
        return new LiteralCharReplaceRule(c, c2);
    }
}
