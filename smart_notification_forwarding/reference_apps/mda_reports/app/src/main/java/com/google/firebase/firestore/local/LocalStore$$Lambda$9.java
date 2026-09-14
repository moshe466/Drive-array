package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
final /* synthetic */ class LocalStore$$Lambda$9 implements Runnable {
    private final LocalStore arg$1;
    private final int arg$2;

    private LocalStore$$Lambda$9(LocalStore localStore, int i) {
        this.arg$1 = localStore;
        this.arg$2 = i;
    }

    public static Runnable lambdaFactory$(LocalStore localStore, int i) {
        return new LocalStore$$Lambda$9(localStore, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        LocalStore.b(this.arg$1, this.arg$2);
    }
}
