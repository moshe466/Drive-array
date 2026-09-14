package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SwearWordRuleDao_Impl implements SwearWordRuleDao {
    private final RoomDatabase __db;

    public SwearWordRuleDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.SwearWordRuleDao
    public Cursor findAll() {
        return this.__db.query(RoomSQLiteQuery.acquire("SELECT * FROM swearWordRules", 0));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
