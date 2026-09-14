package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: SwearWordRuleDao.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/SwearWordRuleDao;", JsonProperty.USE_DEFAULT_NAME, "findAll", "Landroid/database/Cursor;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface SwearWordRuleDao {
    Cursor findAll();
}
