package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PunctuationQuoteStyle.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/PunctuationQuoteStyle;", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "isInsideQuote", JsonProperty.USE_DEFAULT_NAME, "punctuation", JsonProperty.USE_DEFAULT_NAME, "DEFAULT", "PL", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class PunctuationQuoteStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PunctuationQuoteStyle[] $VALUES;
    public static final PunctuationQuoteStyle DEFAULT = new PunctuationQuoteStyle("DEFAULT", 0);
    public static final PunctuationQuoteStyle PL = new PunctuationQuoteStyle("PL", 1) { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.PunctuationQuoteStyle.PL
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.PunctuationQuoteStyle
        public boolean isInsideQuote(String punctuation) {
            Intrinsics.checkNotNullParameter(punctuation, "punctuation");
            return !Intrinsics.areEqual(punctuation, ".");
        }
    };

    private static final /* synthetic */ PunctuationQuoteStyle[] $values() {
        return new PunctuationQuoteStyle[]{DEFAULT, PL};
    }

    public /* synthetic */ PunctuationQuoteStyle(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static EnumEntries<PunctuationQuoteStyle> getEntries() {
        return $ENTRIES;
    }

    public static PunctuationQuoteStyle valueOf(String str) {
        return (PunctuationQuoteStyle) Enum.valueOf(PunctuationQuoteStyle.class, str);
    }

    public static PunctuationQuoteStyle[] values() {
        return (PunctuationQuoteStyle[]) $VALUES.clone();
    }

    public boolean isInsideQuote(String punctuation) {
        Intrinsics.checkNotNullParameter(punctuation, "punctuation");
        return true;
    }

    private PunctuationQuoteStyle(String str, int i) {
    }

    static {
        PunctuationQuoteStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
