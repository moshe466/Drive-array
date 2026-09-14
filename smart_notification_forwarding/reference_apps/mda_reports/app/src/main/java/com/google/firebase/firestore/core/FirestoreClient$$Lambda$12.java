package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Task;
import com.google.common.base.Function;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreClient$$Lambda$12 implements Callable {
    private final FirestoreClient arg$1;
    private final Function arg$2;

    private FirestoreClient$$Lambda$12(FirestoreClient firestoreClient, Function function) {
        this.arg$1 = firestoreClient;
        this.arg$2 = function;
    }

    public static Callable lambdaFactory$(FirestoreClient firestoreClient, Function function) {
        return new FirestoreClient$$Lambda$12(firestoreClient, function);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Task transaction;
        transaction = r0.syncEngine.transaction(this.arg$1.asyncQueue, this.arg$2);
        return transaction;
    }
}
