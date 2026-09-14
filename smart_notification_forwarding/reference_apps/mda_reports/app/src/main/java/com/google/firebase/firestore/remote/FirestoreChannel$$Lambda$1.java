package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.grpc.ClientCall;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirestoreChannel$$Lambda$1 implements OnCompleteListener {
    private final FirestoreChannel arg$1;
    private final ClientCall[] arg$2;
    private final IncomingStreamObserver arg$3;

    private FirestoreChannel$$Lambda$1(FirestoreChannel firestoreChannel, ClientCall[] clientCallArr, IncomingStreamObserver incomingStreamObserver) {
        this.arg$1 = firestoreChannel;
        this.arg$2 = clientCallArr;
        this.arg$3 = incomingStreamObserver;
    }

    public static OnCompleteListener lambdaFactory$(FirestoreChannel firestoreChannel, ClientCall[] clientCallArr, IncomingStreamObserver incomingStreamObserver) {
        return new FirestoreChannel$$Lambda$1(firestoreChannel, clientCallArr, incomingStreamObserver);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        FirestoreChannel.a(this.arg$1, this.arg$2, this.arg$3, task);
    }
}
