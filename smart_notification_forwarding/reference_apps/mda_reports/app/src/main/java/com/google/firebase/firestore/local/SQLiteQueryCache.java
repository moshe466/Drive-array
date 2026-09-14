package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class SQLiteQueryCache implements QueryCache {
    private final SQLitePersistence db;
    private int highestTargetId;
    private long lastListenSequenceNumber;
    private SnapshotVersion lastRemoteSnapshotVersion = SnapshotVersion.NONE;
    private final LocalSerializer localSerializer;
    private long targetCount;

    /* loaded from: classes2.dex */
    public static class DocumentKeysHolder {
        ImmutableSortedSet<DocumentKey> a;

        private DocumentKeysHolder() {
            this.a = DocumentKey.emptyKeySet();
        }

        /* synthetic */ DocumentKeysHolder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class QueryDataHolder {
        QueryData a;

        private QueryDataHolder() {
        }

        /* synthetic */ QueryDataHolder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public SQLiteQueryCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.db = sQLitePersistence;
        this.localSerializer = localSerializer;
    }

    public static /* synthetic */ void a(SQLiteQueryCache sQLiteQueryCache, Cursor cursor) {
        sQLiteQueryCache.highestTargetId = cursor.getInt(0);
        sQLiteQueryCache.lastListenSequenceNumber = cursor.getInt(1);
        sQLiteQueryCache.lastRemoteSnapshotVersion = new SnapshotVersion(new Timestamp(cursor.getLong(2), cursor.getInt(3)));
        sQLiteQueryCache.targetCount = cursor.getLong(4);
    }

    public static /* synthetic */ void a(SQLiteQueryCache sQLiteQueryCache, SparseArray sparseArray, int[] iArr, Cursor cursor) {
        int i = cursor.getInt(0);
        if (sparseArray.get(i) == null) {
            sQLiteQueryCache.removeTarget(i);
            iArr[0] = iArr[0] + 1;
        }
    }

    public static /* synthetic */ void a(SQLiteQueryCache sQLiteQueryCache, Target target, QueryDataHolder queryDataHolder, Cursor cursor) {
        QueryData decodeQueryData = sQLiteQueryCache.decodeQueryData(cursor.getBlob(0));
        if (target.equals(decodeQueryData.getTarget())) {
            queryDataHolder.a = decodeQueryData;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QueryData decodeQueryData(byte[] bArr) {
        try {
            return this.localSerializer.a(com.google.firebase.firestore.proto.Target.parseFrom(bArr));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("QueryData failed to parse: %s", e);
        }
    }

    private void removeMatchingKeysForTargetId(int i) {
        this.db.a("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i));
    }

    private void removeTarget(int i) {
        removeMatchingKeysForTargetId(i);
        this.db.a("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i));
        this.targetCount--;
    }

    private void saveQueryData(QueryData queryData) {
        int targetId = queryData.getTargetId();
        String canonicalId = queryData.getTarget().getCanonicalId();
        Timestamp timestamp = queryData.getSnapshotVersion().getTimestamp();
        this.db.a("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(targetId), canonicalId, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), queryData.getResumeToken().toByteArray(), Long.valueOf(queryData.getSequenceNumber()), this.localSerializer.a(queryData).toByteArray());
    }

    private boolean updateMetadata(QueryData queryData) {
        boolean z;
        if (queryData.getTargetId() > this.highestTargetId) {
            this.highestTargetId = queryData.getTargetId();
            z = true;
        } else {
            z = false;
        }
        if (queryData.getSequenceNumber() <= this.lastListenSequenceNumber) {
            return z;
        }
        this.lastListenSequenceNumber = queryData.getSequenceNumber();
        return true;
    }

    private void writeMetadata() {
        this.db.a("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.highestTargetId), Long.valueOf(this.lastListenSequenceNumber), Long.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getSeconds()), Integer.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getNanoseconds()), Long.valueOf(this.targetCount));
    }

    public int a(long j, SparseArray<?> sparseArray) {
        int[] iArr = new int[1];
        this.db.b("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").a(Long.valueOf(j)).b(SQLiteQueryCache$$Lambda$3.lambdaFactory$(this, sparseArray, iArr));
        writeMetadata();
        return iArr[0];
    }

    public void a() {
        Assert.hardAssert(this.db.b("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").a(SQLiteQueryCache$$Lambda$1.lambdaFactory$(this)) == 1, "Missing target_globals entry", new Object[0]);
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        SQLiteStatement a = this.db.a("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        SQLiteLruReferenceDelegate referenceDelegate = this.db.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            this.db.a(a, Integer.valueOf(i), EncodedPath.a(next.getPath()));
            referenceDelegate.addReference(next);
        }
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void addQueryData(QueryData queryData) {
        saveQueryData(queryData);
        updateMetadata(queryData);
        this.targetCount++;
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public boolean containsKey(DocumentKey documentKey) {
        return !this.db.b("SELECT target_id FROM target_documents WHERE path = ? AND target_id != 0 LIMIT 1").a(EncodedPath.a(documentKey.getPath())).a();
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void forEachTarget(Consumer<QueryData> consumer) {
        this.db.b("SELECT target_proto FROM targets").b(SQLiteQueryCache$$Lambda$2.lambdaFactory$(this, consumer));
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public long getHighestListenSequenceNumber() {
        return this.lastListenSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public int getHighestTargetId() {
        return this.highestTargetId;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i) {
        DocumentKeysHolder documentKeysHolder = new DocumentKeysHolder();
        this.db.b("SELECT path FROM target_documents WHERE target_id = ?").a(Integer.valueOf(i)).b(SQLiteQueryCache$$Lambda$5.lambdaFactory$(documentKeysHolder));
        return documentKeysHolder.a;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    @Nullable
    public QueryData getQueryData(Target target) {
        String canonicalId = target.getCanonicalId();
        QueryDataHolder queryDataHolder = new QueryDataHolder();
        this.db.b("SELECT target_proto FROM targets WHERE canonical_id = ?").a(canonicalId).b(SQLiteQueryCache$$Lambda$4.lambdaFactory$(this, target, queryDataHolder));
        return queryDataHolder.a;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public long getTargetCount() {
        return this.targetCount;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        SQLiteStatement a = this.db.a("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        SQLiteLruReferenceDelegate referenceDelegate = this.db.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            this.db.a(a, Integer.valueOf(i), EncodedPath.a(next.getPath()));
            referenceDelegate.removeReference(next);
        }
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void removeQueryData(QueryData queryData) {
        removeTarget(queryData.getTargetId());
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion) {
        this.lastRemoteSnapshotVersion = snapshotVersion;
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void updateQueryData(QueryData queryData) {
        saveQueryData(queryData);
        if (updateMetadata(queryData)) {
            writeMetadata();
        }
    }
}
