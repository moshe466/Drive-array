package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreClient$$Lambda$9 implements Continuation {
    private static final FirestoreClient$$Lambda$9 instance = new FirestoreClient$$Lambda$9();

    private FirestoreClient$$Lambda$9() {
    }

    public static Continuation lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FirestoreClient.a(task);
    }
}
