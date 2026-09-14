package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: TranslationMemoryDao.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'J\b\u0010\b\u001a\u00020\u0003H'¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/TranslationMemoryDao;", JsonProperty.USE_DEFAULT_NAME, "find", "Landroid/database/Cursor;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "sourceText", "findAll", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface TranslationMemoryDao {
    Cursor find(String sourceLanguage, String targetLanguage, String sourceText);

    Cursor findAll();
}
