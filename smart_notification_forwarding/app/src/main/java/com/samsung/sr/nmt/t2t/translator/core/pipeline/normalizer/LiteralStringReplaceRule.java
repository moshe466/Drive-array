package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LiteralReplaceRule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/LiteralStringReplaceRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/ReplaceRule;", "from", JsonProperty.USE_DEFAULT_NAME, "to", "(Ljava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getTo", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", JsonProperty.USE_DEFAULT_NAME, "hashCode", JsonProperty.USE_DEFAULT_NAME, "replace", "text", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class LiteralStringReplaceRule implements ReplaceRule {
    private final String from;
    private final String to;

    public static /* synthetic */ LiteralStringReplaceRule copy$default(LiteralStringReplaceRule literalStringReplaceRule, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = literalStringReplaceRule.from;
        }
        if ((i & 2) != 0) {
            str2 = literalStringReplaceRule.to;
        }
        return literalStringReplaceRule.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    public final LiteralStringReplaceRule copy(String from, String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        return new LiteralStringReplaceRule(from, to);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiteralStringReplaceRule)) {
            return false;
        }
        LiteralStringReplaceRule literalStringReplaceRule = (LiteralStringReplaceRule) other;
        return Intrinsics.areEqual(this.from, literalStringReplaceRule.from) && Intrinsics.areEqual(this.to, literalStringReplaceRule.to);
    }

    public int hashCode() {
        return (this.from.hashCode() * 31) + this.to.hashCode();
    }

    public String toString() {
        return "LiteralStringReplaceRule(from=" + this.from + ", to=" + this.to + ")";
    }

    public LiteralStringReplaceRule(String from, String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.from = from;
        this.to = to;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getTo() {
        return this.to;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.ReplaceRule
    public String replace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return StringsKt.replace$default(text, this.from, this.to, false, 4, (Object) null);
    }
}
