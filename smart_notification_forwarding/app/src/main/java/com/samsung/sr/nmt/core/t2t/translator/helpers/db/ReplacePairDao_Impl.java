package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ReplacePairDao_Impl implements ReplacePairDao {
    private final RoomDatabase __db;

    public ReplacePairDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.ReplacePairDao
    public Cursor find(final String sourceLanguage, final String targetLanguage) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM replacePairs WHERE (sourceLanguage = ? AND targetLanguage = ?)", 2);
        if (sourceLanguage == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, sourceLanguage);
        }
        if (targetLanguage == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, targetLanguage);
        }
        return this.__db.query(acquire);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
