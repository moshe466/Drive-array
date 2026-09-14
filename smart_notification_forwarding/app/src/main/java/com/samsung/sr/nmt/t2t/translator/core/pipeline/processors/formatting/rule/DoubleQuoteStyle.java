package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DoubleQuoteStyle.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/DoubleQuoteStyle;", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "end", JsonProperty.USE_DEFAULT_NAME, "start", "DEFAULT", "PL", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class DoubleQuoteStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DoubleQuoteStyle[] $VALUES;
    public static final DoubleQuoteStyle DEFAULT = new DoubleQuoteStyle("DEFAULT", 0);
    public static final DoubleQuoteStyle PL = new DoubleQuoteStyle("PL", 1) { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteStyle.PL
        @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteStyle
        public String end() {
            return "”";
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteStyle
        public String start() {
            return "„";
        }

        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }
    };

    private static final /* synthetic */ DoubleQuoteStyle[] $values() {
        return new DoubleQuoteStyle[]{DEFAULT, PL};
    }

    public /* synthetic */ DoubleQuoteStyle(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static EnumEntries<DoubleQuoteStyle> getEntries() {
        return $ENTRIES;
    }

    public static DoubleQuoteStyle valueOf(String str) {
        return (DoubleQuoteStyle) Enum.valueOf(DoubleQuoteStyle.class, str);
    }

    public static DoubleQuoteStyle[] values() {
        return (DoubleQuoteStyle[]) $VALUES.clone();
    }

    public String end() {
        return "\"";
    }

    public String start() {
        return "\"";
    }

    private DoubleQuoteStyle(String str, int i) {
    }

    static {
        DoubleQuoteStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
