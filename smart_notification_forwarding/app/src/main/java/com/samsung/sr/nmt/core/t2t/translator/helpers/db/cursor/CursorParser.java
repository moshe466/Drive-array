package com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: CursorParser.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0003\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;", "T", JsonProperty.USE_DEFAULT_NAME, "parse", "cursor", "Landroid/database/Cursor;", "indexOffset", JsonProperty.USE_DEFAULT_NAME, "(Landroid/database/Cursor;I)Ljava/lang/Object;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface CursorParser<T> {
    T parse(Cursor cursor, int indexOffset);

    /* compiled from: CursorParser.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object parse$default(CursorParser cursorParser, Cursor cursor, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parse");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return cursorParser.parse(cursor, i);
    }
}
