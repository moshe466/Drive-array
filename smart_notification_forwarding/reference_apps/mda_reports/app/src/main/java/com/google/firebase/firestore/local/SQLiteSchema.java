package com.google.firebase.firestore.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SQLiteSchema {
    private static final int SEQUENCE_NUMBER_BATCH_SIZE = 100;
    private final SQLiteDatabase db;

    public SQLiteSchema(SQLiteDatabase sQLiteDatabase) {
        this.db = sQLiteDatabase;
    }

    public static /* synthetic */ void a(MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex, SQLiteStatement sQLiteStatement, ResourcePath resourcePath) {
        if (memoryCollectionParentIndex.a(resourcePath)) {
            String lastSegment = resourcePath.getLastSegment();
            ResourcePath popLast = resourcePath.popLast();
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, lastSegment);
            sQLiteStatement.bindString(2, EncodedPath.a(popLast));
            sQLiteStatement.execute();
        }
    }

    public static /* synthetic */ void a(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE collection_index (uid TEXT, collection_path TEXT, field_path TEXT, field_value_type INTEGER, field_value_1, field_value_2, document_id TEXT, PRIMARY KEY (uid, collection_path, field_path, field_value_type, field_value_1, field_value_2, document_id))");
    }

    public static /* synthetic */ void a(SQLiteSchema sQLiteSchema, Cursor cursor) {
        int i = cursor.getInt(0);
        try {
            sQLiteSchema.db.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{Target.parseFrom(cursor.getBlob(1)).toBuilder().clearLastLimboFreeSnapshotVersion().build().toByteArray(), Integer.valueOf(i)});
        } catch (InvalidProtocolBufferException unused) {
            throw Assert.fail("Failed to decode Query data for target %s", Integer.valueOf(i));
        }
    }

    public static /* synthetic */ void a(boolean[] zArr, SQLiteStatement sQLiteStatement, long j, Cursor cursor) {
        zArr[0] = true;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, cursor.getString(0));
        sQLiteStatement.bindLong(2, j);
        Assert.hardAssert(sQLiteStatement.executeInsert() != -1, "Failed to insert a sentinel row", new Object[0]);
    }

    private void addReadTime() {
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    private void addSequenceNumber() {
        if (tableContainsColumn("target_documents", "sequence_number")) {
            return;
        }
        this.db.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
    }

    private void addTargetCount() {
        if (!tableContainsColumn("target_globals", "target_count")) {
            this.db.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long queryNumEntries = DatabaseUtils.queryNumEntries(this.db, "targets");
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_count", Long.valueOf(queryNumEntries));
        this.db.update("target_globals", contentValues, null, null);
    }

    public static /* synthetic */ void b(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        sQLiteSchema.db.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        sQLiteSchema.db.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    public static /* synthetic */ void b(SQLiteSchema sQLiteSchema, Cursor cursor) {
        String string = cursor.getString(0);
        new SQLitePersistence.Query(sQLiteSchema.db, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").a(string, Long.valueOf(cursor.getLong(1))).b(SQLiteSchema$$Lambda$13.lambdaFactory$(sQLiteSchema, string));
    }

    public static /* synthetic */ void c(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        sQLiteSchema.db.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        sQLiteSchema.db.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        sQLiteSchema.db.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        sQLiteSchema.db.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    private void createLocalDocumentsCollectionIndex() {
        ifTablesDontExist(new String[]{"collection_index"}, SQLiteSchema$$Lambda$5.lambdaFactory$(this));
    }

    private void createV1MutationQueue() {
        ifTablesDontExist(new String[]{"mutation_queues", "mutations", "document_mutations"}, SQLiteSchema$$Lambda$1.lambdaFactory$(this));
    }

    private void createV1QueryCache() {
        ifTablesDontExist(new String[]{"targets", "target_globals", "target_documents"}, SQLiteSchema$$Lambda$3.lambdaFactory$(this));
    }

    private void createV1RemoteDocumentCache() {
        ifTablesDontExist(new String[]{"remote_documents"}, SQLiteSchema$$Lambda$4.lambdaFactory$(this));
    }

    private void createV8CollectionParentsIndex() {
        ifTablesDontExist(new String[]{"collection_parents"}, SQLiteSchema$$Lambda$9.lambdaFactory$(this));
        Consumer lambdaFactory$ = SQLiteSchema$$Lambda$10.lambdaFactory$(new MemoryIndexManager.MemoryCollectionParentIndex(), this.db.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)"));
        new SQLitePersistence.Query(this.db, "SELECT path FROM remote_documents").b(SQLiteSchema$$Lambda$11.lambdaFactory$(lambdaFactory$));
        new SQLitePersistence.Query(this.db, "SELECT path FROM document_mutations").b(SQLiteSchema$$Lambda$12.lambdaFactory$(lambdaFactory$));
    }

    public static /* synthetic */ void d(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
    }

    private void dropLastLimboFreeSnapshotVersion() {
        new SQLitePersistence.Query(this.db, "SELECT target_id, target_proto FROM targets").b(SQLiteSchema$$Lambda$6.lambdaFactory$(this));
    }

    private void dropV1QueryCache() {
        if (tableExists("targets")) {
            this.db.execSQL("DROP TABLE targets");
        }
        if (tableExists("target_globals")) {
            this.db.execSQL("DROP TABLE target_globals");
        }
        if (tableExists("target_documents")) {
            this.db.execSQL("DROP TABLE target_documents");
        }
    }

    public static /* synthetic */ void e(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }

    private void ensureSequenceNumbers() {
        Function function;
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1");
        function = SQLiteSchema$$Lambda$7.instance;
        Long l = (Long) query.a(function);
        Assert.hardAssert(l != null, "Missing highest sequence number", new Object[0]);
        long longValue = l.longValue();
        SQLiteStatement compileStatement = this.db.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        SQLitePersistence.Query a = new SQLitePersistence.Query(this.db, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").a(100);
        boolean[] zArr = new boolean[1];
        do {
            zArr[0] = false;
            a.b(SQLiteSchema$$Lambda$8.lambdaFactory$(zArr, compileStatement, longValue));
        } while (zArr[0]);
    }

    private void ensureTargetGlobal() {
        if (DatabaseUtils.queryNumEntries(this.db, "target_globals") == 1) {
            return;
        }
        this.db.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
    }

    private boolean hasReadTime() {
        boolean tableContainsColumn = tableContainsColumn("remote_documents", "read_time_seconds");
        boolean tableContainsColumn2 = tableContainsColumn("remote_documents", "read_time_nanos");
        Assert.hardAssert(tableContainsColumn == tableContainsColumn2, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
        return tableContainsColumn && tableContainsColumn2;
    }

    private void ifTablesDontExist(String[] strArr, Runnable runnable) {
        StringBuilder sb;
        String str;
        String str2 = "[" + TextUtils.join(", ", strArr) + "]";
        boolean z = false;
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            boolean tableExists = tableExists(str3);
            if (i == 0) {
                z = tableExists;
            } else if (tableExists != z) {
                String str4 = "Expected all of " + str2 + " to either exist or not, but ";
                if (z) {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(strArr[0]);
                    sb.append(" exists and ");
                    sb.append(str3);
                    str = " does not";
                } else {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(strArr[0]);
                    sb.append(" does not exist and ");
                    sb.append(str3);
                    str = " does";
                }
                sb.append(str);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (!z) {
            runnable.run();
            return;
        }
        Log.d("SQLiteSchema", "Skipping migration because all of " + str2 + " already exist");
    }

    private void removeAcknowledgedMutations() {
        new SQLitePersistence.Query(this.db, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").b(SQLiteSchema$$Lambda$2.lambdaFactory$(this));
    }

    public void removeMutationBatch(String str, int i) {
        SQLiteStatement compileStatement = this.db.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        compileStatement.bindString(1, str);
        compileStatement.bindLong(2, i);
        Assert.hardAssert(compileStatement.executeUpdateDelete() != 0, "Mutatiohn batch (%s, %d) did not exist", str, Integer.valueOf(i));
        this.db.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{str, Integer.valueOf(i)});
    }

    private boolean tableContainsColumn(String str, String str2) {
        return a(str).indexOf(str2) != -1;
    }

    private boolean tableExists(String str) {
        return !new SQLitePersistence.Query(this.db, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").a(str).a();
    }

    @VisibleForTesting
    List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.db.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = cursor.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(columnIndex));
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void a(int i) {
        a(i, 10);
    }

    void a(int i, int i2) {
        if (i < 1 && i2 >= 1) {
            createV1MutationQueue();
            createV1QueryCache();
            createV1RemoteDocumentCache();
        }
        if (i < 3 && i2 >= 3 && i != 0) {
            dropV1QueryCache();
            createV1QueryCache();
        }
        if (i < 4 && i2 >= 4) {
            ensureTargetGlobal();
            addTargetCount();
        }
        if (i < 5 && i2 >= 5) {
            addSequenceNumber();
        }
        if (i < 6 && i2 >= 6) {
            removeAcknowledgedMutations();
        }
        if (i < 7 && i2 >= 7) {
            ensureSequenceNumbers();
        }
        if (i < 8 && i2 >= 8) {
            createV8CollectionParentsIndex();
        }
        if (i < 9 && i2 >= 9) {
            if (hasReadTime()) {
                dropLastLimboFreeSnapshotVersion();
            } else {
                addReadTime();
            }
        }
        if (i == 9 && i2 >= 10) {
            dropLastLimboFreeSnapshotVersion();
        }
        if (i >= 11 || i2 < 11) {
            return;
        }
        Preconditions.checkState(Persistence.INDEXING_SUPPORT_ENABLED);
        createLocalDocumentsCollectionIndex();
    }
}
