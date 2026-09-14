package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class CustomSwearWordRuleDao_Impl implements CustomSwearWordRuleDao {
    private final RoomDatabase __db;

    public CustomSwearWordRuleDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomSwearWordRuleDao
    public Cursor findAll(final String packageName) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM swearWordRules WHERE (packageName = ?)", 1);
        if (packageName == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, packageName);
        }
        return this.__db.query(acquire);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
