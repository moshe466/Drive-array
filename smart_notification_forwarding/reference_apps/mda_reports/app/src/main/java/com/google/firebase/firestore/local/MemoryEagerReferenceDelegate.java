package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MemoryEagerReferenceDelegate implements ReferenceDelegate {
    private ReferenceSet inMemoryPins;
    private Set<DocumentKey> orphanedDocuments;
    private final MemoryPersistence persistence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryEagerReferenceDelegate(MemoryPersistence memoryPersistence) {
        this.persistence = memoryPersistence;
    }

    private boolean isReferenced(DocumentKey documentKey) {
        if (this.persistence.b().containsKey(documentKey) || mutationQueuesContainKey(documentKey)) {
            return true;
        }
        ReferenceSet referenceSet = this.inMemoryPins;
        return referenceSet != null && referenceSet.containsKey(documentKey);
    }

    private boolean mutationQueuesContainKey(DocumentKey documentKey) {
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
        this.orphanedDocuments.remove(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getCurrentSequenceNumber() {
        return -1L;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionCommitted() {
        MemoryRemoteDocumentCache c = this.persistence.c();
        for (DocumentKey documentKey : this.orphanedDocuments) {
            if (!isReferenced(documentKey)) {
                c.remove(documentKey);
            }
        }
        this.orphanedDocuments = null;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionStarted() {
        this.orphanedDocuments = new HashSet();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeMutationReference(DocumentKey documentKey) {
        this.orphanedDocuments.add(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        this.orphanedDocuments.add(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeTarget(QueryData queryData) {
        MemoryQueryCache b = this.persistence.b();
        Iterator<DocumentKey> it = b.getMatchingKeysForTargetId(queryData.getTargetId()).iterator();
        while (it.hasNext()) {
            this.orphanedDocuments.add(it.next());
        }
        b.removeQueryData(queryData);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void setInMemoryPins(ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void updateLimboDocument(DocumentKey documentKey) {
        if (isReferenced(documentKey)) {
            this.orphanedDocuments.remove(documentKey);
        } else {
            this.orphanedDocuments.add(documentKey);
        }
    }
}
