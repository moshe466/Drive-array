package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class LocalStore$$Lambda$6 implements Supplier {
    private final LocalStore arg$1;
    private final RemoteEvent arg$2;
    private final SnapshotVersion arg$3;

    private LocalStore$$Lambda$6(LocalStore localStore, RemoteEvent remoteEvent, SnapshotVersion snapshotVersion) {
        this.arg$1 = localStore;
        this.arg$2 = remoteEvent;
        this.arg$3 = snapshotVersion;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, RemoteEvent remoteEvent, SnapshotVersion snapshotVersion) {
        return new LocalStore$$Lambda$6(localStore, remoteEvent, snapshotVersion);
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public Object get() {
        return LocalStore.a(this.arg$1, this.arg$2, this.arg$3);
    }
}
