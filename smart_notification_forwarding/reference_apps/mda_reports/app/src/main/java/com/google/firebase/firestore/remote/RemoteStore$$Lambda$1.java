package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.remote.OnlineStateTracker;
import com.google.firebase.firestore.remote.RemoteStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class RemoteStore$$Lambda$1 implements OnlineStateTracker.OnlineStateCallback {
    private final RemoteStore.RemoteStoreCallback arg$1;

    private RemoteStore$$Lambda$1(RemoteStore.RemoteStoreCallback remoteStoreCallback) {
        this.arg$1 = remoteStoreCallback;
    }

    public static OnlineStateTracker.OnlineStateCallback lambdaFactory$(RemoteStore.RemoteStoreCallback remoteStoreCallback) {
        return new RemoteStore$$Lambda$1(remoteStoreCallback);
    }

    @Override // com.google.firebase.firestore.remote.OnlineStateTracker.OnlineStateCallback
    public void handleOnlineStateChange(OnlineState onlineState) {
        this.arg$1.handleOnlineStateChange(onlineState);
    }
}
