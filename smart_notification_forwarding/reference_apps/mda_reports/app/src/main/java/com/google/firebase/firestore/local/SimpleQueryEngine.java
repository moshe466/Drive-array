package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public class SimpleQueryEngine implements QueryEngine {
    private LocalDocumentsView localDocumentsView;

    @Override // com.google.firebase.firestore.local.QueryEngine
    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        Assert.hardAssert(this.localDocumentsView != null, "setLocalDocumentsView() not called", new Object[0]);
        return this.localDocumentsView.a(query, SnapshotVersion.NONE);
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void handleDocumentChange(MaybeDocument maybeDocument, MaybeDocument maybeDocument2) {
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void setLocalDocumentsView(LocalDocumentsView localDocumentsView) {
        this.localDocumentsView = localDocumentsView;
    }
}
