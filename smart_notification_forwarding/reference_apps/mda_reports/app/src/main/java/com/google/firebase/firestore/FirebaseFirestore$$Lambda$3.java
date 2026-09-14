package com.google.firebase.firestore;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseFirestore$$Lambda$3 implements EventListener {
    private final Runnable arg$1;

    private FirebaseFirestore$$Lambda$3(Runnable runnable) {
        this.arg$1 = runnable;
    }

    public static EventListener lambdaFactory$(Runnable runnable) {
        return new FirebaseFirestore$$Lambda$3(runnable);
    }

    @Override // com.google.firebase.firestore.EventListener
    public void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        FirebaseFirestore.a(this.arg$1, (Void) obj, firebaseFirestoreException);
    }
}
