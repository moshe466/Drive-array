package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
final /* synthetic */ class DocumentReference$$Lambda$2 implements Comparator {
    private static final DocumentReference$$Lambda$2 instance = new DocumentReference$$Lambda$2();

    private DocumentReference$$Lambda$2() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return DocumentReference.b((DocumentReference) obj, (DocumentReference) obj2);
    }
}
