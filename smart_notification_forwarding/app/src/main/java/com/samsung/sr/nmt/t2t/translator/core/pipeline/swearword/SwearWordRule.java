package com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwearWordReplacer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", JsonProperty.USE_DEFAULT_NAME, "language", JsonProperty.USE_DEFAULT_NAME, "sourceText", "onlyWord", JsonProperty.USE_DEFAULT_NAME, "replaceTo", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getOnlyWord", "()Z", "getReplaceTo", "getSourceText", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class SwearWordRule {
    private final String language;
    private final boolean onlyWord;
    private final String replaceTo;
    private final String sourceText;

    public static /* synthetic */ SwearWordRule copy$default(SwearWordRule swearWordRule, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = swearWordRule.language;
        }
        if ((i & 2) != 0) {
            str2 = swearWordRule.sourceText;
        }
        if ((i & 4) != 0) {
            z = swearWordRule.onlyWord;
        }
        if ((i & 8) != 0) {
            str3 = swearWordRule.replaceTo;
        }
        return swearWordRule.copy(str, str2, z, str3);
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
    public final boolean getOnlyWord() {
        return this.onlyWord;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReplaceTo() {
        return this.replaceTo;
    }

    public final SwearWordRule copy(String language, String sourceText, boolean onlyWord, String replaceTo) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        return new SwearWordRule(language, sourceText, onlyWord, replaceTo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwearWordRule)) {
            return false;
        }
        SwearWordRule swearWordRule = (SwearWordRule) other;
        return Intrinsics.areEqual(this.language, swearWordRule.language) && Intrinsics.areEqual(this.sourceText, swearWordRule.sourceText) && this.onlyWord == swearWordRule.onlyWord && Intrinsics.areEqual(this.replaceTo, swearWordRule.replaceTo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.language.hashCode() * 31) + this.sourceText.hashCode()) * 31;
        boolean z = this.onlyWord;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.replaceTo.hashCode();
    }

    public String toString() {
        return "SwearWordRule(language=" + this.language + ", sourceText=" + this.sourceText + ", onlyWord=" + this.onlyWord + ", replaceTo=" + this.replaceTo + ")";
    }

    public SwearWordRule(String language, String sourceText, boolean z, String replaceTo) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        this.language = language;
        this.sourceText = sourceText;
        this.onlyWord = z;
        this.replaceTo = replaceTo;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final boolean getOnlyWord() {
        return this.onlyWord;
    }

    public final String getReplaceTo() {
        return this.replaceTo;
    }
}
