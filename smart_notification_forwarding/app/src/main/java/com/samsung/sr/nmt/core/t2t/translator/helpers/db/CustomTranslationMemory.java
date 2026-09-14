package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTranslationMemory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/CustomTranslationMemory;", JsonProperty.USE_DEFAULT_NAME, "packageName", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", "sourceText", "targetText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getSourceLanguage", "setSourceLanguage", "getSourceText", "setSourceText", "getTargetLanguage", "setTargetLanguage", "getTargetText", "setTargetText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class CustomTranslationMemory {
    private String packageName;
    private String sourceLanguage;
    private String sourceText;
    private String targetLanguage;
    private String targetText;

    public CustomTranslationMemory() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CustomTranslationMemory copy$default(CustomTranslationMemory customTranslationMemory, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customTranslationMemory.packageName;
        }
        if ((i & 2) != 0) {
            str2 = customTranslationMemory.sourceLanguage;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = customTranslationMemory.targetLanguage;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = customTranslationMemory.sourceText;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = customTranslationMemory.targetText;
        }
        return customTranslationMemory.copy(str, str6, str7, str8, str5);
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
    public final String getTargetText() {
        return this.targetText;
    }

    public final CustomTranslationMemory copy(String packageName, String sourceLanguage, String targetLanguage, String sourceText, String targetText) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        return new CustomTranslationMemory(packageName, sourceLanguage, targetLanguage, sourceText, targetText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomTranslationMemory)) {
            return false;
        }
        CustomTranslationMemory customTranslationMemory = (CustomTranslationMemory) other;
        return Intrinsics.areEqual(this.packageName, customTranslationMemory.packageName) && Intrinsics.areEqual(this.sourceLanguage, customTranslationMemory.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, customTranslationMemory.targetLanguage) && Intrinsics.areEqual(this.sourceText, customTranslationMemory.sourceText) && Intrinsics.areEqual(this.targetText, customTranslationMemory.targetText);
    }

    public int hashCode() {
        return (((((((this.packageName.hashCode() * 31) + this.sourceLanguage.hashCode()) * 31) + this.targetLanguage.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.targetText.hashCode();
    }

    public String toString() {
        return "CustomTranslationMemory(packageName=" + this.packageName + ", sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", sourceText=" + this.sourceText + ", targetText=" + this.targetText + ')';
    }

    public CustomTranslationMemory(String packageName, String sourceLanguage, String targetLanguage, String sourceText, String targetText) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        this.packageName = packageName;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.sourceText = sourceText;
        this.targetText = targetText;
    }

    public /* synthetic */ CustomTranslationMemory(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i & 2) != 0 ? JsonProperty.USE_DEFAULT_NAME : str2, (i & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str3, (i & 8) != 0 ? JsonProperty.USE_DEFAULT_NAME : str4, (i & 16) != 0 ? JsonProperty.USE_DEFAULT_NAME : str5);
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

    public final String getTargetText() {
        return this.targetText;
    }

    public final void setTargetText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetText = str;
    }
}
