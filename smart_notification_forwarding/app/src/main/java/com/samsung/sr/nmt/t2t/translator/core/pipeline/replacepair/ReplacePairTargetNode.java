package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairTargetNode.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairTargetNode;", JsonProperty.USE_DEFAULT_NAME, "sourceTexts", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "targetTextAfter", "isAllowedAsSubstring", JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/Set;Ljava/lang/String;Z)V", "()Z", "getSourceTexts", "()Ljava/util/Set;", "getTargetTextAfter", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ReplacePairTargetNode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isAllowedAsSubstring;
    private final Set<String> sourceTexts;
    private final String targetTextAfter;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReplacePairTargetNode copy$default(ReplacePairTargetNode replacePairTargetNode, Set set, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            set = replacePairTargetNode.sourceTexts;
        }
        if ((i & 2) != 0) {
            str = replacePairTargetNode.targetTextAfter;
        }
        if ((i & 4) != 0) {
            z = replacePairTargetNode.isAllowedAsSubstring;
        }
        return replacePairTargetNode.copy(set, str, z);
    }

    public final Set<String> component1() {
        return this.sourceTexts;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetTextAfter() {
        return this.targetTextAfter;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }

    public final ReplacePairTargetNode copy(Set<String> sourceTexts, String targetTextAfter, boolean isAllowedAsSubstring) {
        Intrinsics.checkNotNullParameter(sourceTexts, "sourceTexts");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        return new ReplacePairTargetNode(sourceTexts, targetTextAfter, isAllowedAsSubstring);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplacePairTargetNode)) {
            return false;
        }
        ReplacePairTargetNode replacePairTargetNode = (ReplacePairTargetNode) other;
        return Intrinsics.areEqual(this.sourceTexts, replacePairTargetNode.sourceTexts) && Intrinsics.areEqual(this.targetTextAfter, replacePairTargetNode.targetTextAfter) && this.isAllowedAsSubstring == replacePairTargetNode.isAllowedAsSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.sourceTexts.hashCode() * 31) + this.targetTextAfter.hashCode()) * 31;
        boolean z = this.isAllowedAsSubstring;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ReplacePairTargetNode(sourceTexts=" + this.sourceTexts + ", targetTextAfter=" + this.targetTextAfter + ", isAllowedAsSubstring=" + this.isAllowedAsSubstring + ")";
    }

    public ReplacePairTargetNode(Set<String> sourceTexts, String targetTextAfter, boolean z) {
        Intrinsics.checkNotNullParameter(sourceTexts, "sourceTexts");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        this.sourceTexts = sourceTexts;
        this.targetTextAfter = targetTextAfter;
        this.isAllowedAsSubstring = z;
    }

    public final Set<String> getSourceTexts() {
        return this.sourceTexts;
    }

    public final String getTargetTextAfter() {
        return this.targetTextAfter;
    }

    public final boolean isAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }

    /* compiled from: ReplacePairTargetNode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairTargetNode$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "fromReplacePair", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairTargetNode;", "replacePair", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePair;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReplacePairTargetNode fromReplacePair(ReplacePair replacePair) {
            Intrinsics.checkNotNullParameter(replacePair, "replacePair");
            return new ReplacePairTargetNode(SetsKt.mutableSetOf(replacePair.getSourceText()), replacePair.getTargetTextAfter(), replacePair.isAllowedAsSubstring());
        }
    }
}
