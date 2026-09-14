package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class TargetState {
    private int outstandingResponses = 0;
    private final Map<DocumentKey, DocumentViewChange.Type> documentChanges = new HashMap();
    private boolean hasChanges = true;
    private ByteString resumeToken = ByteString.EMPTY;
    private boolean current = false;

    /* renamed from: com.google.firebase.firestore.remote.TargetState$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
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
                a[DocumentViewChange.Type.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.hasChanges = false;
        this.documentChanges.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DocumentKey documentKey) {
        this.hasChanges = true;
        this.documentChanges.remove(documentKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DocumentKey documentKey, DocumentViewChange.Type type) {
        this.hasChanges = true;
        this.documentChanges.put(documentKey, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ByteString byteString) {
        if (byteString.isEmpty()) {
            return;
        }
        this.hasChanges = true;
        this.resumeToken = byteString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.hasChanges;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.current;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.outstandingResponses != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.hasChanges = true;
        this.current = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.outstandingResponses++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.outstandingResponses--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TargetChange h() {
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet2 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet3 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> immutableSortedSet = emptyKeySet;
        ImmutableSortedSet<DocumentKey> immutableSortedSet2 = emptyKeySet2;
        ImmutableSortedSet<DocumentKey> immutableSortedSet3 = emptyKeySet3;
        for (Map.Entry<DocumentKey, DocumentViewChange.Type> entry : this.documentChanges.entrySet()) {
            DocumentKey key = entry.getKey();
            DocumentViewChange.Type value = entry.getValue();
            int i = AnonymousClass1.a[value.ordinal()];
            if (i == 1) {
                immutableSortedSet = immutableSortedSet.insert(key);
            } else if (i == 2) {
                immutableSortedSet2 = immutableSortedSet2.insert(key);
            } else {
                if (i != 3) {
                    throw Assert.fail("Encountered invalid change type: %s", value);
                }
                immutableSortedSet3 = immutableSortedSet3.insert(key);
            }
        }
        return new TargetChange(this.resumeToken, this.current, immutableSortedSet, immutableSortedSet2, immutableSortedSet3);
    }
}
