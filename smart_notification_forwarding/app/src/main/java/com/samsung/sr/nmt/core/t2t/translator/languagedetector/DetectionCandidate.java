package com.samsung.sr.nmt.core.t2t.translator.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectionCandidate.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/languagedetector/DetectionCandidate;", JsonProperty.USE_DEFAULT_NAME, "languageCode", JsonProperty.USE_DEFAULT_NAME, "probability", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;F)V", "getLanguageCode", "()Ljava/lang/String;", "getProbability", "()F", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class DetectionCandidate {
    private final String languageCode;
    private final float probability;

    public static /* synthetic */ DetectionCandidate copy$default(DetectionCandidate detectionCandidate, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = detectionCandidate.languageCode;
        }
        if ((i & 2) != 0) {
            f = detectionCandidate.probability;
        }
        return detectionCandidate.copy(str, f);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLanguageCode() {
        return this.languageCode;
    }

    /* renamed from: component2, reason: from getter */
    public final float getProbability() {
        return this.probability;
    }

    public final DetectionCandidate copy(String languageCode, float probability) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        return new DetectionCandidate(languageCode, probability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectionCandidate)) {
            return false;
        }
        DetectionCandidate detectionCandidate = (DetectionCandidate) other;
        return Intrinsics.areEqual(this.languageCode, detectionCandidate.languageCode) && Float.compare(this.probability, detectionCandidate.probability) == 0;
    }

    public int hashCode() {
        return (this.languageCode.hashCode() * 31) + Float.hashCode(this.probability);
    }

    public String toString() {
        return "DetectionCandidate(languageCode=" + this.languageCode + ", probability=" + this.probability + ')';
    }

    public DetectionCandidate(String languageCode, float probability) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        this.languageCode = languageCode;
        this.probability = probability;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final float getProbability() {
        return this.probability;
    }
}
