package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface RemoteDocumentCache {
    void add(MaybeDocument maybeDocument, SnapshotVersion snapshotVersion);

    @Nullable
    MaybeDocument get(DocumentKey documentKey);

    Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> iterable);

    ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion);

    void remove(DocumentKey documentKey);
}
