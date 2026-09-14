package com.google.firebase.firestore.local;

import android.database.Cursor;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class SQLiteRemoteDocumentCache implements RemoteDocumentCache {
    private final SQLitePersistence db;
    private final LocalSerializer serializer;

    public SQLiteRemoteDocumentCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.concurrent.Executor] */
    public static /* synthetic */ void a(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, int i, BackgroundQueue backgroundQueue, Query query, ImmutableSortedMap[] immutableSortedMapArr, Cursor cursor) {
        if (EncodedPath.a(cursor.getString(0)).length() != i) {
            return;
        }
        byte[] blob = cursor.getBlob(1);
        BackgroundQueue backgroundQueue2 = backgroundQueue;
        if (cursor.isLast()) {
            backgroundQueue2 = Executors.DIRECT_EXECUTOR;
        }
        backgroundQueue2.execute(SQLiteRemoteDocumentCache$$Lambda$4.lambdaFactory$(sQLiteRemoteDocumentCache, blob, query, immutableSortedMapArr));
    }

    public static /* synthetic */ void a(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map, Cursor cursor) {
        MaybeDocument decodeMaybeDocument = sQLiteRemoteDocumentCache.decodeMaybeDocument(cursor.getBlob(0));
        map.put(decodeMaybeDocument.getKey(), decodeMaybeDocument);
    }

    public static /* synthetic */ void a(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, byte[] bArr, Query query, ImmutableSortedMap[] immutableSortedMapArr) {
        MaybeDocument decodeMaybeDocument = sQLiteRemoteDocumentCache.decodeMaybeDocument(bArr);
        if ((decodeMaybeDocument instanceof Document) && query.matches((Document) decodeMaybeDocument)) {
            synchronized (sQLiteRemoteDocumentCache) {
                immutableSortedMapArr[0] = immutableSortedMapArr[0].insert(decodeMaybeDocument.getKey(), (Document) decodeMaybeDocument);
            }
        }
    }

    public MaybeDocument decodeMaybeDocument(byte[] bArr) {
        try {
            return this.serializer.a(com.google.firebase.firestore.proto.MaybeDocument.parseFrom(bArr));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("MaybeDocument failed to parse: %s", e);
        }
    }

    private String pathForKey(DocumentKey documentKey) {
        return EncodedPath.a(documentKey.getPath());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void add(MaybeDocument maybeDocument, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        String pathForKey = pathForKey(maybeDocument.getKey());
        Timestamp timestamp = snapshotVersion.getTimestamp();
        this.db.a("INSERT OR REPLACE INTO remote_documents (path, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?)", pathForKey, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), this.serializer.a(maybeDocument).toByteArray());
        this.db.a().addToCollectionParentIndex(maybeDocument.getKey().getPath().popLast());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    @Nullable
    public MaybeDocument get(DocumentKey documentKey) {
        return (MaybeDocument) this.db.b("SELECT contents FROM remote_documents WHERE path = ?").a(pathForKey(documentKey)).a(SQLiteRemoteDocumentCache$$Lambda$1.lambdaFactory$(this));
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<DocumentKey> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(EncodedPath.a(it.next().getPath()));
        }
        HashMap hashMap = new HashMap();
        Iterator<DocumentKey> it2 = iterable.iterator();
        while (it2.hasNext()) {
            hashMap.put(it2.next(), null);
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT contents FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        while (longQuery.b()) {
            longQuery.c().b(SQLiteRemoteDocumentCache$$Lambda$2.lambdaFactory$(this, hashMap));
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ResourcePath path = query.getPath();
        int length = path.length() + 1;
        String a = EncodedPath.a(path);
        String b = EncodedPath.b(a);
        Timestamp timestamp = snapshotVersion.getTimestamp();
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        ImmutableSortedMap<DocumentKey, Document>[] immutableSortedMapArr = {DocumentCollections.emptyDocumentMap()};
        (snapshotVersion.equals(SnapshotVersion.NONE) ? this.db.b("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?").a(a, b) : this.db.b("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?AND (read_time_seconds > ? OR (read_time_seconds = ? AND read_time_nanos > ?))").a(a, b, Long.valueOf(timestamp.getSeconds()), Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()))).b(SQLiteRemoteDocumentCache$$Lambda$3.lambdaFactory$(this, length, backgroundQueue, query, immutableSortedMapArr));
        try {
            backgroundQueue.drain();
        } catch (InterruptedException e) {
            Assert.fail("Interrupted while deserializing documents", e);
        }
        return immutableSortedMapArr[0];
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void remove(DocumentKey documentKey) {
        this.db.a("DELETE FROM remote_documents WHERE path = ?", pathForKey(documentKey));
    }
}
