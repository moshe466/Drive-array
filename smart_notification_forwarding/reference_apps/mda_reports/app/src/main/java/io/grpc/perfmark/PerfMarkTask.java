package io.grpc.perfmark;

import java.io.Closeable;

/* loaded from: classes2.dex */
public abstract class PerfMarkTask implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();
}
