package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class View {
    private boolean current;
    private DocumentSet documentSet;
    private final Query query;
    private ImmutableSortedSet<DocumentKey> syncedDocuments;
    private ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
    private ImmutableSortedSet<DocumentKey> limboDocuments = DocumentKey.emptyKeySet();
    private ImmutableSortedSet<DocumentKey> mutatedKeys = DocumentKey.emptyKeySet();

    /* renamed from: com.google.firebase.firestore.core.View$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[DocumentViewChange.Type.values().length];

        static {
            try {
                a[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DocumentViewChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DocumentViewChange.Type.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DocumentViewChange.Type.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class DocumentChanges {
        final DocumentSet a;
        final DocumentViewChangeSet b;
        final ImmutableSortedSet<DocumentKey> c;
        private final boolean needsRefill;

        private DocumentChanges(DocumentSet documentSet, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z) {
            this.a = documentSet;
            this.b = documentViewChangeSet;
            this.c = immutableSortedSet;
            this.needsRefill = z;
        }

        /* synthetic */ DocumentChanges(DocumentSet documentSet, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet immutableSortedSet, boolean z, AnonymousClass1 anonymousClass1) {
            this(documentSet, documentViewChangeSet, immutableSortedSet, z);
        }

        public boolean needsRefill() {
            return this.needsRefill;
        }
    }

    public View(Query query, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        this.query = query;
        this.documentSet = DocumentSet.emptySet(query.comparator());
        this.syncedDocuments = immutableSortedSet;
    }

    public static /* synthetic */ int a(View view, DocumentViewChange documentViewChange, DocumentViewChange documentViewChange2) {
        int compareIntegers = Util.compareIntegers(changeTypeOrder(documentViewChange), changeTypeOrder(documentViewChange2));
        documentViewChange.getType().compareTo(documentViewChange2.getType());
        return compareIntegers != 0 ? compareIntegers : view.query.comparator().compare(documentViewChange.getDocument(), documentViewChange2.getDocument());
    }

    private void applyTargetChange(TargetChange targetChange) {
        if (targetChange != null) {
            Iterator<DocumentKey> it = targetChange.getAddedDocuments().iterator();
            while (it.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.insert(it.next());
            }
            Iterator<DocumentKey> it2 = targetChange.getModifiedDocuments().iterator();
            while (it2.hasNext()) {
                DocumentKey next = it2.next();
                Assert.hardAssert(this.syncedDocuments.contains(next), "Modified document %s not found in view.", next);
            }
            Iterator<DocumentKey> it3 = targetChange.getRemovedDocuments().iterator();
            while (it3.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.remove(it3.next());
            }
            this.current = targetChange.isCurrent();
        }
    }

    private static int changeTypeOrder(DocumentViewChange documentViewChange) {
        int i = AnonymousClass1.a[documentViewChange.getType().ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                if (i == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + documentViewChange.getType());
            }
        }
        return i2;
    }

    private boolean shouldBeLimboDoc(DocumentKey documentKey) {
        Document document;
        return (this.syncedDocuments.contains(documentKey) || (document = this.documentSet.getDocument(documentKey)) == null || document.hasLocalMutations()) ? false : true;
    }

    private boolean shouldWaitForSyncedDocument(Document document, Document document2) {
        return document.hasLocalMutations() && document2.hasCommittedMutations() && !document2.hasLocalMutations();
    }

    private List<LimboDocumentChange> updateLimboDocuments() {
        if (!this.current) {
            return Collections.emptyList();
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSet = this.limboDocuments;
        this.limboDocuments = DocumentKey.emptyKeySet();
        Iterator<Document> it = this.documentSet.iterator();
        while (it.hasNext()) {
            Document next = it.next();
            if (shouldBeLimboDoc(next.getKey())) {
                this.limboDocuments = this.limboDocuments.insert(next.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(immutableSortedSet.size() + this.limboDocuments.size());
        Iterator<DocumentKey> it2 = immutableSortedSet.iterator();
        while (it2.hasNext()) {
            DocumentKey next2 = it2.next();
            if (!this.limboDocuments.contains(next2)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, next2));
            }
        }
        Iterator<DocumentKey> it3 = this.limboDocuments.iterator();
        while (it3.hasNext()) {
            DocumentKey next3 = it3.next();
            if (!immutableSortedSet.contains(next3)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.ADDED, next3));
            }
        }
        return arrayList;
    }

    public ImmutableSortedSet<DocumentKey> a() {
        return this.limboDocuments;
    }

    public ViewChange applyChanges(DocumentChanges documentChanges) {
        return applyChanges(documentChanges, null);
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange) {
        ViewSnapshot viewSnapshot;
        Assert.hardAssert(!documentChanges.needsRefill, "Cannot apply changes that need a refill", new Object[0]);
        DocumentSet documentSet = this.documentSet;
        this.documentSet = documentChanges.a;
        this.mutatedKeys = documentChanges.c;
        List<DocumentViewChange> a = documentChanges.b.a();
        Collections.sort(a, View$$Lambda$1.lambdaFactory$(this));
        applyTargetChange(targetChange);
        List<LimboDocumentChange> updateLimboDocuments = updateLimboDocuments();
        ViewSnapshot.SyncState syncState = this.limboDocuments.size() == 0 && this.current ? ViewSnapshot.SyncState.SYNCED : ViewSnapshot.SyncState.LOCAL;
        boolean z = syncState != this.syncState;
        this.syncState = syncState;
        if (a.size() != 0 || z) {
            viewSnapshot = new ViewSnapshot(this.query, documentChanges.a, documentSet, a, syncState == ViewSnapshot.SyncState.LOCAL, documentChanges.c, z, false);
        } else {
            viewSnapshot = null;
        }
        return new ViewChange(viewSnapshot, updateLimboDocuments);
    }

    public ViewChange applyOnlineStateChange(OnlineState onlineState) {
        if (!this.current || onlineState != OnlineState.OFFLINE) {
            return new ViewChange(null, Collections.emptyList());
        }
        this.current = false;
        return applyChanges(new DocumentChanges(this.documentSet, new DocumentViewChangeSet(), this.mutatedKeys, false, null));
    }

    public ImmutableSortedSet<DocumentKey> b() {
        return this.syncedDocuments;
    }

    public <D extends MaybeDocument> DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, D> immutableSortedMap) {
        return computeDocChanges(immutableSortedMap, null);
    }

    public <D extends MaybeDocument> DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, D> immutableSortedMap, @Nullable DocumentChanges documentChanges) {
        boolean z;
        DocumentSet documentSet;
        DocumentSet remove;
        ImmutableSortedSet<DocumentKey> remove2;
        boolean z2;
        DocumentViewChangeSet documentViewChangeSet = documentChanges != null ? documentChanges.b : new DocumentViewChangeSet();
        DocumentSet documentSet2 = documentChanges != null ? documentChanges.a : this.documentSet;
        ImmutableSortedSet<DocumentKey> immutableSortedSet = documentChanges != null ? documentChanges.c : this.mutatedKeys;
        Document lastDocument = (this.query.hasLimitToFirst() && ((long) documentSet2.size()) == this.query.getLimitToFirst()) ? documentSet2.getLastDocument() : null;
        Document firstDocument = (this.query.hasLimitToLast() && ((long) documentSet2.size()) == this.query.getLimitToLast()) ? documentSet2.getFirstDocument() : null;
        Iterator<Map.Entry<DocumentKey, D>> it = immutableSortedMap.iterator();
        char c = 0;
        ImmutableSortedSet<DocumentKey> immutableSortedSet2 = immutableSortedSet;
        boolean z3 = false;
        DocumentSet documentSet3 = documentSet2;
        while (it.hasNext()) {
            Map.Entry<DocumentKey, D> next = it.next();
            DocumentKey key = next.getKey();
            Document document = documentSet2.getDocument(key);
            D value = next.getValue();
            Document document2 = value instanceof Document ? (Document) value : null;
            if (document2 != null) {
                boolean equals = key.equals(document2.getKey());
                Object[] objArr = new Object[2];
                objArr[c] = key;
                z = true;
                objArr[1] = document2.getKey();
                Assert.hardAssert(equals, "Mismatching key in doc change %s != %s", objArr);
                if (!this.query.matches(document2)) {
                    document2 = null;
                }
            } else {
                z = true;
            }
            boolean z4 = document != null && this.mutatedKeys.contains(document.getKey());
            boolean z5 = document2 != null && (document2.hasLocalMutations() || (this.mutatedKeys.contains(document2.getKey()) && document2.hasCommittedMutations()));
            if (document == null || document2 == null) {
                documentSet = documentSet2;
                if (document == null && document2 != null) {
                    documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.ADDED, document2));
                } else if (document == null || document2 != null) {
                    z = false;
                } else {
                    documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.REMOVED, document));
                    if (lastDocument != null || firstDocument != null) {
                        z3 = true;
                    }
                }
            } else {
                documentSet = documentSet2;
                if (document.getData().equals(document2.getData())) {
                    if (z4 != z5) {
                        documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.METADATA, document2));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (!shouldWaitForSyncedDocument(document, document2)) {
                        documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, document2));
                        if ((lastDocument != null && this.query.comparator().compare(document2, lastDocument) > 0) || (firstDocument != null && this.query.comparator().compare(document2, firstDocument) < 0)) {
                            z2 = true;
                            z3 = true;
                        }
                        z2 = true;
                    }
                    z2 = false;
                }
                z = z2;
            }
            if (z) {
                if (document2 != null) {
                    remove = documentSet3.add(document2);
                    remove2 = document2.hasLocalMutations() ? immutableSortedSet2.insert(document2.getKey()) : immutableSortedSet2.remove(document2.getKey());
                } else {
                    remove = documentSet3.remove(key);
                    remove2 = immutableSortedSet2.remove(key);
                }
                immutableSortedSet2 = remove2;
                documentSet3 = remove;
            }
            documentSet2 = documentSet;
            c = 0;
        }
        if (this.query.hasLimitToFirst() || this.query.hasLimitToLast()) {
            long limitToFirst = this.query.hasLimitToFirst() ? this.query.getLimitToFirst() : this.query.getLimitToLast();
            long size = documentSet3.size();
            while (true) {
                size -= limitToFirst;
                if (size <= 0) {
                    break;
                }
                Document lastDocument2 = this.query.hasLimitToFirst() ? documentSet3.getLastDocument() : documentSet3.getFirstDocument();
                documentSet3 = documentSet3.remove(lastDocument2.getKey());
                immutableSortedSet2 = immutableSortedSet2.remove(lastDocument2.getKey());
                documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.REMOVED, lastDocument2));
                limitToFirst = 1;
            }
        }
        DocumentSet documentSet4 = documentSet3;
        ImmutableSortedSet<DocumentKey> immutableSortedSet3 = immutableSortedSet2;
        Assert.hardAssert(!z3 || documentChanges == null, "View was refilled using docs that themselves needed refilling.", new Object[0]);
        return new DocumentChanges(documentSet4, documentViewChangeSet, immutableSortedSet3, z3, null);
    }

    public ViewSnapshot.SyncState getSyncState() {
        return this.syncState;
    }
}
