package com.samsung.sr.nmt.core.t2t.translator.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageDirection.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0000J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, "srcLang", JsonProperty.USE_DEFAULT_NAME, "tgtLang", "(Ljava/lang/String;Ljava/lang/String;)V", "getSrcLang", "()Ljava/lang/String;", "getTgtLang", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "reversed", "toString", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class LanguageDirection {
    private final String srcLang;
    private final String tgtLang;

    public static /* synthetic */ LanguageDirection copy$default(LanguageDirection languageDirection, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = languageDirection.srcLang;
        }
        if ((i & 2) != 0) {
            str2 = languageDirection.tgtLang;
        }
        return languageDirection.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSrcLang() {
        return this.srcLang;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTgtLang() {
        return this.tgtLang;
    }

    public final LanguageDirection copy(String srcLang, String tgtLang) {
        Intrinsics.checkNotNullParameter(srcLang, "srcLang");
        Intrinsics.checkNotNullParameter(tgtLang, "tgtLang");
        return new LanguageDirection(srcLang, tgtLang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageDirection)) {
            return false;
        }
        LanguageDirection languageDirection = (LanguageDirection) other;
        return Intrinsics.areEqual(this.srcLang, languageDirection.srcLang) && Intrinsics.areEqual(this.tgtLang, languageDirection.tgtLang);
    }

    public int hashCode() {
        return (this.srcLang.hashCode() * 31) + this.tgtLang.hashCode();
    }

    public String toString() {
        return "LanguageDirection(srcLang=" + this.srcLang + ", tgtLang=" + this.tgtLang + ')';
    }

    public LanguageDirection(String srcLang, String tgtLang) {
        Intrinsics.checkNotNullParameter(srcLang, "srcLang");
        Intrinsics.checkNotNullParameter(tgtLang, "tgtLang");
        this.srcLang = srcLang;
        this.tgtLang = tgtLang;
    }

    public final String getSrcLang() {
        return this.srcLang;
    }

    public final String getTgtLang() {
        return this.tgtLang;
    }

    public final LanguageDirection reversed() {
        return new LanguageDirection(this.tgtLang, this.srcLang);
    }
}
