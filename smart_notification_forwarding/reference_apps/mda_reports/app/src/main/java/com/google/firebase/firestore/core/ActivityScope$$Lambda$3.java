package com.google.firebase.firestore.core;

import com.google.firebase.firestore.ListenerRegistration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class ActivityScope$$Lambda$3 implements Runnable {
    private final ListenerRegistration arg$1;

    private ActivityScope$$Lambda$3(ListenerRegistration listenerRegistration) {
        this.arg$1 = listenerRegistration;
    }

    public static Runnable lambdaFactory$(ListenerRegistration listenerRegistration) {
        return new ActivityScope$$Lambda$3(listenerRegistration);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.remove();
    }
}
