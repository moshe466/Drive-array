package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: LanguageDetectorParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorParams;", JsonProperty.USE_DEFAULT_NAME, "modelConfidenceThreshold", JsonProperty.USE_DEFAULT_NAME, "ruleConfidenceThreshold", "chineseRuleApplicableMinLength", JsonProperty.USE_DEFAULT_NAME, "chineseRuleValidThreshold", "(FFIF)V", "getChineseRuleApplicableMinLength", "()I", "getChineseRuleValidThreshold", "()F", "getModelConfidenceThreshold", "getRuleConfidenceThreshold", "component1", "component2", "component3", "component4", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class LanguageDetectorParams {
    private final int chineseRuleApplicableMinLength;
    private final float chineseRuleValidThreshold;
    private final float modelConfidenceThreshold;
    private final float ruleConfidenceThreshold;

    public static /* synthetic */ LanguageDetectorParams copy$default(LanguageDetectorParams languageDetectorParams, float f, float f2, int i, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = languageDetectorParams.modelConfidenceThreshold;
        }
        if ((i2 & 2) != 0) {
            f2 = languageDetectorParams.ruleConfidenceThreshold;
        }
        if ((i2 & 4) != 0) {
            i = languageDetectorParams.chineseRuleApplicableMinLength;
        }
        if ((i2 & 8) != 0) {
            f3 = languageDetectorParams.chineseRuleValidThreshold;
        }
        return languageDetectorParams.copy(f, f2, i, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getModelConfidenceThreshold() {
        return this.modelConfidenceThreshold;
    }

    /* renamed from: component2, reason: from getter */
    public final float getRuleConfidenceThreshold() {
        return this.ruleConfidenceThreshold;
    }

    /* renamed from: component3, reason: from getter */
    public final int getChineseRuleApplicableMinLength() {
        return this.chineseRuleApplicableMinLength;
    }

    /* renamed from: component4, reason: from getter */
    public final float getChineseRuleValidThreshold() {
        return this.chineseRuleValidThreshold;
    }

    public final LanguageDetectorParams copy(float modelConfidenceThreshold, float ruleConfidenceThreshold, int chineseRuleApplicableMinLength, float chineseRuleValidThreshold) {
        return new LanguageDetectorParams(modelConfidenceThreshold, ruleConfidenceThreshold, chineseRuleApplicableMinLength, chineseRuleValidThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageDetectorParams)) {
            return false;
        }
        LanguageDetectorParams languageDetectorParams = (LanguageDetectorParams) other;
        return Float.compare(this.modelConfidenceThreshold, languageDetectorParams.modelConfidenceThreshold) == 0 && Float.compare(this.ruleConfidenceThreshold, languageDetectorParams.ruleConfidenceThreshold) == 0 && this.chineseRuleApplicableMinLength == languageDetectorParams.chineseRuleApplicableMinLength && Float.compare(this.chineseRuleValidThreshold, languageDetectorParams.chineseRuleValidThreshold) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.modelConfidenceThreshold) * 31) + Float.hashCode(this.ruleConfidenceThreshold)) * 31) + Integer.hashCode(this.chineseRuleApplicableMinLength)) * 31) + Float.hashCode(this.chineseRuleValidThreshold);
    }

    public String toString() {
        return "LanguageDetectorParams(modelConfidenceThreshold=" + this.modelConfidenceThreshold + ", ruleConfidenceThreshold=" + this.ruleConfidenceThreshold + ", chineseRuleApplicableMinLength=" + this.chineseRuleApplicableMinLength + ", chineseRuleValidThreshold=" + this.chineseRuleValidThreshold + ")";
    }

    public LanguageDetectorParams(float f, float f2, int i, float f3) {
        this.modelConfidenceThreshold = f;
        this.ruleConfidenceThreshold = f2;
        this.chineseRuleApplicableMinLength = i;
        this.chineseRuleValidThreshold = f3;
    }

    public final float getModelConfidenceThreshold() {
        return this.modelConfidenceThreshold;
    }

    public final float getRuleConfidenceThreshold() {
        return this.ruleConfidenceThreshold;
    }

    public final int getChineseRuleApplicableMinLength() {
        return this.chineseRuleApplicableMinLength;
    }

    public final float getChineseRuleValidThreshold() {
        return this.chineseRuleValidThreshold;
    }
}
