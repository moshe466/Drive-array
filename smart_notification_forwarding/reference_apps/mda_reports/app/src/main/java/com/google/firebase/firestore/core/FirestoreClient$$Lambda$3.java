package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
final /* synthetic */ class FirestoreClient$$Lambda$3 implements Runnable {
    private final FirestoreClient arg$1;

    private FirestoreClient$$Lambda$3(FirestoreClient firestoreClient) {
        this.arg$1 = firestoreClient;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient) {
        return new FirestoreClient$$Lambda$3(firestoreClient);
    }

    @Override // java.lang.Runnable
    public void run() {
        FirestoreClient.a(this.arg$1);
    }
}
