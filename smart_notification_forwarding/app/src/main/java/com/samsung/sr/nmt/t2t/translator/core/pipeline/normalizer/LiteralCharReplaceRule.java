package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LiteralReplaceRule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\t\u0010\u0015\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/LiteralCharReplaceRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/ReplaceRule;", "from", JsonProperty.USE_DEFAULT_NAME, "to", "(CC)V", "getFrom", "()C", "getTo", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", JsonProperty.USE_DEFAULT_NAME, "hashCode", JsonProperty.USE_DEFAULT_NAME, "replace", JsonProperty.USE_DEFAULT_NAME, "text", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class LiteralCharReplaceRule implements ReplaceRule {
    private final char from;
    private final char to;

    public static /* synthetic */ LiteralCharReplaceRule copy$default(LiteralCharReplaceRule literalCharReplaceRule, char c, char c2, int i, Object obj) {
        if ((i & 1) != 0) {
            c = literalCharReplaceRule.from;
        }
        if ((i & 2) != 0) {
            c2 = literalCharReplaceRule.to;
        }
        return literalCharReplaceRule.copy(c, c2);
    }

    /* renamed from: component1, reason: from getter */
    public final char getFrom() {
        return this.from;
    }

    /* renamed from: component2, reason: from getter */
    public final char getTo() {
        return this.to;
    }

    public final LiteralCharReplaceRule copy(char from, char to) {
        return new LiteralCharReplaceRule(from, to);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiteralCharReplaceRule)) {
            return false;
        }
        LiteralCharReplaceRule literalCharReplaceRule = (LiteralCharReplaceRule) other;
        return this.from == literalCharReplaceRule.from && this.to == literalCharReplaceRule.to;
    }

    public int hashCode() {
        return (Character.hashCode(this.from) * 31) + Character.hashCode(this.to);
    }

    public String toString() {
        return "LiteralCharReplaceRule(from=" + this.from + ", to=" + this.to + ")";
    }

    public LiteralCharReplaceRule(char c, char c2) {
        this.from = c;
        this.to = c2;
    }

    public final char getFrom() {
        return this.from;
    }

    public final char getTo() {
        return this.to;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.ReplaceRule
    public String replace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return StringsKt.replace$default(text, this.from, this.to, false, 4, (Object) null);
    }
}
