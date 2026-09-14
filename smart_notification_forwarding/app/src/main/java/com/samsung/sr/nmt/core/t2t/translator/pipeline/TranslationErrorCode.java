package com.samsung.sr.nmt.core.t2t.translator.pipeline;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TranslationErrorCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationErrorCode;", JsonProperty.USE_DEFAULT_NAME, "code", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;II)V", "getCode", "()I", "NONE", "INTERRUPTED", "COMPUTATION_ERROR", "RESOURCE_ACCESS_ERROR", "ILLEGAL_RESOURCE_ERROR", "UNAUTHORIZED_RESOURCE_ERROR", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TranslationErrorCode[] $VALUES;
    private final int code;
    public static final TranslationErrorCode NONE = new TranslationErrorCode("NONE", 0, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    public static final TranslationErrorCode INTERRUPTED = new TranslationErrorCode("INTERRUPTED", 1, 300);
    public static final TranslationErrorCode COMPUTATION_ERROR = new TranslationErrorCode("COMPUTATION_ERROR", 2, 400);
    public static final TranslationErrorCode RESOURCE_ACCESS_ERROR = new TranslationErrorCode("RESOURCE_ACCESS_ERROR", 3, 500);
    public static final TranslationErrorCode ILLEGAL_RESOURCE_ERROR = new TranslationErrorCode("ILLEGAL_RESOURCE_ERROR", 4, 501);
    public static final TranslationErrorCode UNAUTHORIZED_RESOURCE_ERROR = new TranslationErrorCode("UNAUTHORIZED_RESOURCE_ERROR", 5, 502);

    private static final /* synthetic */ TranslationErrorCode[] $values() {
        return new TranslationErrorCode[]{NONE, INTERRUPTED, COMPUTATION_ERROR, RESOURCE_ACCESS_ERROR, ILLEGAL_RESOURCE_ERROR, UNAUTHORIZED_RESOURCE_ERROR};
    }

    public static EnumEntries<TranslationErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static TranslationErrorCode valueOf(String value) {
        return (TranslationErrorCode) Enum.valueOf(TranslationErrorCode.class, value);
    }

    public static TranslationErrorCode[] values() {
        return (TranslationErrorCode[]) $VALUES.clone();
    }

    private TranslationErrorCode(String $enum$name, int $enum$ordinal, int code) {
        this.code = code;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        TranslationErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
