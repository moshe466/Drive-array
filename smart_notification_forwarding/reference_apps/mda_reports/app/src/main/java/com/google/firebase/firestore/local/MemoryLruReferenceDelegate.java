package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
class MemoryLruReferenceDelegate implements ReferenceDelegate, LruDelegate {
    private final LruGarbageCollector garbageCollector;
    private ReferenceSet inMemoryPins;
    private final ListenSequence listenSequence;
    private final MemoryPersistence persistence;
    private final LocalSerializer serializer;
    private final Map<DocumentKey, Long> orphanedSequenceNumbers = new HashMap();
    private long currentSequenceNumber = -1;

    public MemoryLruReferenceDelegate(MemoryPersistence memoryPersistence, LruGarbageCollector.Params params, LocalSerializer localSerializer) {
        this.persistence = memoryPersistence;
        this.serializer = localSerializer;
        this.listenSequence = new ListenSequence(memoryPersistence.b().getHighestListenSequenceNumber());
        this.garbageCollector = new LruGarbageCollector(this, params);
    }

    public static /* synthetic */ void a(long[] jArr, Long l) {
        jArr[0] = jArr[0] + 1;
    }

    private boolean isPinned(DocumentKey documentKey, long j) {
        if (mutationQueuesContainsKey(documentKey) || this.inMemoryPins.containsKey(documentKey) || this.persistence.b().containsKey(documentKey)) {
            return true;
        }
        Long l = this.orphanedSequenceNumbers.get(documentKey);
        return l != null && l.longValue() > j;
    }

    private boolean mutationQueuesContainsKey(DocumentKey documentKey) {
        Iterator<MemoryMutationQueue> it = this.persistence.d().iterator();
        while (it.hasNext()) {
            if (it.next().a(documentKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void addReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        for (Map.Entry<DocumentKey, Long> entry : this.orphanedSequenceNumbers.entrySet()) {
            if (!isPinned(entry.getKey(), entry.getValue().longValue())) {
                consumer.accept(entry.getValue());
            }
        }
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachTarget(Consumer<QueryData> consumer) {
        this.persistence.b().forEachTarget(consumer);
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getByteSize() {
        long a = this.persistence.b().a(this.serializer) + 0 + this.persistence.c().a(this.serializer);
        Iterator<MemoryMutationQueue> it = this.persistence.d().iterator();
        while (it.hasNext()) {
            a += it.next().a(this.serializer);
        }
        return a;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getCurrentSequenceNumber() {
        Assert.hardAssert(this.currentSequenceNumber != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.currentSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public LruGarbageCollector getGarbageCollector() {
        return this.garbageCollector;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getSequenceNumberCount() {
        long targetCount = this.persistence.b().getTargetCount();
        long[] jArr = new long[1];
        forEachOrphanedDocumentSequenceNumber(MemoryLruReferenceDelegate$$Lambda$1.lambdaFactory$(jArr));
        return targetCount + jArr[0];
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionCommitted() {
        Assert.hardAssert(this.currentSequenceNumber != -1, "Committing a transaction without having started one", new Object[0]);
        this.currentSequenceNumber = -1L;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionStarted() {
        Assert.hardAssert(this.currentSequenceNumber == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.currentSequenceNumber = this.listenSequence.next();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeMutationReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeOrphanedDocuments(long j) {
        MemoryRemoteDocumentCache c = this.persistence.c();
        Iterator<MaybeDocument> it = c.a().iterator();
        int i = 0;
        while (it.hasNext()) {
            DocumentKey key = it.next().getKey();
            if (!isPinned(key, j)) {
                c.remove(key);
                this.orphanedSequenceNumbers.remove(key);
                i++;
            }
        }
        return i;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeTarget(QueryData queryData) {
        this.persistence.b().updateQueryData(queryData.withSequenceNumber(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeTargets(long j, SparseArray<?> sparseArray) {
        return this.persistence.b().a(j, sparseArray);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void setInMemoryPins(ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void updateLimboDocument(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }
}
