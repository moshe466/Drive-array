package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnSuccessListener;
import io.grpc.ClientCall;

/* loaded from: classes2.dex */
final /* synthetic */ class FirestoreChannel$2$$Lambda$1 implements OnSuccessListener {
    private static final FirestoreChannel$2$$Lambda$1 instance = new FirestoreChannel$2$$Lambda$1();

    private FirestoreChannel$2$$Lambda$1() {
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((ClientCall) obj).halfClose();
    }
}
