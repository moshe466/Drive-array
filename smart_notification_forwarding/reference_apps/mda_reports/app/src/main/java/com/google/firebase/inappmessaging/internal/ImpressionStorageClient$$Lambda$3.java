package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class ImpressionStorageClient$$Lambda$3 implements Consumer {
    private final ImpressionStorageClient arg$1;

    private ImpressionStorageClient$$Lambda$3(ImpressionStorageClient impressionStorageClient) {
        this.arg$1 = impressionStorageClient;
    }

    public static Consumer lambdaFactory$(ImpressionStorageClient impressionStorageClient) {
        return new ImpressionStorageClient$$Lambda$3(impressionStorageClient);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        ImpressionStorageClient.a(this.arg$1, (Throwable) obj);
    }
}
