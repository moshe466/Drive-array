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
public final class CustomizationDataBase_Impl extends CustomizationDataBase {
    private volatile CustomReplacePairDao _customReplacePairDao;
    private volatile CustomSwearWordRuleDao _customSwearWordRuleDao;
    private volatile CustomTranslationMemoryDao _customTranslationMemoryDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) { // from class: com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomizationDataBase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `translationMemories` (`packageName` TEXT NOT NULL, `sourceLanguage` TEXT NOT NULL, `targetLanguage` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `targetText` TEXT NOT NULL, PRIMARY KEY(`packageName`, `sourceLanguage`, `targetLanguage`, `sourceText`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `swearWordRules` (`packageName` TEXT NOT NULL, `language` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `replaceTo` TEXT NOT NULL, `onlyWord` INTEGER NOT NULL, PRIMARY KEY(`packageName`, `language`, `sourceText`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `replacePairs` (`packageName` TEXT NOT NULL, `sourceLanguage` TEXT NOT NULL, `targetLanguage` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `targetTextBefore` TEXT NOT NULL, `targetTextAfter` TEXT NOT NULL, `isAllowedAsSubstring` INTEGER NOT NULL, PRIMARY KEY(`packageName`, `sourceLanguage`, `targetLanguage`, `sourceText`, `targetTextBefore`))");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '688f5364f73ce296ef4dbde70ab6b101')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `translationMemories`");
                _db.execSQL("DROP TABLE IF EXISTS `swearWordRules`");
                _db.execSQL("DROP TABLE IF EXISTS `replacePairs`");
                if (CustomizationDataBase_Impl.this.mCallbacks != null) {
                    int size = CustomizationDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) CustomizationDataBase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase _db) {
                if (CustomizationDataBase_Impl.this.mCallbacks != null) {
                    int size = CustomizationDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) CustomizationDataBase_Impl.this.mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                CustomizationDataBase_Impl.this.mDatabase = _db;
                CustomizationDataBase_Impl.this.internalInitInvalidationTracker(_db);
                if (CustomizationDataBase_Impl.this.mCallbacks != null) {
                    int size = CustomizationDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) CustomizationDataBase_Impl.this.mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap hashMap = new HashMap(5);
                hashMap.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                hashMap.put("sourceLanguage", new TableInfo.Column("sourceLanguage", "TEXT", true, 2, null, 1));
                hashMap.put("targetLanguage", new TableInfo.Column("targetLanguage", "TEXT", true, 3, null, 1));
                hashMap.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 4, null, 1));
                hashMap.put("targetText", new TableInfo.Column("targetText", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("translationMemories", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(_db, "translationMemories");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "translationMemories(com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomTranslationMemory).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                hashMap2.put("language", new TableInfo.Column("language", "TEXT", true, 2, null, 1));
                hashMap2.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 3, null, 1));
                hashMap2.put("replaceTo", new TableInfo.Column("replaceTo", "TEXT", true, 0, null, 1));
                hashMap2.put("onlyWord", new TableInfo.Column("onlyWord", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("swearWordRules", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(_db, "swearWordRules");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "swearWordRules(com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomSwearWordRule).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(7);
                hashMap3.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                hashMap3.put("sourceLanguage", new TableInfo.Column("sourceLanguage", "TEXT", true, 2, null, 1));
                hashMap3.put("targetLanguage", new TableInfo.Column("targetLanguage", "TEXT", true, 3, null, 1));
                hashMap3.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 4, null, 1));
                hashMap3.put("targetTextBefore", new TableInfo.Column("targetTextBefore", "TEXT", true, 5, null, 1));
                hashMap3.put("targetTextAfter", new TableInfo.Column("targetTextAfter", "TEXT", true, 0, null, 1));
                hashMap3.put("isAllowedAsSubstring", new TableInfo.Column("isAllowedAsSubstring", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("replacePairs", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(_db, "replacePairs");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "replacePairs(com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomReplacePairEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "688f5364f73ce296ef4dbde70ab6b101", "130faedece5918e455a2798191330742")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "translationMemories", "swearWordRules", "replacePairs");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `translationMemories`");
            writableDatabase.execSQL("DELETE FROM `swearWordRules`");
            writableDatabase.execSQL("DELETE FROM `replacePairs`");
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
        hashMap.put(CustomTranslationMemoryDao.class, CustomTranslationMemoryDao_Impl.getRequiredConverters());
        hashMap.put(CustomSwearWordRuleDao.class, CustomSwearWordRuleDao_Impl.getRequiredConverters());
        hashMap.put(CustomReplacePairDao.class, CustomReplacePairDao_Impl.getRequiredConverters());
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

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomizationDataBase
    public CustomTranslationMemoryDao getCustomTranslationMemoryDao() {
        CustomTranslationMemoryDao customTranslationMemoryDao;
        if (this._customTranslationMemoryDao != null) {
            return this._customTranslationMemoryDao;
        }
        synchronized (this) {
            if (this._customTranslationMemoryDao == null) {
                this._customTranslationMemoryDao = new CustomTranslationMemoryDao_Impl(this);
            }
            customTranslationMemoryDao = this._customTranslationMemoryDao;
        }
        return customTranslationMemoryDao;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomizationDataBase
    public CustomSwearWordRuleDao getCustomSwearWordRuleDao() {
        CustomSwearWordRuleDao customSwearWordRuleDao;
        if (this._customSwearWordRuleDao != null) {
            return this._customSwearWordRuleDao;
        }
        synchronized (this) {
            if (this._customSwearWordRuleDao == null) {
                this._customSwearWordRuleDao = new CustomSwearWordRuleDao_Impl(this);
            }
            customSwearWordRuleDao = this._customSwearWordRuleDao;
        }
        return customSwearWordRuleDao;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomizationDataBase
    public CustomReplacePairDao getCustomReplacePairDao() {
        CustomReplacePairDao customReplacePairDao;
        if (this._customReplacePairDao != null) {
            return this._customReplacePairDao;
        }
        synchronized (this) {
            if (this._customReplacePairDao == null) {
                this._customReplacePairDao = new CustomReplacePairDao_Impl(this);
            }
            customReplacePairDao = this._customReplacePairDao;
        }
        return customReplacePairDao;
    }
}
