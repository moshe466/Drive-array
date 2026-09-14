package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.Parser;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class ProtoStorageClient$$Lambda$2 implements Callable {
    private final ProtoStorageClient arg$1;
    private final Parser arg$2;

    private ProtoStorageClient$$Lambda$2(ProtoStorageClient protoStorageClient, Parser parser) {
        this.arg$1 = protoStorageClient;
        this.arg$2 = parser;
    }

    public static Callable lambdaFactory$(ProtoStorageClient protoStorageClient, Parser parser) {
        return new ProtoStorageClient$$Lambda$2(protoStorageClient, parser);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return ProtoStorageClient.a(this.arg$1, this.arg$2);
    }
}
