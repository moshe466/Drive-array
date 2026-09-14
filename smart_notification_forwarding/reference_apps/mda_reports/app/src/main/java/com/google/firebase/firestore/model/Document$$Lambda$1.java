package com.google.firebase.firestore.model;

import java.util.Comparator;

/* loaded from: classes2.dex */
final /* synthetic */ class Document$$Lambda$1 implements Comparator {
    private static final Document$$Lambda$1 instance = new Document$$Lambda$1();

    private Document$$Lambda$1() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return Document.a((Document) obj, (Document) obj2);
    }
}
