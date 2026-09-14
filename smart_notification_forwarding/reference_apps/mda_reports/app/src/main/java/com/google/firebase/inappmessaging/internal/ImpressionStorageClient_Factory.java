package com.google.firebase.inappmessaging.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ImpressionStorageClient_Factory implements Factory<ImpressionStorageClient> {
    private final Provider<ProtoStorageClient> storageClientProvider;

    public ImpressionStorageClient_Factory(Provider<ProtoStorageClient> provider) {
        this.storageClientProvider = provider;
    }

    public static ImpressionStorageClient_Factory create(Provider<ProtoStorageClient> provider) {
        return new ImpressionStorageClient_Factory(provider);
    }

    public static ImpressionStorageClient newInstance(ProtoStorageClient protoStorageClient) {
        return new ImpressionStorageClient(protoStorageClient);
    }

    @Override // javax.inject.Provider
    public ImpressionStorageClient get() {
        return new ImpressionStorageClient(this.storageClientProvider.get());
    }
}
