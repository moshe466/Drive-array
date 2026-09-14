package io.grpc.internal;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public interface ObjectPool<T> {
    T getObject();

    T returnObject(Object obj);
}
