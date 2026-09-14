package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: ReplacePairEntity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017¨\u0006,"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairEntity;", JsonProperty.USE_DEFAULT_NAME, "id", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "sourceText", "targetTextBefore", "targetTextAfter", "isAllowedAsSubstring", JsonProperty.USE_DEFAULT_NAME, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()I", "setId", "(I)V", "()Z", "setAllowedAsSubstring", "(Z)V", "getSourceLanguage", "()Ljava/lang/String;", "setSourceLanguage", "(Ljava/lang/String;)V", "getSourceText", "setSourceText", "getTargetLanguage", "setTargetLanguage", "getTargetTextAfter", "setTargetTextAfter", "getTargetTextBefore", "setTargetTextBefore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ReplacePairEntity {
    private int id;
    private boolean isAllowedAsSubstring;
    private String sourceLanguage;
    private String sourceText;
    private String targetLanguage;
    private String targetTextAfter;
    private String targetTextBefore;

    public ReplacePairEntity() {
        this(0, null, null, null, null, null, false, WorkQueueKt.MASK, null);
    }

    public static /* synthetic */ ReplacePairEntity copy$default(ReplacePairEntity replacePairEntity, int i, String str, String str2, String str3, String str4, String str5, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = replacePairEntity.id;
        }
        if ((i2 & 2) != 0) {
            str = replacePairEntity.sourceLanguage;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = replacePairEntity.targetLanguage;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = replacePairEntity.sourceText;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = replacePairEntity.targetTextBefore;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = replacePairEntity.targetTextAfter;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            z = replacePairEntity.isAllowedAsSubstring;
        }
        return replacePairEntity.copy(i, str6, str7, str8, str9, str10, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
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

    public final ReplacePairEntity copy(int id, String sourceLanguage, String targetLanguage, String sourceText, String targetTextBefore, String targetTextAfter, boolean isAllowedAsSubstring) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetTextBefore, "targetTextBefore");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        return new ReplacePairEntity(id, sourceLanguage, targetLanguage, sourceText, targetTextBefore, targetTextAfter, isAllowedAsSubstring);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplacePairEntity)) {
            return false;
        }
        ReplacePairEntity replacePairEntity = (ReplacePairEntity) other;
        return this.id == replacePairEntity.id && Intrinsics.areEqual(this.sourceLanguage, replacePairEntity.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, replacePairEntity.targetLanguage) && Intrinsics.areEqual(this.sourceText, replacePairEntity.sourceText) && Intrinsics.areEqual(this.targetTextBefore, replacePairEntity.targetTextBefore) && Intrinsics.areEqual(this.targetTextAfter, replacePairEntity.targetTextAfter) && this.isAllowedAsSubstring == replacePairEntity.isAllowedAsSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((Integer.hashCode(this.id) * 31) + this.sourceLanguage.hashCode()) * 31) + this.targetLanguage.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.targetTextBefore.hashCode()) * 31) + this.targetTextAfter.hashCode()) * 31;
        boolean z = this.isAllowedAsSubstring;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ReplacePairEntity(id=" + this.id + ", sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", sourceText=" + this.sourceText + ", targetTextBefore=" + this.targetTextBefore + ", targetTextAfter=" + this.targetTextAfter + ", isAllowedAsSubstring=" + this.isAllowedAsSubstring + ')';
    }

    public ReplacePairEntity(int id, String sourceLanguage, String targetLanguage, String sourceText, String targetTextBefore, String targetTextAfter, boolean isAllowedAsSubstring) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetTextBefore, "targetTextBefore");
        Intrinsics.checkNotNullParameter(targetTextAfter, "targetTextAfter");
        this.id = id;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.sourceText = sourceText;
        this.targetTextBefore = targetTextBefore;
        this.targetTextAfter = targetTextAfter;
        this.isAllowedAsSubstring = isAllowedAsSubstring;
    }

    public /* synthetic */ ReplacePairEntity(int i, String str, String str2, String str3, String str4, String str5, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i2 & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str2, (i2 & 8) != 0 ? JsonProperty.USE_DEFAULT_NAME : str3, (i2 & 16) != 0 ? JsonProperty.USE_DEFAULT_NAME : str4, (i2 & 32) == 0 ? str5 : JsonProperty.USE_DEFAULT_NAME, (i2 & 64) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
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
