package com.google.firebase.firestore.remote;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class RemoteStore$$Lambda$3 implements Runnable {
    private final RemoteStore arg$1;

    private RemoteStore$$Lambda$3(RemoteStore remoteStore) {
        this.arg$1 = remoteStore;
    }

    public static Runnable lambdaFactory$(RemoteStore remoteStore) {
        return new RemoteStore$$Lambda$3(remoteStore);
    }

    @Override // java.lang.Runnable
    public void run() {
        RemoteStore.d(this.arg$1);
    }
}
