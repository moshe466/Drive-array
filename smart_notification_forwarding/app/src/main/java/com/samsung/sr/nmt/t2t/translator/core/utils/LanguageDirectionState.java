package com.samsung.sr.nmt.t2t.translator.core.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LanguageDirectionState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirectionState;", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "AVAILABLE", "AVAILABLE_BY_PIVOT", "DOWNLOADABLE", "UNAUTHORIZED_RESOURCE", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguageDirectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LanguageDirectionState[] $VALUES;
    public static final LanguageDirectionState AVAILABLE = new LanguageDirectionState("AVAILABLE", 0);
    public static final LanguageDirectionState AVAILABLE_BY_PIVOT = new LanguageDirectionState("AVAILABLE_BY_PIVOT", 1);
    public static final LanguageDirectionState DOWNLOADABLE = new LanguageDirectionState("DOWNLOADABLE", 2);
    public static final LanguageDirectionState UNAUTHORIZED_RESOURCE = new LanguageDirectionState("UNAUTHORIZED_RESOURCE", 3);

    private static final /* synthetic */ LanguageDirectionState[] $values() {
        return new LanguageDirectionState[]{AVAILABLE, AVAILABLE_BY_PIVOT, DOWNLOADABLE, UNAUTHORIZED_RESOURCE};
    }

    public static EnumEntries<LanguageDirectionState> getEntries() {
        return $ENTRIES;
    }

    public static LanguageDirectionState valueOf(String str) {
        return (LanguageDirectionState) Enum.valueOf(LanguageDirectionState.class, str);
    }

    public static LanguageDirectionState[] values() {
        return (LanguageDirectionState[]) $VALUES.clone();
    }

    private LanguageDirectionState(String str, int i) {
    }

    static {
        LanguageDirectionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
