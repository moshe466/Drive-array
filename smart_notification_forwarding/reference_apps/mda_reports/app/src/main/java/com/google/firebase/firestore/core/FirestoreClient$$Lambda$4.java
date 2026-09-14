package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
final /* synthetic */ class FirestoreClient$$Lambda$4 implements Runnable {
    private final FirestoreClient arg$1;

    private FirestoreClient$$Lambda$4(FirestoreClient firestoreClient) {
        this.arg$1 = firestoreClient;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient) {
        return new FirestoreClient$$Lambda$4(firestoreClient);
    }

    @Override // java.lang.Runnable
    public void run() {
        FirestoreClient.b(this.arg$1);
    }
}
