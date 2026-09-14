package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HonorificToken.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/HonorificToken;", JsonProperty.USE_DEFAULT_NAME, "honorificTok", JsonProperty.USE_DEFAULT_NAME, "honorificTokId", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "getHonorificTok", "()Ljava/lang/String;", "getHonorificTokId", "()I", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class HonorificToken {
    public static final int DEFAULT_HONORIFIC_TOKEN_ID = -1;
    private final String honorificTok;
    private final int honorificTokId;

    /* JADX WARN: Multi-variable type inference failed */
    public HonorificToken() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HonorificToken copy$default(HonorificToken honorificToken, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = honorificToken.honorificTok;
        }
        if ((i2 & 2) != 0) {
            i = honorificToken.honorificTokId;
        }
        return honorificToken.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHonorificTok() {
        return this.honorificTok;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHonorificTokId() {
        return this.honorificTokId;
    }

    public final HonorificToken copy(String honorificTok, int honorificTokId) {
        Intrinsics.checkNotNullParameter(honorificTok, "honorificTok");
        return new HonorificToken(honorificTok, honorificTokId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorificToken)) {
            return false;
        }
        HonorificToken honorificToken = (HonorificToken) other;
        return Intrinsics.areEqual(this.honorificTok, honorificToken.honorificTok) && this.honorificTokId == honorificToken.honorificTokId;
    }

    public int hashCode() {
        return (this.honorificTok.hashCode() * 31) + Integer.hashCode(this.honorificTokId);
    }

    public String toString() {
        return "HonorificToken(honorificTok=" + this.honorificTok + ", honorificTokId=" + this.honorificTokId + ")";
    }

    public HonorificToken(String honorificTok, int i) {
        Intrinsics.checkNotNullParameter(honorificTok, "honorificTok");
        this.honorificTok = honorificTok;
        this.honorificTokId = i;
    }

    public /* synthetic */ HonorificToken(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i2 & 2) != 0 ? -1 : i);
    }

    public final String getHonorificTok() {
        return this.honorificTok;
    }

    public final int getHonorificTokId() {
        return this.honorificTokId;
    }
}
