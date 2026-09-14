package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EncodingResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "isUnknown", JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/List;Z)V", "getIds", "()Ljava/util/List;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class EncodingResult {
    private final List<Integer> ids;
    private final boolean isUnknown;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EncodingResult copy$default(EncodingResult encodingResult, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = encodingResult.ids;
        }
        if ((i & 2) != 0) {
            z = encodingResult.isUnknown;
        }
        return encodingResult.copy(list, z);
    }

    public final List<Integer> component1() {
        return this.ids;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsUnknown() {
        return this.isUnknown;
    }

    public final EncodingResult copy(List<Integer> ids, boolean isUnknown) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return new EncodingResult(ids, isUnknown);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncodingResult)) {
            return false;
        }
        EncodingResult encodingResult = (EncodingResult) other;
        return Intrinsics.areEqual(this.ids, encodingResult.ids) && this.isUnknown == encodingResult.isUnknown;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.ids.hashCode() * 31;
        boolean z = this.isUnknown;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "EncodingResult(ids=" + this.ids + ", isUnknown=" + this.isUnknown + ")";
    }

    public EncodingResult(List<Integer> ids, boolean z) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.ids = ids;
        this.isUnknown = z;
    }

    public final List<Integer> getIds() {
        return this.ids;
    }

    public final boolean isUnknown() {
        return this.isUnknown;
    }
}
