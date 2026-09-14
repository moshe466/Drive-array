package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EngineTranslationResult.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineTranslationResult;", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "rejected", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Z)V", "getRejected", "()Z", "setRejected", "(Z)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class EngineTranslationResult {
    private boolean rejected;
    private String text;

    /* JADX WARN: Multi-variable type inference failed */
    public EngineTranslationResult() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EngineTranslationResult copy$default(EngineTranslationResult engineTranslationResult, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = engineTranslationResult.text;
        }
        if ((i & 2) != 0) {
            z = engineTranslationResult.rejected;
        }
        return engineTranslationResult.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getRejected() {
        return this.rejected;
    }

    public final EngineTranslationResult copy(String text, boolean rejected) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new EngineTranslationResult(text, rejected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EngineTranslationResult)) {
            return false;
        }
        EngineTranslationResult engineTranslationResult = (EngineTranslationResult) other;
        return Intrinsics.areEqual(this.text, engineTranslationResult.text) && this.rejected == engineTranslationResult.rejected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        boolean z = this.rejected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "EngineTranslationResult(text=" + this.text + ", rejected=" + this.rejected + ")";
    }

    public EngineTranslationResult(String text, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.rejected = z;
    }

    public /* synthetic */ EngineTranslationResult(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i & 2) != 0 ? false : z);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final boolean getRejected() {
        return this.rejected;
    }

    public final void setRejected(boolean z) {
        this.rejected = z;
    }
}
