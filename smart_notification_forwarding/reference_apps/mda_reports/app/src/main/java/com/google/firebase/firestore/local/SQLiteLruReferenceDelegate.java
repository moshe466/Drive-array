package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.common.base.Function;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public class SQLiteLruReferenceDelegate implements ReferenceDelegate, LruDelegate {
    private long currentSequenceNumber = -1;
    private final LruGarbageCollector garbageCollector;
    private ReferenceSet inMemoryPins;
    private ListenSequence listenSequence;
    private final SQLitePersistence persistence;

    public SQLiteLruReferenceDelegate(SQLitePersistence sQLitePersistence, LruGarbageCollector.Params params) {
        this.persistence = sQLitePersistence;
        this.garbageCollector = new LruGarbageCollector(this, params);
    }

    public static /* synthetic */ void a(SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] iArr, Cursor cursor) {
        DocumentKey fromPath = DocumentKey.fromPath(EncodedPath.a(cursor.getString(0)));
        if (sQLiteLruReferenceDelegate.isPinned(fromPath)) {
            return;
        }
        iArr[0] = iArr[0] + 1;
        sQLiteLruReferenceDelegate.persistence.c().remove(fromPath);
        sQLiteLruReferenceDelegate.removeSentinel(fromPath);
    }

    private boolean isPinned(DocumentKey documentKey) {
        if (this.inMemoryPins.containsKey(documentKey)) {
            return true;
        }
        return mutationQueuesContainKey(documentKey);
    }

    private boolean mutationQueuesContainKey(DocumentKey documentKey) {
        return !this.persistence.b("SELECT 1 FROM document_mutations WHERE path = ?").a(EncodedPath.a(documentKey.getPath())).a();
    }

    private void removeSentinel(DocumentKey documentKey) {
        this.persistence.a("DELETE FROM target_documents WHERE path = ? AND target_id = 0", EncodedPath.a(documentKey.getPath()));
    }

    private void writeSentinel(DocumentKey documentKey) {
        this.persistence.a("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", EncodedPath.a(documentKey.getPath()), Long.valueOf(getCurrentSequenceNumber()));
    }

    public void a(long j) {
        this.listenSequence = new ListenSequence(j);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void addReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        this.persistence.b("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").b(SQLiteLruReferenceDelegate$$Lambda$2.lambdaFactory$(consumer));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachTarget(Consumer<QueryData> consumer) {
        this.persistence.b().forEachTarget(consumer);
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getByteSize() {
        return this.persistence.d();
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
        Function function;
        long targetCount = this.persistence.b().getTargetCount();
        SQLitePersistence.Query b = this.persistence.b("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)");
        function = SQLiteLruReferenceDelegate$$Lambda$1.instance;
        return targetCount + ((Long) b.a(function)).longValue();
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
        writeSentinel(documentKey);
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeOrphanedDocuments(long j) {
        int[] iArr = new int[1];
        while (true) {
            for (boolean z = true; z; z = false) {
                if (this.persistence.b("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?").a(Long.valueOf(j), 100).b(SQLiteLruReferenceDelegate$$Lambda$3.lambdaFactory$(this, iArr)) == 100) {
                    break;
                }
            }
            return iArr[0];
        }
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
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
        writeSentinel(documentKey);
    }
}
