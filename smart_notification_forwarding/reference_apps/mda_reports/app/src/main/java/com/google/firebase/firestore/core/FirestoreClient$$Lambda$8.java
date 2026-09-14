package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreClient$$Lambda$8 implements Callable {
    private final FirestoreClient arg$1;
    private final DocumentKey arg$2;

    private FirestoreClient$$Lambda$8(FirestoreClient firestoreClient, DocumentKey documentKey) {
        this.arg$1 = firestoreClient;
        this.arg$2 = documentKey;
    }

    public static Callable lambdaFactory$(FirestoreClient firestoreClient, DocumentKey documentKey) {
        return new FirestoreClient$$Lambda$8(firestoreClient, documentKey);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        MaybeDocument readDocument;
        readDocument = this.arg$1.localStore.readDocument(this.arg$2);
        return readDocument;
    }
}
