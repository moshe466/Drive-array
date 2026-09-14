package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class TranslationMemoryDao_Impl implements TranslationMemoryDao {
    private final RoomDatabase __db;

    public TranslationMemoryDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.TranslationMemoryDao
    public Cursor findAll() {
        return this.__db.query(RoomSQLiteQuery.acquire("SELECT * FROM translationMemories", 0));
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.TranslationMemoryDao
    public Cursor find(final String sourceLanguage, final String targetLanguage, final String sourceText) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM translationMemories WHERE (sourceLanguage = ? AND targetLanguage = ? AND sourceText = ?) LIMIT 1", 3);
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
        if (sourceText == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, sourceText);
        }
        return this.__db.query(acquire);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
