package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomSwearWordRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/CustomSwearWordRule;", JsonProperty.USE_DEFAULT_NAME, "packageName", JsonProperty.USE_DEFAULT_NAME, "language", "sourceText", "replaceTo", "onlyWord", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "getOnlyWord", "()I", "setOnlyWord", "(I)V", "getPackageName", "setPackageName", "getReplaceTo", "setReplaceTo", "getSourceText", "setSourceText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class CustomSwearWordRule {
    private String language;
    private int onlyWord;
    private String packageName;
    private String replaceTo;
    private String sourceText;

    public CustomSwearWordRule() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ CustomSwearWordRule copy$default(CustomSwearWordRule customSwearWordRule, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = customSwearWordRule.packageName;
        }
        if ((i2 & 2) != 0) {
            str2 = customSwearWordRule.language;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = customSwearWordRule.sourceText;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = customSwearWordRule.replaceTo;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = customSwearWordRule.onlyWord;
        }
        return customSwearWordRule.copy(str, str5, str6, str7, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSourceText() {
        return this.sourceText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReplaceTo() {
        return this.replaceTo;
    }

    /* renamed from: component5, reason: from getter */
    public final int getOnlyWord() {
        return this.onlyWord;
    }

    public final CustomSwearWordRule copy(String packageName, String language, String sourceText, String replaceTo, int onlyWord) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        return new CustomSwearWordRule(packageName, language, sourceText, replaceTo, onlyWord);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomSwearWordRule)) {
            return false;
        }
        CustomSwearWordRule customSwearWordRule = (CustomSwearWordRule) other;
        return Intrinsics.areEqual(this.packageName, customSwearWordRule.packageName) && Intrinsics.areEqual(this.language, customSwearWordRule.language) && Intrinsics.areEqual(this.sourceText, customSwearWordRule.sourceText) && Intrinsics.areEqual(this.replaceTo, customSwearWordRule.replaceTo) && this.onlyWord == customSwearWordRule.onlyWord;
    }

    public int hashCode() {
        return (((((((this.packageName.hashCode() * 31) + this.language.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.replaceTo.hashCode()) * 31) + Integer.hashCode(this.onlyWord);
    }

    public String toString() {
        return "CustomSwearWordRule(packageName=" + this.packageName + ", language=" + this.language + ", sourceText=" + this.sourceText + ", replaceTo=" + this.replaceTo + ", onlyWord=" + this.onlyWord + ')';
    }

    public CustomSwearWordRule(String packageName, String language, String sourceText, String replaceTo, int onlyWord) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        this.packageName = packageName;
        this.language = language;
        this.sourceText = sourceText;
        this.replaceTo = replaceTo;
        this.onlyWord = onlyWord;
    }

    public /* synthetic */ CustomSwearWordRule(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i2 & 2) != 0 ? JsonProperty.USE_DEFAULT_NAME : str2, (i2 & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str3, (i2 & 8) == 0 ? str4 : JsonProperty.USE_DEFAULT_NAME, (i2 & 16) != 0 ? 1 : i);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final void setSourceText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceText = str;
    }

    public final String getReplaceTo() {
        return this.replaceTo;
    }

    public final void setReplaceTo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replaceTo = str;
    }

    public final int getOnlyWord() {
        return this.onlyWord;
    }

    public final void setOnlyWord(int i) {
        this.onlyWord = i;
    }
}
