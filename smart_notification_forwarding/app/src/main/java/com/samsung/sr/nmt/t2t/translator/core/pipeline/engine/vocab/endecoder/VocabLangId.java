package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VocabLangId.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabLangId;", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "SRC", "TGT", "BOTH", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VocabLangId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VocabLangId[] $VALUES;
    public static final VocabLangId SRC = new VocabLangId("SRC", 0);
    public static final VocabLangId TGT = new VocabLangId("TGT", 1);
    public static final VocabLangId BOTH = new VocabLangId("BOTH", 2);

    private static final /* synthetic */ VocabLangId[] $values() {
        return new VocabLangId[]{SRC, TGT, BOTH};
    }

    public static EnumEntries<VocabLangId> getEntries() {
        return $ENTRIES;
    }

    public static VocabLangId valueOf(String str) {
        return (VocabLangId) Enum.valueOf(VocabLangId.class, str);
    }

    public static VocabLangId[] values() {
        return (VocabLangId[]) $VALUES.clone();
    }

    private VocabLangId(String str, int i) {
    }

    static {
        VocabLangId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
