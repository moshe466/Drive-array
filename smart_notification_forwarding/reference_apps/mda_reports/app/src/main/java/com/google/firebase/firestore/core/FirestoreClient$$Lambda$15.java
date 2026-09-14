package com.google.firebase.firestore.core;

import com.google.firebase.firestore.auth.User;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreClient$$Lambda$15 implements Runnable {
    private final FirestoreClient arg$1;
    private final User arg$2;

    private FirestoreClient$$Lambda$15(FirestoreClient firestoreClient, User user) {
        this.arg$1 = firestoreClient;
        this.arg$2 = user;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, User user) {
        return new FirestoreClient$$Lambda$15(firestoreClient, user);
    }

    @Override // java.lang.Runnable
    public void run() {
        FirestoreClient.a(this.arg$1, this.arg$2);
    }
}
