package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class TranslationMemoryDataBase_Impl extends TranslationMemoryDataBase {
    private volatile SwearWordRuleDao _swearWordRuleDao;
    private volatile TranslationMemoryDao _translationMemoryDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) { // from class: com.samsung.sr.nmt.core.t2t.translator.helpers.db.TranslationMemoryDataBase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `translationMemories` (`sourceLanguage` TEXT NOT NULL, `targetLanguage` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `targetText` TEXT NOT NULL, PRIMARY KEY(`sourceLanguage`, `targetLanguage`, `sourceText`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `swearWordRules` (`language` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `replaceTo` TEXT NOT NULL, `onlyWord` INTEGER NOT NULL, PRIMARY KEY(`language`, `sourceText`))");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5a305ed09cf9cbc23a418050d23b0a26')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `translationMemories`");
                _db.execSQL("DROP TABLE IF EXISTS `swearWordRules`");
                if (TranslationMemoryDataBase_Impl.this.mCallbacks != null) {
                    int size = TranslationMemoryDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TranslationMemoryDataBase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase _db) {
                if (TranslationMemoryDataBase_Impl.this.mCallbacks != null) {
                    int size = TranslationMemoryDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TranslationMemoryDataBase_Impl.this.mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                TranslationMemoryDataBase_Impl.this.mDatabase = _db;
                TranslationMemoryDataBase_Impl.this.internalInitInvalidationTracker(_db);
                if (TranslationMemoryDataBase_Impl.this.mCallbacks != null) {
                    int size = TranslationMemoryDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TranslationMemoryDataBase_Impl.this.mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("sourceLanguage", new TableInfo.Column("sourceLanguage", "TEXT", true, 1, null, 1));
                hashMap.put("targetLanguage", new TableInfo.Column("targetLanguage", "TEXT", true, 2, null, 1));
                hashMap.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 3, null, 1));
                hashMap.put("targetText", new TableInfo.Column("targetText", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("translationMemories", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(_db, "translationMemories");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "translationMemories(com.samsung.sr.nmt.core.t2t.translator.helpers.db.TranslationMemory).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("language", new TableInfo.Column("language", "TEXT", true, 1, null, 1));
                hashMap2.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 2, null, 1));
                hashMap2.put("replaceTo", new TableInfo.Column("replaceTo", "TEXT", true, 0, null, 1));
                hashMap2.put("onlyWord", new TableInfo.Column("onlyWord", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("swearWordRules", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(_db, "swearWordRules");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "swearWordRules(com.samsung.sr.nmt.core.t2t.translator.helpers.db.SwearWordRuleEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "5a305ed09cf9cbc23a418050d23b0a26", "7aff77442209931e2af48d628063b93c")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "translationMemories", "swearWordRules");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `translationMemories`");
            writableDatabase.execSQL("DELETE FROM `swearWordRules`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TranslationMemoryDao.class, TranslationMemoryDao_Impl.getRequiredConverters());
        hashMap.put(SwearWordRuleDao.class, SwearWordRuleDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.TranslationMemoryDataBase
    public TranslationMemoryDao getTranslationMemoryDao() {
        TranslationMemoryDao translationMemoryDao;
        if (this._translationMemoryDao != null) {
            return this._translationMemoryDao;
        }
        synchronized (this) {
            if (this._translationMemoryDao == null) {
                this._translationMemoryDao = new TranslationMemoryDao_Impl(this);
            }
            translationMemoryDao = this._translationMemoryDao;
        }
        return translationMemoryDao;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.TranslationMemoryDataBase
    public SwearWordRuleDao getSwearWordRuleDao() {
        SwearWordRuleDao swearWordRuleDao;
        if (this._swearWordRuleDao != null) {
            return this._swearWordRuleDao;
        }
        synchronized (this) {
            if (this._swearWordRuleDao == null) {
                this._swearWordRuleDao = new SwearWordRuleDao_Impl(this);
            }
            swearWordRuleDao = this._swearWordRuleDao;
        }
        return swearWordRuleDao;
    }
}
