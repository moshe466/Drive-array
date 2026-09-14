package com.google.firebase.functions;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseContextProvider$$Lambda$1 implements Continuation {
    private final FirebaseContextProvider arg$1;

    private FirebaseContextProvider$$Lambda$1(FirebaseContextProvider firebaseContextProvider) {
        this.arg$1 = firebaseContextProvider;
    }

    public static Continuation lambdaFactory$(FirebaseContextProvider firebaseContextProvider) {
        return new FirebaseContextProvider$$Lambda$1(firebaseContextProvider);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FirebaseContextProvider.a(this.arg$1, task);
    }
}
