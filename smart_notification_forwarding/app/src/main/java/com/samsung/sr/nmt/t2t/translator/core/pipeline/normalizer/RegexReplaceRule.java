package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: RegexReplaceRule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/RegexReplaceRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/ReplaceRule;", "regex", "Lkotlin/text/Regex;", "replaceTo", JsonProperty.USE_DEFAULT_NAME, "(Lkotlin/text/Regex;Ljava/lang/String;)V", "getRegex", "()Lkotlin/text/Regex;", "getReplaceTo", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", JsonProperty.USE_DEFAULT_NAME, "hashCode", JsonProperty.USE_DEFAULT_NAME, "replace", "text", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class RegexReplaceRule implements ReplaceRule {
    private final Regex regex;
    private final String replaceTo;

    public static /* synthetic */ RegexReplaceRule copy$default(RegexReplaceRule regexReplaceRule, Regex regex, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            regex = regexReplaceRule.regex;
        }
        if ((i & 2) != 0) {
            str = regexReplaceRule.replaceTo;
        }
        return regexReplaceRule.copy(regex, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Regex getRegex() {
        return this.regex;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReplaceTo() {
        return this.replaceTo;
    }

    public final RegexReplaceRule copy(Regex regex, String replaceTo) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        return new RegexReplaceRule(regex, replaceTo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegexReplaceRule)) {
            return false;
        }
        RegexReplaceRule regexReplaceRule = (RegexReplaceRule) other;
        return Intrinsics.areEqual(this.regex, regexReplaceRule.regex) && Intrinsics.areEqual(this.replaceTo, regexReplaceRule.replaceTo);
    }

    public int hashCode() {
        return (this.regex.hashCode() * 31) + this.replaceTo.hashCode();
    }

    public String toString() {
        return "RegexReplaceRule(regex=" + this.regex + ", replaceTo=" + this.replaceTo + ")";
    }

    public RegexReplaceRule(Regex regex, String replaceTo) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        this.regex = regex;
        this.replaceTo = replaceTo;
    }

    public final Regex getRegex() {
        return this.regex;
    }

    public final String getReplaceTo() {
        return this.replaceTo;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.ReplaceRule
    public String replace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.regex.replace(text, this.replaceTo);
    }
}
