package com.google.firebase.firestore.local;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MemoryQueryCache implements QueryCache {
    private int highestTargetId;
    private final MemoryPersistence persistence;
    private final Map<Target, QueryData> targets = new HashMap();
    private final ReferenceSet references = new ReferenceSet();
    private SnapshotVersion lastRemoteSnapshotVersion = SnapshotVersion.NONE;
    private long highestSequenceNumber = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryQueryCache(MemoryPersistence memoryPersistence) {
        this.persistence = memoryPersistence;
    }

    private void removeMatchingKeysForTargetId(int i) {
        this.references.removeReferencesForId(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(long j, SparseArray<?> sparseArray) {
        Iterator<Map.Entry<Target, QueryData>> it = this.targets.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<Target, QueryData> next = it.next();
            int targetId = next.getValue().getTargetId();
            if (next.getValue().getSequenceNumber() <= j && sparseArray.get(targetId) == null) {
                it.remove();
                removeMatchingKeysForTargetId(targetId);
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(LocalSerializer localSerializer) {
        long j = 0;
        while (this.targets.entrySet().iterator().hasNext()) {
            j += localSerializer.a(r0.next().getValue()).getSerializedSize();
        }
        return j;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        this.references.addReferences(immutableSortedSet, i);
        ReferenceDelegate referenceDelegate = this.persistence.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            referenceDelegate.addReference(it.next());
        }
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void addQueryData(QueryData queryData) {
        this.targets.put(queryData.getTarget(), queryData);
        int targetId = queryData.getTargetId();
        if (targetId > this.highestTargetId) {
            this.highestTargetId = targetId;
        }
        if (queryData.getSequenceNumber() > this.highestSequenceNumber) {
            this.highestSequenceNumber = queryData.getSequenceNumber();
        }
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public boolean containsKey(DocumentKey documentKey) {
        return this.references.containsKey(documentKey);
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void forEachTarget(Consumer<QueryData> consumer) {
        Iterator<QueryData> it = this.targets.values().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public long getHighestListenSequenceNumber() {
        return this.highestSequenceNumber;
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
        return this.references.referencesForId(i);
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    @Nullable
    public QueryData getQueryData(Target target) {
        return this.targets.get(target);
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public long getTargetCount() {
        return this.targets.size();
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        this.references.removeReferences(immutableSortedSet, i);
        ReferenceDelegate referenceDelegate = this.persistence.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            referenceDelegate.removeReference(it.next());
        }
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void removeQueryData(QueryData queryData) {
        this.targets.remove(queryData.getTarget());
        this.references.removeReferencesForId(queryData.getTargetId());
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion) {
        this.lastRemoteSnapshotVersion = snapshotVersion;
    }

    @Override // com.google.firebase.firestore.local.QueryCache
    public void updateQueryData(QueryData queryData) {
        addQueryData(queryData);
    }
}
