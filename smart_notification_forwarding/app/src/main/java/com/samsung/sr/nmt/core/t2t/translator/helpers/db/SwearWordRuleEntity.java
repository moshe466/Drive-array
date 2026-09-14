package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwearWordRuleEntity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/SwearWordRuleEntity;", JsonProperty.USE_DEFAULT_NAME, "language", JsonProperty.USE_DEFAULT_NAME, "sourceText", "replaceTo", "onlyWord", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "getOnlyWord", "()I", "setOnlyWord", "(I)V", "getReplaceTo", "setReplaceTo", "getSourceText", "setSourceText", "component1", "component2", "component3", "component4", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class SwearWordRuleEntity {
    private String language;
    private int onlyWord;
    private String replaceTo;
    private String sourceText;

    public SwearWordRuleEntity() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ SwearWordRuleEntity copy$default(SwearWordRuleEntity swearWordRuleEntity, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = swearWordRuleEntity.language;
        }
        if ((i2 & 2) != 0) {
            str2 = swearWordRuleEntity.sourceText;
        }
        if ((i2 & 4) != 0) {
            str3 = swearWordRuleEntity.replaceTo;
        }
        if ((i2 & 8) != 0) {
            i = swearWordRuleEntity.onlyWord;
        }
        return swearWordRuleEntity.copy(str, str2, str3, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSourceText() {
        return this.sourceText;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReplaceTo() {
        return this.replaceTo;
    }

    /* renamed from: component4, reason: from getter */
    public final int getOnlyWord() {
        return this.onlyWord;
    }

    public final SwearWordRuleEntity copy(String language, String sourceText, String replaceTo, int onlyWord) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        return new SwearWordRuleEntity(language, sourceText, replaceTo, onlyWord);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwearWordRuleEntity)) {
            return false;
        }
        SwearWordRuleEntity swearWordRuleEntity = (SwearWordRuleEntity) other;
        return Intrinsics.areEqual(this.language, swearWordRuleEntity.language) && Intrinsics.areEqual(this.sourceText, swearWordRuleEntity.sourceText) && Intrinsics.areEqual(this.replaceTo, swearWordRuleEntity.replaceTo) && this.onlyWord == swearWordRuleEntity.onlyWord;
    }

    public int hashCode() {
        return (((((this.language.hashCode() * 31) + this.sourceText.hashCode()) * 31) + this.replaceTo.hashCode()) * 31) + Integer.hashCode(this.onlyWord);
    }

    public String toString() {
        return "SwearWordRuleEntity(language=" + this.language + ", sourceText=" + this.sourceText + ", replaceTo=" + this.replaceTo + ", onlyWord=" + this.onlyWord + ')';
    }

    public SwearWordRuleEntity(String language, String sourceText, String replaceTo, int onlyWord) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        this.language = language;
        this.sourceText = sourceText;
        this.replaceTo = replaceTo;
        this.onlyWord = onlyWord;
    }

    public /* synthetic */ SwearWordRuleEntity(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i2 & 2) != 0 ? JsonProperty.USE_DEFAULT_NAME : str2, (i2 & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str3, (i2 & 8) != 0 ? 1 : i);
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
