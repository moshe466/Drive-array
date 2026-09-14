package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
final /* synthetic */ class DocumentReference$$Lambda$1 implements Comparator {
    private static final DocumentReference$$Lambda$1 instance = new DocumentReference$$Lambda$1();

    private DocumentReference$$Lambda$1() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return DocumentReference.a((DocumentReference) obj, (DocumentReference) obj2);
    }
}
