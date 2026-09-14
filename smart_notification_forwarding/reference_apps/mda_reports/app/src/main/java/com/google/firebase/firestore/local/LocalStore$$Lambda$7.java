package com.google.firebase.firestore.local;

import java.util.List;

/* loaded from: classes2.dex */
final /* synthetic */ class LocalStore$$Lambda$7 implements Runnable {
    private final LocalStore arg$1;
    private final List arg$2;

    private LocalStore$$Lambda$7(LocalStore localStore, List list) {
        this.arg$1 = localStore;
        this.arg$2 = list;
    }

    public static Runnable lambdaFactory$(LocalStore localStore, List list) {
        return new LocalStore$$Lambda$7(localStore, list);
    }

    @Override // java.lang.Runnable
    public void run() {
        LocalStore.a(this.arg$1, this.arg$2);
    }
}
