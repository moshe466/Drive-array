package io.grpc.internal;

/* loaded from: classes2.dex */
final class LongCounterFactory {
    LongCounterFactory() {
    }

    public static LongCounter create() {
        return ReflectionLongAdderCounter.a() ? new ReflectionLongAdderCounter() : new AtomicLongCounter();
    }
}
