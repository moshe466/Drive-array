package com.google.firebase.firestore.model;

import java.util.Comparator;

/* loaded from: classes2.dex */
final /* synthetic */ class DocumentKey$$Lambda$1 implements Comparator {
    private static final DocumentKey$$Lambda$1 instance = new DocumentKey$$Lambda$1();

    private DocumentKey$$Lambda$1() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((DocumentKey) obj).compareTo2((DocumentKey) obj2);
    }
}
