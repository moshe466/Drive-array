package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;
import io.grpc.Metadata;

/* loaded from: classes2.dex */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$1 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;
    private final Metadata arg$2;

    private AbstractStream$StreamObserver$$Lambda$1(AbstractStream.StreamObserver streamObserver, Metadata metadata) {
        this.arg$1 = streamObserver;
        this.arg$2 = metadata;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver, Metadata metadata) {
        return new AbstractStream$StreamObserver$$Lambda$1(streamObserver, metadata);
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractStream.StreamObserver.a(this.arg$1, this.arg$2);
    }
}
