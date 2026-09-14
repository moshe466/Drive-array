package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreChannel$$Lambda$3 implements OnCompleteListener {
    private final FirestoreChannel arg$1;
    private final TaskCompletionSource arg$2;
    private final Object arg$3;

    private FirestoreChannel$$Lambda$3(FirestoreChannel firestoreChannel, TaskCompletionSource taskCompletionSource, Object obj) {
        this.arg$1 = firestoreChannel;
        this.arg$2 = taskCompletionSource;
        this.arg$3 = obj;
    }

    public static OnCompleteListener lambdaFactory$(FirestoreChannel firestoreChannel, TaskCompletionSource taskCompletionSource, Object obj) {
        return new FirestoreChannel$$Lambda$3(firestoreChannel, taskCompletionSource, obj);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        FirestoreChannel.a(this.arg$1, this.arg$2, this.arg$3, task);
    }
}
