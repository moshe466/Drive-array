package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;

/* loaded from: classes2.dex */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$3 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;

    private AbstractStream$StreamObserver$$Lambda$3(AbstractStream.StreamObserver streamObserver) {
        this.arg$1 = streamObserver;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver) {
        return new AbstractStream$StreamObserver$$Lambda$3(streamObserver);
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractStream.StreamObserver.a(this.arg$1);
    }
}
