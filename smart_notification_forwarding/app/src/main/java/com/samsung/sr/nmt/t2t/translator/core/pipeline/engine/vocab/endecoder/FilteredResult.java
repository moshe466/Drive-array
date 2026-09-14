package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilteredResult.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/FilteredResult;", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "unknownRatio", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;F)V", "getText", "()Ljava/lang/String;", "getUnknownRatio", "()F", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class FilteredResult {
    private final String text;
    private final float unknownRatio;

    public static /* synthetic */ FilteredResult copy$default(FilteredResult filteredResult, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filteredResult.text;
        }
        if ((i & 2) != 0) {
            f = filteredResult.unknownRatio;
        }
        return filteredResult.copy(str, f);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final float getUnknownRatio() {
        return this.unknownRatio;
    }

    public final FilteredResult copy(String text, float unknownRatio) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new FilteredResult(text, unknownRatio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilteredResult)) {
            return false;
        }
        FilteredResult filteredResult = (FilteredResult) other;
        return Intrinsics.areEqual(this.text, filteredResult.text) && Float.compare(this.unknownRatio, filteredResult.unknownRatio) == 0;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + Float.hashCode(this.unknownRatio);
    }

    public String toString() {
        return "FilteredResult(text=" + this.text + ", unknownRatio=" + this.unknownRatio + ")";
    }

    public FilteredResult(String text, float f) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.unknownRatio = f;
    }

    public final String getText() {
        return this.text;
    }

    public final float getUnknownRatio() {
        return this.unknownRatio;
    }
}
