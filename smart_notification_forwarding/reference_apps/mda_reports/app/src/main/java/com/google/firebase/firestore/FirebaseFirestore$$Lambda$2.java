package com.google.firebase.firestore;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseFirestore$$Lambda$2 implements Runnable {
    private final FirebaseFirestore arg$1;
    private final TaskCompletionSource arg$2;

    private FirebaseFirestore$$Lambda$2(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        this.arg$1 = firebaseFirestore;
        this.arg$2 = taskCompletionSource;
    }

    public static Runnable lambdaFactory$(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        return new FirebaseFirestore$$Lambda$2(firebaseFirestore, taskCompletionSource);
    }

    @Override // java.lang.Runnable
    public void run() {
        FirebaseFirestore.a(this.arg$1, this.arg$2);
    }
}
