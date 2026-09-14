package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: CustomReplacePairEntity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006*"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/CustomReplacePairEntity;", JsonProperty.USE_DEFAULT_NAME, "packageName", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", "sourceText", "targetTextBefore", "targetTextAfter", "isAllowedAsSubstring", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setAllowedAsSubstring", "(Z)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getSourceLanguage", "setSourceLanguage", "getSourceText", "setSourceText", "getTargetLanguage", "setTargetLanguage", "getTargetTextAfter", "setTargetTextAfter", "getTargetTextBefore", "setTargetTextBefore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class CustomReplacePairEntity {
    private boolean isAllowedAsSubstring;
    private String packageName;
    private String sourceLanguage;
    private String sourceText;
    private String targetLanguage;
    private String targetTextAfter;
    private String targetTextBefore;

    public CustomReplacePairEntity() {
        this(null, null, null, null, null, null, false, WorkQueueKt.MASK, null);
    }

    public static /* synthetic */ CustomReplacePairEntity copy$default(CustomReplacePairEntity customReplacePairEntity, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customReplacePairEntity.packageName;
        }
        if ((i & 2) != 0) {
            str2 = customReplacePairEntity.sourceLanguage;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = customReplacePairEntity.targetLanguage;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = customReplacePairEntity.sourceText;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = customReplacePairEntity.targetTextBefore;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = customReplacePairEntity.targetTextAfter;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            z = customReplacePairEntity.isAllowedAsSubstring;
        }
        return customReplacePairEntity.copy(str, str7, str8, str9, str10, str11, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSourceText() {
        return this.sourceText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTargetTextBefore() {
        return this.targetTextBefore;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTargetTextAfter() {
        return this.targetTextAfter;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }

    public final CustomReplacePairEntity copy(String packageName, String sourceLanguage, String targetLanguage, String sourceText, String targetTextBefore, String targetTextAfter, boolean isAllowedAsSubstring) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetTextBefore, "targetTextBefore");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        return new CustomReplacePairEntity(packageName, sourceLanguage, targetLanguage, sourceText, targetTextBefore, targetTextAfter, isAllowedAsSubstring);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomReplacePairEntity)) {
            return false;
        }
        CustomReplacePairEntity customReplacePairEntity = (CustomReplacePairEntity) other;
        return Intrinsics.areEqual(this.packageName, customReplacePairEntity.packageName) && Intrinsics.areEqual(this.sourceLanguage, customReplacePairEntity.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, customReplacePairEntity.targetLanguage) && Intrinsics.areEqual(this.sourceText, customReplacePairEntity.sourceText) && Intrinsics.areEqual(this.targetTextBefore, customReplacePairEntity.targetTextBefore) && Intrinsics.areEqual(this.targetTextAfter, customReplacePairEntity.targetTextAfter) && this.isAllowedAsSubstring == customReplacePairEntity.isAllowedAsSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.packageName.hashCode() * 31) + this.sourceLanguage.hashCode()) * 31) + this.targetLanguage.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.targetTextBefore.hashCode()) * 31) + this.targetTextAfter.hashCode()) * 31;
        boolean z = this.isAllowedAsSubstring;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "CustomReplacePairEntity(packageName=" + this.packageName + ", sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", sourceText=" + this.sourceText + ", targetTextBefore=" + this.targetTextBefore + ", targetTextAfter=" + this.targetTextAfter + ", isAllowedAsSubstring=" + this.isAllowedAsSubstring + ')';
    }

    public CustomReplacePairEntity(String packageName, String sourceLanguage, String targetLanguage, String sourceText, String targetTextBefore, String targetTextAfter, boolean isAllowedAsSubstring) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetTextBefore, "targetTextBefore");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        this.packageName = packageName;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.sourceText = sourceText;
        this.targetTextBefore = targetTextBefore;
        this.targetTextAfter = targetTextAfter;
        this.isAllowedAsSubstring = isAllowedAsSubstring;
    }

    public /* synthetic */ CustomReplacePairEntity(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i & 2) != 0 ? JsonProperty.USE_DEFAULT_NAME : str2, (i & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str3, (i & 8) != 0 ? JsonProperty.USE_DEFAULT_NAME : str4, (i & 16) != 0 ? JsonProperty.USE_DEFAULT_NAME : str5, (i & 32) == 0 ? str6 : JsonProperty.USE_DEFAULT_NAME, (i & 64) != 0 ? true : z);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    public final void setSourceLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceLanguage = str;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final void setTargetLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetLanguage = str;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final void setSourceText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceText = str;
    }

    public final String getTargetTextBefore() {
        return this.targetTextBefore;
    }

    public final void setTargetTextBefore(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetTextBefore = str;
    }

    public final String getTargetTextAfter() {
        return this.targetTextAfter;
    }

    public final void setTargetTextAfter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetTextAfter = str;
    }

    public final boolean isAllowedAsSubstring() {
        return this.isAllowedAsSubstring;
    }

    public final void setAllowedAsSubstring(boolean z) {
        this.isAllowedAsSubstring = z;
    }
}
