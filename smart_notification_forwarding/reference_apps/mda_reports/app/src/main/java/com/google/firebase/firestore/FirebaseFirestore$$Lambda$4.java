package com.google.firebase.firestore;

import com.google.firebase.firestore.core.AsyncEventListener;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseFirestore$$Lambda$4 implements ListenerRegistration {
    private final FirebaseFirestore arg$1;
    private final AsyncEventListener arg$2;

    private FirebaseFirestore$$Lambda$4(FirebaseFirestore firebaseFirestore, AsyncEventListener asyncEventListener) {
        this.arg$1 = firebaseFirestore;
        this.arg$2 = asyncEventListener;
    }

    public static ListenerRegistration lambdaFactory$(FirebaseFirestore firebaseFirestore, AsyncEventListener asyncEventListener) {
        return new FirebaseFirestore$$Lambda$4(firebaseFirestore, asyncEventListener);
    }

    @Override // com.google.firebase.firestore.ListenerRegistration
    public void remove() {
        FirebaseFirestore.a(this.arg$1, this.arg$2);
    }
}
