package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreClient$$Lambda$6 implements Runnable {
    private final FirestoreClient arg$1;
    private final QueryListener arg$2;

    private FirestoreClient$$Lambda$6(FirestoreClient firestoreClient, QueryListener queryListener) {
        this.arg$1 = firestoreClient;
        this.arg$2 = queryListener;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, QueryListener queryListener) {
        return new FirestoreClient$$Lambda$6(firestoreClient, queryListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.eventManager.addQueryListener(this.arg$2);
    }
}
