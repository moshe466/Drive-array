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
public final class ReplacePairDataBase_Impl extends ReplacePairDataBase {
    private volatile ReplacePairDao _replacePairDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) { // from class: com.samsung.sr.nmt.core.t2t.translator.helpers.db.ReplacePairDataBase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `replacePairs` (`id` INTEGER NOT NULL, `sourceLanguage` TEXT NOT NULL, `targetLanguage` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `targetTextBefore` TEXT NOT NULL, `targetTextAfter` TEXT NOT NULL, `isAllowedAsSubstring` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a3221f3c102972411baf4052937236b4')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `replacePairs`");
                if (ReplacePairDataBase_Impl.this.mCallbacks != null) {
                    int size = ReplacePairDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ReplacePairDataBase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase _db) {
                if (ReplacePairDataBase_Impl.this.mCallbacks != null) {
                    int size = ReplacePairDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ReplacePairDataBase_Impl.this.mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                ReplacePairDataBase_Impl.this.mDatabase = _db;
                ReplacePairDataBase_Impl.this.internalInitInvalidationTracker(_db);
                if (ReplacePairDataBase_Impl.this.mCallbacks != null) {
                    int size = ReplacePairDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ReplacePairDataBase_Impl.this.mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap hashMap = new HashMap(7);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap.put("sourceLanguage", new TableInfo.Column("sourceLanguage", "TEXT", true, 0, null, 1));
                hashMap.put("targetLanguage", new TableInfo.Column("targetLanguage", "TEXT", true, 0, null, 1));
                hashMap.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 0, null, 1));
                hashMap.put("targetTextBefore", new TableInfo.Column("targetTextBefore", "TEXT", true, 0, null, 1));
                hashMap.put("targetTextAfter", new TableInfo.Column("targetTextAfter", "TEXT", true, 0, null, 1));
                hashMap.put("isAllowedAsSubstring", new TableInfo.Column("isAllowedAsSubstring", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("replacePairs", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(_db, "replacePairs");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "replacePairs(com.samsung.sr.nmt.core.t2t.translator.helpers.db.ReplacePairEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "a3221f3c102972411baf4052937236b4", "4ea109b0107aca346da3bd1a2dbf6505")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "replacePairs");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
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
        hashMap.put(ReplacePairDao.class, ReplacePairDao_Impl.getRequiredConverters());
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

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.ReplacePairDataBase
    public ReplacePairDao getReplacePairDao() {
        ReplacePairDao replacePairDao;
        if (this._replacePairDao != null) {
            return this._replacePairDao;
        }
        synchronized (this) {
            if (this._replacePairDao == null) {
                this._replacePairDao = new ReplacePairDao_Impl(this);
            }
            replacePairDao = this._replacePairDao;
        }
        return replacePairDao;
    }
}
