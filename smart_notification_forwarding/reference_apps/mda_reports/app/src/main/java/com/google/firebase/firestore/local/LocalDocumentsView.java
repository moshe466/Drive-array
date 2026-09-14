package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.util.Assert;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LocalDocumentsView {
    private final IndexManager indexManager;
    private final MutationQueue mutationQueue;
    private final RemoteDocumentCache remoteDocumentCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalDocumentsView(RemoteDocumentCache remoteDocumentCache, MutationQueue mutationQueue, IndexManager indexManager) {
        this.remoteDocumentCache = remoteDocumentCache;
        this.mutationQueue = mutationQueue;
        this.indexManager = indexManager;
    }

    private ImmutableSortedMap<DocumentKey, Document> addMissingBaseDocuments(List<MutationBatch> list, ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        HashSet hashSet = new HashSet();
        Iterator<MutationBatch> it = list.iterator();
        while (it.hasNext()) {
            for (Mutation mutation : it.next().getMutations()) {
                if ((mutation instanceof PatchMutation) && !immutableSortedMap.containsKey(mutation.getKey())) {
                    hashSet.add(mutation.getKey());
                }
            }
        }
        for (Map.Entry<DocumentKey, MaybeDocument> entry : this.remoteDocumentCache.getAll(hashSet).entrySet()) {
            if (entry.getValue() != null && (entry.getValue() instanceof Document)) {
                immutableSortedMap = immutableSortedMap.insert(entry.getKey(), (Document) entry.getValue());
            }
        }
        return immutableSortedMap;
    }

    private Map<DocumentKey, MaybeDocument> applyLocalMutationsToDocuments(Map<DocumentKey, MaybeDocument> map, List<MutationBatch> list) {
        for (Map.Entry<DocumentKey, MaybeDocument> entry : map.entrySet()) {
            MaybeDocument value = entry.getValue();
            Iterator<MutationBatch> it = list.iterator();
            while (it.hasNext()) {
                value = it.next().applyToLocalView(entry.getKey(), value);
            }
            entry.setValue(value);
        }
        return map;
    }

    @Nullable
    private MaybeDocument getDocument(DocumentKey documentKey, List<MutationBatch> list) {
        MaybeDocument maybeDocument = this.remoteDocumentCache.get(documentKey);
        Iterator<MutationBatch> it = list.iterator();
        while (it.hasNext()) {
            maybeDocument = it.next().applyToLocalView(documentKey, maybeDocument);
        }
        return maybeDocument;
    }

    private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingCollectionGroupQuery(Query query, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(query.getPath().isEmpty(), "Currently we only support collection group queries at the root.", new Object[0]);
        String collectionGroup = query.getCollectionGroup();
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        Iterator<ResourcePath> it = this.indexManager.getCollectionParents(collectionGroup).iterator();
        while (it.hasNext()) {
            Iterator<Map.Entry<DocumentKey, Document>> it2 = getDocumentsMatchingCollectionQuery(query.asCollectionQueryAtPath(it.next().append(collectionGroup)), snapshotVersion).iterator();
            while (it2.hasNext()) {
                Map.Entry<DocumentKey, Document> next = it2.next();
                emptyDocumentMap = emptyDocumentMap.insert(next.getKey(), next.getValue());
            }
        }
        return emptyDocumentMap;
    }

    private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingCollectionQuery(Query query, SnapshotVersion snapshotVersion) {
        ImmutableSortedMap<DocumentKey, Document> allDocumentsMatchingQuery = this.remoteDocumentCache.getAllDocumentsMatchingQuery(query, snapshotVersion);
        List<MutationBatch> allMutationBatchesAffectingQuery = this.mutationQueue.getAllMutationBatchesAffectingQuery(query);
        ImmutableSortedMap<DocumentKey, Document> addMissingBaseDocuments = addMissingBaseDocuments(allMutationBatchesAffectingQuery, allDocumentsMatchingQuery);
        for (MutationBatch mutationBatch : allMutationBatchesAffectingQuery) {
            for (Mutation mutation : mutationBatch.getMutations()) {
                if (query.getPath().isImmediateParentOf(mutation.getKey().getPath())) {
                    DocumentKey key = mutation.getKey();
                    Document document = addMissingBaseDocuments.get(key);
                    MaybeDocument applyToLocalView = mutation.applyToLocalView(document, document, mutationBatch.getLocalWriteTime());
                    addMissingBaseDocuments = applyToLocalView instanceof Document ? addMissingBaseDocuments.insert(key, (Document) applyToLocalView) : addMissingBaseDocuments.remove(key);
                }
            }
        }
        Iterator<Map.Entry<DocumentKey, Document>> it = addMissingBaseDocuments.iterator();
        while (it.hasNext()) {
            Map.Entry<DocumentKey, Document> next = it.next();
            if (!query.matches(next.getValue())) {
                addMissingBaseDocuments = addMissingBaseDocuments.remove(next.getKey());
            }
        }
        return addMissingBaseDocuments;
    }

    private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingDocumentQuery(ResourcePath resourcePath) {
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        MaybeDocument a = a(DocumentKey.fromPath(resourcePath));
        return a instanceof Document ? emptyDocumentMap.insert(a.getKey(), (Document) a) : emptyDocumentMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, Document> a(Query query, SnapshotVersion snapshotVersion) {
        return query.isDocumentQuery() ? getDocumentsMatchingDocumentQuery(query.getPath()) : query.isCollectionGroupQuery() ? getDocumentsMatchingCollectionGroupQuery(query, snapshotVersion) : getDocumentsMatchingCollectionQuery(query, snapshotVersion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, MaybeDocument> a(Iterable<DocumentKey> iterable) {
        return a(this.remoteDocumentCache.getAll(iterable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, MaybeDocument> a(Map<DocumentKey, MaybeDocument> map) {
        ImmutableSortedMap<DocumentKey, MaybeDocument> emptyMaybeDocumentMap = DocumentCollections.emptyMaybeDocumentMap();
        for (Map.Entry<DocumentKey, MaybeDocument> entry : applyLocalMutationsToDocuments(map, this.mutationQueue.getAllMutationBatchesAffectingDocumentKeys(map.keySet())).entrySet()) {
            DocumentKey key = entry.getKey();
            MaybeDocument value = entry.getValue();
            if (value == null) {
                value = new NoDocument(key, SnapshotVersion.NONE, false);
            }
            emptyMaybeDocumentMap = emptyMaybeDocumentMap.insert(key, value);
        }
        return emptyMaybeDocumentMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public MaybeDocument a(DocumentKey documentKey) {
        return getDocument(documentKey, this.mutationQueue.getAllMutationBatchesAffectingDocumentKey(documentKey));
    }
}
