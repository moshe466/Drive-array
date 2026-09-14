package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceholderSpec.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/PlaceholderSpec;", JsonProperty.USE_DEFAULT_NAME, "processPlh", JsonProperty.USE_DEFAULT_NAME, "plhTok", JsonProperty.USE_DEFAULT_NAME, "numPlhTok", JsonProperty.USE_DEFAULT_NAME, "preventPlhTokenSplits", "(ZLjava/lang/String;IZ)V", "getNumPlhTok", "()I", "getPlhTok", "()Ljava/lang/String;", "getPreventPlhTokenSplits", "()Z", "getProcessPlh", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class PlaceholderSpec {
    private final int numPlhTok;
    private final String plhTok;
    private final boolean preventPlhTokenSplits;
    private final boolean processPlh;

    public PlaceholderSpec() {
        this(false, null, 0, false, 15, null);
    }

    public static /* synthetic */ PlaceholderSpec copy$default(PlaceholderSpec placeholderSpec, boolean z, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = placeholderSpec.processPlh;
        }
        if ((i2 & 2) != 0) {
            str = placeholderSpec.plhTok;
        }
        if ((i2 & 4) != 0) {
            i = placeholderSpec.numPlhTok;
        }
        if ((i2 & 8) != 0) {
            z2 = placeholderSpec.preventPlhTokenSplits;
        }
        return placeholderSpec.copy(z, str, i, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getProcessPlh() {
        return this.processPlh;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlhTok() {
        return this.plhTok;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNumPlhTok() {
        return this.numPlhTok;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getPreventPlhTokenSplits() {
        return this.preventPlhTokenSplits;
    }

    public final PlaceholderSpec copy(boolean processPlh, String plhTok, int numPlhTok, boolean preventPlhTokenSplits) {
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        return new PlaceholderSpec(processPlh, plhTok, numPlhTok, preventPlhTokenSplits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceholderSpec)) {
            return false;
        }
        PlaceholderSpec placeholderSpec = (PlaceholderSpec) other;
        return this.processPlh == placeholderSpec.processPlh && Intrinsics.areEqual(this.plhTok, placeholderSpec.plhTok) && this.numPlhTok == placeholderSpec.numPlhTok && this.preventPlhTokenSplits == placeholderSpec.preventPlhTokenSplits;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.processPlh;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((r0 * 31) + this.plhTok.hashCode()) * 31) + Integer.hashCode(this.numPlhTok)) * 31;
        boolean z2 = this.preventPlhTokenSplits;
        return hashCode + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "PlaceholderSpec(processPlh=" + this.processPlh + ", plhTok=" + this.plhTok + ", numPlhTok=" + this.numPlhTok + ", preventPlhTokenSplits=" + this.preventPlhTokenSplits + ")";
    }

    public PlaceholderSpec(boolean z, String plhTok, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        this.processPlh = z;
        this.plhTok = plhTok;
        this.numPlhTok = i;
        this.preventPlhTokenSplits = z2;
    }

    public /* synthetic */ PlaceholderSpec(boolean z, String str, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "<PLH?>" : str, (i2 & 4) != 0 ? 16 : i, (i2 & 8) != 0 ? false : z2);
    }

    public final boolean getProcessPlh() {
        return this.processPlh;
    }

    public final String getPlhTok() {
        return this.plhTok;
    }

    public final int getNumPlhTok() {
        return this.numPlhTok;
    }

    public final boolean getPreventPlhTokenSplits() {
        return this.preventPlhTokenSplits;
    }
}
