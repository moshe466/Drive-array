package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class QuerySnapshot implements Iterable<QueryDocumentSnapshot> {
    private List<DocumentChange> cachedChanges;
    private MetadataChanges cachedChangesMetadataState;
    private final FirebaseFirestore firestore;
    private final SnapshotMetadata metadata;
    private final Query originalQuery;
    private final ViewSnapshot snapshot;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class QuerySnapshotIterator implements Iterator<QueryDocumentSnapshot> {
        private final Iterator<Document> it;

        QuerySnapshotIterator(Iterator<Document> it) {
            this.it = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public QueryDocumentSnapshot next() {
            return QuerySnapshot.this.convertDocument(this.it.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("QuerySnapshot does not support remove().");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuerySnapshot(Query query, ViewSnapshot viewSnapshot, FirebaseFirestore firebaseFirestore) {
        this.originalQuery = (Query) Preconditions.checkNotNull(query);
        this.snapshot = (ViewSnapshot) Preconditions.checkNotNull(viewSnapshot);
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
        this.metadata = new SnapshotMetadata(viewSnapshot.hasPendingWrites(), viewSnapshot.isFromCache());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QueryDocumentSnapshot convertDocument(Document document) {
        return QueryDocumentSnapshot.a(this.firestore, document, this.snapshot.isFromCache(), this.snapshot.getMutatedKeys().contains(document.getKey()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuerySnapshot)) {
            return false;
        }
        QuerySnapshot querySnapshot = (QuerySnapshot) obj;
        return this.firestore.equals(querySnapshot.firestore) && this.originalQuery.equals(querySnapshot.originalQuery) && this.snapshot.equals(querySnapshot.snapshot) && this.metadata.equals(querySnapshot.metadata);
    }

    @NonNull
    public List<DocumentChange> getDocumentChanges() {
        return getDocumentChanges(MetadataChanges.EXCLUDE);
    }

    @NonNull
    public List<DocumentChange> getDocumentChanges(@NonNull MetadataChanges metadataChanges) {
        if (MetadataChanges.INCLUDE.equals(metadataChanges) && this.snapshot.excludesMetadataChanges()) {
            throw new IllegalArgumentException("To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener().");
        }
        if (this.cachedChanges == null || this.cachedChangesMetadataState != metadataChanges) {
            this.cachedChanges = Collections.unmodifiableList(DocumentChange.a(this.firestore, metadataChanges, this.snapshot));
            this.cachedChangesMetadataState = metadataChanges;
        }
        return this.cachedChanges;
    }

    @NonNull
    public List<DocumentSnapshot> getDocuments() {
        ArrayList arrayList = new ArrayList(this.snapshot.getDocuments().size());
        Iterator<Document> it = this.snapshot.getDocuments().iterator();
        while (it.hasNext()) {
            arrayList.add(convertDocument(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public SnapshotMetadata getMetadata() {
        return this.metadata;
    }

    @NonNull
    public Query getQuery() {
        return this.originalQuery;
    }

    public int hashCode() {
        return (((((this.firestore.hashCode() * 31) + this.originalQuery.hashCode()) * 31) + this.snapshot.hashCode()) * 31) + this.metadata.hashCode();
    }

    public boolean isEmpty() {
        return this.snapshot.getDocuments().isEmpty();
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<QueryDocumentSnapshot> iterator() {
        return new QuerySnapshotIterator(this.snapshot.getDocuments().iterator());
    }

    public int size() {
        return this.snapshot.getDocuments().size();
    }

    @NonNull
    public <T> List<T> toObjects(@NonNull Class<T> cls) {
        return toObjects(cls, DocumentSnapshot.ServerTimestampBehavior.a);
    }

    @NonNull
    public <T> List<T> toObjects(@NonNull Class<T> cls, @NonNull DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(cls, "Provided POJO type must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator<QueryDocumentSnapshot> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toObject(cls, serverTimestampBehavior));
        }
        return arrayList;
    }
}
