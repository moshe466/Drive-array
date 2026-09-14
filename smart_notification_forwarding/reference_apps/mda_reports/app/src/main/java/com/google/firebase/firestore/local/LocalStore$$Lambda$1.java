package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
final /* synthetic */ class LocalStore$$Lambda$1 implements Runnable {
    private final LocalStore arg$1;

    private LocalStore$$Lambda$1(LocalStore localStore) {
        this.arg$1 = localStore;
    }

    public static Runnable lambdaFactory$(LocalStore localStore) {
        return new LocalStore$$Lambda$1(localStore);
    }

    @Override // java.lang.Runnable
    public void run() {
        LocalStore.a(this.arg$1);
    }
}
