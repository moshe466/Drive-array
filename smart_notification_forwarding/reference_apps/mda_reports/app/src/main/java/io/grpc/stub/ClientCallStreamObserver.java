package io.grpc.stub;

import io.grpc.ExperimentalApi;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1788")
/* loaded from: classes2.dex */
public abstract class ClientCallStreamObserver<V> extends CallStreamObserver<V> {
    public abstract void cancel(@Nullable String str, @Nullable Throwable th);
}
