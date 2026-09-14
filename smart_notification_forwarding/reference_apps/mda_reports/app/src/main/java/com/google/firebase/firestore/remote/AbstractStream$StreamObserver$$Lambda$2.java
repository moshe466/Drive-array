package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;

/* loaded from: classes2.dex */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$2 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;
    private final Object arg$2;

    private AbstractStream$StreamObserver$$Lambda$2(AbstractStream.StreamObserver streamObserver, Object obj) {
        this.arg$1 = streamObserver;
        this.arg$2 = obj;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver, Object obj) {
        return new AbstractStream$StreamObserver$$Lambda$2(streamObserver, obj);
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractStream.StreamObserver.a(this.arg$1, this.arg$2);
    }
}
