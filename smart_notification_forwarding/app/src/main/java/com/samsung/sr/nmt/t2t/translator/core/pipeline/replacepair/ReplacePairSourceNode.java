package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: ReplacePairSourceNode.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairSourceNode;", JsonProperty.USE_DEFAULT_NAME, "isAllowedAsSubstring", JsonProperty.USE_DEFAULT_NAME, "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ReplacePairSourceNode {
    private final boolean isAllowedAsSubstring;

    public static /* synthetic */ ReplacePairSourceNode copy$default(ReplacePairSourceNode replacePairSourceNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = replacePairSourceNode.isAllowedAsSubstring;
        }
        return replacePairSourceNode.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }

    public final ReplacePairSourceNode copy(boolean isAllowedAsSubstring) {
        return new ReplacePairSourceNode(isAllowedAsSubstring);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReplacePairSourceNode) && this.isAllowedAsSubstring == ((ReplacePairSourceNode) other).isAllowedAsSubstring;
    }

    public int hashCode() {
        boolean z = this.isAllowedAsSubstring;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "ReplacePairSourceNode(isAllowedAsSubstring=" + this.isAllowedAsSubstring + ")";
    }

    public ReplacePairSourceNode(boolean z) {
        this.isAllowedAsSubstring = z;
    }

    public final boolean isAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }
}
