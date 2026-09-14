package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.AbstractMessageLite;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class ProtoStorageClient$$Lambda$1 implements Callable {
    private final ProtoStorageClient arg$1;
    private final AbstractMessageLite arg$2;

    private ProtoStorageClient$$Lambda$1(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) {
        this.arg$1 = protoStorageClient;
        this.arg$2 = abstractMessageLite;
    }

    public static Callable lambdaFactory$(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) {
        return new ProtoStorageClient$$Lambda$1(protoStorageClient, abstractMessageLite);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        ProtoStorageClient protoStorageClient = this.arg$1;
        AbstractMessageLite abstractMessageLite = this.arg$2;
        ProtoStorageClient.a(protoStorageClient, abstractMessageLite);
        return abstractMessageLite;
    }
}
