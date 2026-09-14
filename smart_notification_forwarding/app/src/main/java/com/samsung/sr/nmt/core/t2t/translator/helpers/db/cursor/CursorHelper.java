package com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: CursorHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorHelper;", JsonProperty.USE_DEFAULT_NAME, "getCursor", "Landroid/database/Cursor;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "getCustomDBCursor", "packageName", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface CursorHelper {
    Cursor getCursor(String sourceLanguage, String targetLanguage);

    Cursor getCustomDBCursor(String sourceLanguage, String targetLanguage, String packageName);
}
