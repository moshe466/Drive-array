package com.google.firebase.firestore.core;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreClient$$Lambda$5 implements Runnable {
    private final FirestoreClient arg$1;

    private FirestoreClient$$Lambda$5(FirestoreClient firestoreClient) {
        this.arg$1 = firestoreClient;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient) {
        return new FirestoreClient$$Lambda$5(firestoreClient);
    }

    @Override // java.lang.Runnable
    public void run() {
        FirestoreClient.c(this.arg$1);
    }
}
