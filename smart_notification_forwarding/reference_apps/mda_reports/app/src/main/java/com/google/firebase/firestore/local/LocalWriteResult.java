package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;

/* loaded from: classes2.dex */
public final class LocalWriteResult {
    private final int batchId;
    private final ImmutableSortedMap<DocumentKey, MaybeDocument> changes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalWriteResult(int i, ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap) {
        this.batchId = i;
        this.changes = immutableSortedMap;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> getChanges() {
        return this.changes;
    }
}
