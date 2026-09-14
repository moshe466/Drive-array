package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransformerSpec.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/TransformerSpec;", JsonProperty.USE_DEFAULT_NAME, "lowerCase", JsonProperty.USE_DEFAULT_NAME, "processHonorificTag", "honorificTok", JsonProperty.USE_DEFAULT_NAME, "(ZZLjava/lang/String;)V", "getHonorificTok", "()Ljava/lang/String;", "getLowerCase", "()Z", "getProcessHonorificTag", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TransformerSpec {
    private final String honorificTok;
    private final boolean lowerCase;
    private final boolean processHonorificTag;

    public TransformerSpec() {
        this(false, false, null, 7, null);
    }

    public static /* synthetic */ TransformerSpec copy$default(TransformerSpec transformerSpec, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = transformerSpec.lowerCase;
        }
        if ((i & 2) != 0) {
            z2 = transformerSpec.processHonorificTag;
        }
        if ((i & 4) != 0) {
            str = transformerSpec.honorificTok;
        }
        return transformerSpec.copy(z, z2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLowerCase() {
        return this.lowerCase;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getProcessHonorificTag() {
        return this.processHonorificTag;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHonorificTok() {
        return this.honorificTok;
    }

    public final TransformerSpec copy(boolean lowerCase, boolean processHonorificTag, String honorificTok) {
        Intrinsics.checkNotNullParameter(honorificTok, "honorificTok");
        return new TransformerSpec(lowerCase, processHonorificTag, honorificTok);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransformerSpec)) {
            return false;
        }
        TransformerSpec transformerSpec = (TransformerSpec) other;
        return this.lowerCase == transformerSpec.lowerCase && this.processHonorificTag == transformerSpec.processHonorificTag && Intrinsics.areEqual(this.honorificTok, transformerSpec.honorificTok);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.lowerCase;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.processHonorificTag;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.honorificTok.hashCode();
    }

    public String toString() {
        return "TransformerSpec(lowerCase=" + this.lowerCase + ", processHonorificTag=" + this.processHonorificTag + ", honorificTok=" + this.honorificTok + ")";
    }

    public TransformerSpec(boolean z, boolean z2, String honorificTok) {
        Intrinsics.checkNotNullParameter(honorificTok, "honorificTok");
        this.lowerCase = z;
        this.processHonorificTag = z2;
        this.honorificTok = honorificTok;
    }

    public /* synthetic */ TransformerSpec(boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str);
    }

    public final boolean getLowerCase() {
        return this.lowerCase;
    }

    public final boolean getProcessHonorificTag() {
        return this.processHonorificTag;
    }

    public final String getHonorificTok() {
        return this.honorificTok;
    }
}
