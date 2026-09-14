package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePair.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePair;", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "sourceText", "targetTextBefore", "targetTextAfter", "isAllowedAsSubstring", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getSourceLanguage", "()Ljava/lang/String;", "getSourceText", "getTargetLanguage", "getTargetTextAfter", "getTargetTextBefore", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ReplacePair {
    private final boolean isAllowedAsSubstring;
    private final String sourceLanguage;
    private final String sourceText;
    private final String targetLanguage;
    private final String targetTextAfter;
    private final String targetTextBefore;

    public static /* synthetic */ ReplacePair copy$default(ReplacePair replacePair, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = replacePair.sourceLanguage;
        }
        if ((i & 2) != 0) {
            str2 = replacePair.targetLanguage;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = replacePair.sourceText;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = replacePair.targetTextBefore;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = replacePair.targetTextAfter;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            z = replacePair.isAllowedAsSubstring;
        }
        return replacePair.copy(str, str6, str7, str8, str9, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSourceText() {
        return this.sourceText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTargetTextBefore() {
        return this.targetTextBefore;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTargetTextAfter() {
        return this.targetTextAfter;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }

    public final ReplacePair copy(String sourceLanguage, String targetLanguage, String sourceText, String targetTextBefore, String targetTextAfter, boolean isAllowedAsSubstring) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetTextBefore, "targetTextBefore");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        return new ReplacePair(sourceLanguage, targetLanguage, sourceText, targetTextBefore, targetTextAfter, isAllowedAsSubstring);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplacePair)) {
            return false;
        }
        ReplacePair replacePair = (ReplacePair) other;
        return Intrinsics.areEqual(this.sourceLanguage, replacePair.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, replacePair.targetLanguage) && Intrinsics.areEqual(this.sourceText, replacePair.sourceText) && Intrinsics.areEqual(this.targetTextBefore, replacePair.targetTextBefore) && Intrinsics.areEqual(this.targetTextAfter, replacePair.targetTextAfter) && this.isAllowedAsSubstring == replacePair.isAllowedAsSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.sourceLanguage.hashCode() * 31) + this.targetLanguage.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.targetTextBefore.hashCode()) * 31) + this.targetTextAfter.hashCode()) * 31;
        boolean z = this.isAllowedAsSubstring;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ReplacePair(sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", sourceText=" + this.sourceText + ", targetTextBefore=" + this.targetTextBefore + ", targetTextAfter=" + this.targetTextAfter + ", isAllowedAsSubstring=" + this.isAllowedAsSubstring + ")";
    }

    public ReplacePair(String sourceLanguage, String targetLanguage, String sourceText, String targetTextBefore, String targetTextAfter, boolean z) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetTextBefore, "targetTextBefore");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.sourceText = sourceText;
        this.targetTextBefore = targetTextBefore;
        this.targetTextAfter = targetTextAfter;
        this.isAllowedAsSubstring = z;
    }

    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final String getTargetTextBefore() {
        return this.targetTextBefore;
    }

    public final String getTargetTextAfter() {
        return this.targetTextAfter;
    }

    public final boolean isAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }
}
