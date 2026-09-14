package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class SQLiteMutationQueue implements MutationQueue {
    private static final int BLOB_MAX_INLINE_LENGTH = 1000000;
    private final SQLitePersistence db;
    private ByteString lastStreamToken;
    private int nextBatchId;
    private final LocalSerializer serializer;
    private final String uid;

    /* loaded from: classes2.dex */
    public static class BlobAccumulator implements Consumer<Cursor> {
        private final ArrayList<ByteString> chunks = new ArrayList<>();
        private boolean more = true;

        BlobAccumulator(byte[] bArr) {
            addChunk(bArr);
        }

        private void addChunk(byte[] bArr) {
            this.chunks.add(ByteString.copyFrom(bArr));
        }

        int a() {
            return this.chunks.size();
        }

        @Override // com.google.firebase.firestore.util.Consumer
        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            addChunk(blob);
            if (blob.length < SQLiteMutationQueue.BLOB_MAX_INLINE_LENGTH) {
                this.more = false;
            }
        }

        ByteString b() {
            return ByteString.copyFrom(this.chunks);
        }
    }

    public SQLiteMutationQueue(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
        this.uid = user.isAuthenticated() ? user.getUid() : "";
        this.lastStreamToken = WriteStream.EMPTY_STREAM_TOKEN;
    }

    public static /* synthetic */ Integer a(Cursor cursor) {
        return Integer.valueOf(cursor.getInt(0));
    }

    public static /* synthetic */ void a(SQLiteMutationQueue sQLiteMutationQueue, List list, int i, Cursor cursor) {
        int i2 = cursor.getInt(0);
        int size = list.size();
        if ((size <= 0 || i2 != ((MutationBatch) list.get(size - 1)).getBatchId()) && EncodedPath.a(cursor.getString(1)).length() == i) {
            list.add(sQLiteMutationQueue.decodeInlineMutationBatch(i2, cursor.getBlob(2)));
        }
    }

    public static /* synthetic */ void a(SQLiteMutationQueue sQLiteMutationQueue, Set set, List list, Cursor cursor) {
        int i = cursor.getInt(0);
        if (set.contains(Integer.valueOf(i))) {
            return;
        }
        set.add(Integer.valueOf(i));
        list.add(sQLiteMutationQueue.decodeInlineMutationBatch(i, cursor.getBlob(1)));
    }

    public static /* synthetic */ void a(List list, Cursor cursor) {
        list.add(cursor.getString(0));
    }

    public static /* synthetic */ void b(SQLiteMutationQueue sQLiteMutationQueue, Cursor cursor) {
        sQLiteMutationQueue.nextBatchId = Math.max(sQLiteMutationQueue.nextBatchId, cursor.getInt(0));
    }

    public static /* synthetic */ void b(List list, Cursor cursor) {
        list.add(EncodedPath.a(cursor.getString(0)));
    }

    public MutationBatch decodeInlineMutationBatch(int i, byte[] bArr) {
        try {
            if (bArr.length < BLOB_MAX_INLINE_LENGTH) {
                return this.serializer.a(WriteBatch.parseFrom(bArr));
            }
            BlobAccumulator blobAccumulator = new BlobAccumulator(bArr);
            while (blobAccumulator.more) {
                this.db.b("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").a(Integer.valueOf((blobAccumulator.a() * BLOB_MAX_INLINE_LENGTH) + 1), Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i)).a(blobAccumulator);
            }
            return this.serializer.a(WriteBatch.parseFrom(blobAccumulator.b()));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("MutationBatch failed to parse: %s", e);
        }
    }

    private void loadNextBatchIdAcrossAllUsers() {
        ArrayList arrayList = new ArrayList();
        this.db.b("SELECT uid FROM mutation_queues").b(SQLiteMutationQueue$$Lambda$2.lambdaFactory$(arrayList));
        this.nextBatchId = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.db.b("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").a((String) it.next()).b(SQLiteMutationQueue$$Lambda$3.lambdaFactory$(this));
        }
        this.nextBatchId++;
    }

    private void writeMutationQueueMetadata() {
        this.db.a("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.uid, -1, this.lastStreamToken.toByteArray());
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void acknowledgeBatch(MutationBatch mutationBatch, ByteString byteString) {
        this.lastStreamToken = (ByteString) Preconditions.checkNotNull(byteString);
        writeMutationQueueMetadata();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        int i = this.nextBatchId;
        this.nextBatchId = i + 1;
        MutationBatch mutationBatch = new MutationBatch(i, timestamp, list, list2);
        this.db.a("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.uid, Integer.valueOf(i), this.serializer.a(mutationBatch).toByteArray());
        HashSet hashSet = new HashSet();
        SQLiteStatement a = this.db.a("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        Iterator<Mutation> it = list2.iterator();
        while (it.hasNext()) {
            DocumentKey key = it.next().getKey();
            if (hashSet.add(key)) {
                this.db.a(a, this.uid, EncodedPath.a(key.getPath()), Integer.valueOf(i));
                this.db.a().addToCollectionParentIndex(key.getPath().popLast());
            }
        }
        return mutationBatch;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatches() {
        ArrayList arrayList = new ArrayList();
        this.db.b("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").a(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid).b(SQLiteMutationQueue$$Lambda$7.lambdaFactory$(this, arrayList));
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey) {
        String a = EncodedPath.a(documentKey.getPath());
        ArrayList arrayList = new ArrayList();
        this.db.b("SELECT m.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path = ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").a(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, a).b(SQLiteMutationQueue$$Lambda$8.lambdaFactory$(this, arrayList));
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable) {
        Comparator comparator;
        ArrayList arrayList = new ArrayList();
        Iterator<DocumentKey> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(EncodedPath.a(it.next().getPath()));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        while (longQuery.b()) {
            longQuery.c().b(SQLiteMutationQueue$$Lambda$9.lambdaFactory$(this, hashSet, arrayList2));
        }
        if (longQuery.a() > 1) {
            comparator = SQLiteMutationQueue$$Lambda$10.instance;
            Collections.sort(arrayList2, comparator);
        }
        return arrayList2;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ResourcePath path = query.getPath();
        int length = path.length() + 1;
        String a = EncodedPath.a(path);
        String b = EncodedPath.b(a);
        ArrayList arrayList = new ArrayList();
        this.db.b("SELECT dm.batch_id, dm.path, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path >= ? AND dm.path < ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").a(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, a, b).b(SQLiteMutationQueue$$Lambda$11.lambdaFactory$(this, arrayList, length));
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public int getHighestUnacknowledgedBatchId() {
        return ((Integer) this.db.b("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").a(-1, this.uid).a(SQLiteMutationQueue$$Lambda$6.instance)).intValue();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public ByteString getLastStreamToken() {
        return this.lastStreamToken;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    @Nullable
    public MutationBatch getNextMutationBatchAfterBatchId(int i) {
        return (MutationBatch) this.db.b("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").a(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i + 1)).a(SQLiteMutationQueue$$Lambda$5.lambdaFactory$(this));
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public boolean isEmpty() {
        return this.db.b("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").a(this.uid).a();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    @Nullable
    public MutationBatch lookupMutationBatch(int i) {
        return (MutationBatch) this.db.b("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").a(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i)).a(SQLiteMutationQueue$$Lambda$4.lambdaFactory$(this, i));
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void performConsistencyCheck() {
        if (isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.db.b("SELECT path FROM document_mutations WHERE uid = ?").a(this.uid).b(SQLiteMutationQueue$$Lambda$12.lambdaFactory$(arrayList));
            Assert.hardAssert(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void removeMutationBatch(MutationBatch mutationBatch) {
        SQLiteStatement a = this.db.a("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement a2 = this.db.a("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int batchId = mutationBatch.getBatchId();
        Assert.hardAssert(this.db.a(a, this.uid, Integer.valueOf(batchId)) != 0, "Mutation batch (%s, %d) did not exist", this.uid, Integer.valueOf(mutationBatch.getBatchId()));
        Iterator<Mutation> it = mutationBatch.getMutations().iterator();
        while (it.hasNext()) {
            DocumentKey key = it.next().getKey();
            this.db.a(a2, this.uid, EncodedPath.a(key.getPath()), Integer.valueOf(batchId));
            this.db.getReferenceDelegate().removeMutationReference(key);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void setLastStreamToken(ByteString byteString) {
        this.lastStreamToken = (ByteString) Preconditions.checkNotNull(byteString);
        writeMutationQueueMetadata();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void start() {
        loadNextBatchIdAcrossAllUsers();
        if (this.db.b("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").a(this.uid).a(SQLiteMutationQueue$$Lambda$1.lambdaFactory$(this)) == 0) {
            writeMutationQueueMetadata();
        }
    }
}
