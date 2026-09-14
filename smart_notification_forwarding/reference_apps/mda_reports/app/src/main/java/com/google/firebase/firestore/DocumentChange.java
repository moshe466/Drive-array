package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DocumentChange {
    private final QueryDocumentSnapshot document;
    private final int newIndex;
    private final int oldIndex;
    private final Type type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.DocumentChange$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[DocumentViewChange.Type.values().length];

        static {
            try {
                a[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DocumentViewChange.Type.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DocumentViewChange.Type.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DocumentViewChange.Type.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum Type {
        ADDED,
        MODIFIED,
        REMOVED
    }

    @VisibleForTesting
    DocumentChange(QueryDocumentSnapshot queryDocumentSnapshot, Type type, int i, int i2) {
        this.type = type;
        this.document = queryDocumentSnapshot;
        this.oldIndex = i;
        this.newIndex = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<DocumentChange> a(FirebaseFirestore firebaseFirestore, MetadataChanges metadataChanges, ViewSnapshot viewSnapshot) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        if (viewSnapshot.getOldDocuments().isEmpty()) {
            Document document = null;
            int i3 = 0;
            for (DocumentViewChange documentViewChange : viewSnapshot.getChanges()) {
                Document document2 = documentViewChange.getDocument();
                QueryDocumentSnapshot a = QueryDocumentSnapshot.a(firebaseFirestore, document2, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document2.getKey()));
                Assert.hardAssert(documentViewChange.getType() == DocumentViewChange.Type.ADDED, "Invalid added event for first snapshot", new Object[0]);
                Assert.hardAssert(document == null || viewSnapshot.getQuery().comparator().compare(document, document2) < 0, "Got added events in wrong order", new Object[0]);
                arrayList.add(new DocumentChange(a, Type.ADDED, -1, i3));
                document = document2;
                i3++;
            }
        } else {
            DocumentSet oldDocuments = viewSnapshot.getOldDocuments();
            for (DocumentViewChange documentViewChange2 : viewSnapshot.getChanges()) {
                if (metadataChanges != MetadataChanges.EXCLUDE || documentViewChange2.getType() != DocumentViewChange.Type.METADATA) {
                    Document document3 = documentViewChange2.getDocument();
                    QueryDocumentSnapshot a2 = QueryDocumentSnapshot.a(firebaseFirestore, document3, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document3.getKey()));
                    Type type = getType(documentViewChange2);
                    if (type != Type.ADDED) {
                        i = oldDocuments.indexOf(document3.getKey());
                        Assert.hardAssert(i >= 0, "Index for document not found", new Object[0]);
                        oldDocuments = oldDocuments.remove(document3.getKey());
                    } else {
                        i = -1;
                    }
                    if (type != Type.REMOVED) {
                        oldDocuments = oldDocuments.add(document3);
                        i2 = oldDocuments.indexOf(document3.getKey());
                        Assert.hardAssert(i2 >= 0, "Index for document not found", new Object[0]);
                    } else {
                        i2 = -1;
                    }
                    arrayList.add(new DocumentChange(a2, type, i, i2));
                }
            }
        }
        return arrayList;
    }

    private static Type getType(DocumentViewChange documentViewChange) {
        int i = AnonymousClass1.a[documentViewChange.getType().ordinal()];
        if (i == 1) {
            return Type.ADDED;
        }
        if (i == 2 || i == 3) {
            return Type.MODIFIED;
        }
        if (i == 4) {
            return Type.REMOVED;
        }
        throw new IllegalArgumentException("Unknown view change type: " + documentViewChange.getType());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DocumentChange)) {
            return false;
        }
        DocumentChange documentChange = (DocumentChange) obj;
        return this.type.equals(documentChange.type) && this.document.equals(documentChange.document) && this.oldIndex == documentChange.oldIndex && this.newIndex == documentChange.newIndex;
    }

    @NonNull
    public QueryDocumentSnapshot getDocument() {
        return this.document;
    }

    public int getNewIndex() {
        return this.newIndex;
    }

    public int getOldIndex() {
        return this.oldIndex;
    }

    @NonNull
    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.document.hashCode()) * 31) + this.oldIndex) * 31) + this.newIndex;
    }
}
