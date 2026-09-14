package com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordRule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: SwearWordRuleCursorParser.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \n2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", "()V", "parse", "cursor", "Landroid/database/Cursor;", "indexOffset", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwearWordRuleCursorParser implements CursorParser<List<? extends SwearWordRule>> {
    private static final int RULE_LANGUAGE_INDEX = 0;
    private static final int RULE_ONLY_WORD_INDEX = 3;
    private static final int RULE_REPLACE_TO_INDEX = 2;
    private static final int RULE_SOURCE_TEXT_INDEX = 1;

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser
    public List<? extends SwearWordRule> parse(Cursor cursor, int indexOffset) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            Cursor cursor2 = cursor;
            try {
                Cursor cursor3 = cursor2;
                cursor3.moveToFirst();
                int count = cursor.getCount();
                for (int i = 0; i < count; i++) {
                    String string = cursor3.getString(indexOffset + 0);
                    String string2 = cursor3.getString(indexOffset + 1);
                    String string3 = cursor3.getString(indexOffset + 2);
                    boolean z = true;
                    if (cursor3.getInt(indexOffset + 3) != 1) {
                        z = false;
                    }
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    Intrinsics.checkNotNull(string3);
                    arrayList.add(new SwearWordRule(string, string2, z, string3));
                    cursor.moveToNext();
                }
                Timber.d(cursor.getCount() + " Rules are loaded", new Object[0]);
                CloseableKt.closeFinally(cursor2, null);
            } finally {
            }
        }
        return arrayList;
    }
}
