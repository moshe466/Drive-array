package com.google.firebase.firestore.local;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MemoryRemoteDocumentCache implements RemoteDocumentCache {
    private ImmutableSortedMap<DocumentKey, Pair<MaybeDocument, SnapshotVersion>> docs = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());
    private final MemoryPersistence persistence;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class DocumentIterable implements Iterable<MaybeDocument> {
        private DocumentIterable() {
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<MaybeDocument> iterator() {
            final Iterator it = MemoryRemoteDocumentCache.this.docs.iterator();
            return new Iterator<MaybeDocument>(this) { // from class: com.google.firebase.firestore.local.MemoryRemoteDocumentCache.DocumentIterable.1
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public MaybeDocument next() {
                    return (MaybeDocument) ((Pair) ((Map.Entry) it.next()).getValue()).first;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryRemoteDocumentCache(MemoryPersistence memoryPersistence) {
        this.persistence = memoryPersistence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(LocalSerializer localSerializer) {
        long j = 0;
        while (new DocumentIterable().iterator().hasNext()) {
            j += localSerializer.a(r0.next()).getSerializedSize();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterable<MaybeDocument> a() {
        return new DocumentIterable();
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void add(MaybeDocument maybeDocument, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.docs = this.docs.insert(maybeDocument.getKey(), new Pair<>(maybeDocument, snapshotVersion));
        this.persistence.a().addToCollectionParentIndex(maybeDocument.getKey().getPath().popLast());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    @Nullable
    public MaybeDocument get(DocumentKey documentKey) {
        Pair<MaybeDocument, SnapshotVersion> pair = this.docs.get(documentKey);
        if (pair != null) {
            return (MaybeDocument) pair.first;
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> iterable) {
        HashMap hashMap = new HashMap();
        for (DocumentKey documentKey : iterable) {
            hashMap.put(documentKey, get(documentKey));
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        ResourcePath path = query.getPath();
        Iterator<Map.Entry<DocumentKey, Pair<MaybeDocument, SnapshotVersion>>> iteratorFrom = this.docs.iteratorFrom(DocumentKey.fromPath(path.append("")));
        while (iteratorFrom.hasNext()) {
            Map.Entry<DocumentKey, Pair<MaybeDocument, SnapshotVersion>> next = iteratorFrom.next();
            if (!path.isPrefixOf(next.getKey().getPath())) {
                break;
            }
            MaybeDocument maybeDocument = (MaybeDocument) next.getValue().first;
            if ((maybeDocument instanceof Document) && ((SnapshotVersion) next.getValue().second).compareTo(snapshotVersion) > 0) {
                Document document = (Document) maybeDocument;
                if (query.matches(document)) {
                    emptyDocumentMap = emptyDocumentMap.insert(document.getKey(), document);
                }
            }
        }
        return emptyDocumentMap;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void remove(DocumentKey documentKey) {
        this.docs = this.docs.remove(documentKey);
    }
}
