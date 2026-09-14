package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class CustomTranslationMemoryDao_Impl implements CustomTranslationMemoryDao {
    private final RoomDatabase __db;

    public CustomTranslationMemoryDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomTranslationMemoryDao
    public Cursor find(final String packageName, final String sourceLanguage, final String targetLanguage) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM translationMemories WHERE(packageName = ? AND (sourceLanguage = ? AND targetLanguage = ?) OR (targetLanguage = ? AND sourceLanguage = ?))", 5);
        if (packageName == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, packageName);
        }
        if (sourceLanguage == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, sourceLanguage);
        }
        if (targetLanguage == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, targetLanguage);
        }
        if (sourceLanguage == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, sourceLanguage);
        }
        if (targetLanguage == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, targetLanguage);
        }
        return this.__db.query(acquire);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
