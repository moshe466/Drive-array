package io.grpc.internal;

import io.grpc.InternalChannelz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class CallTracer {
    static final Factory a = new Factory() { // from class: io.grpc.internal.CallTracer.1
        @Override // io.grpc.internal.CallTracer.Factory
        public CallTracer create() {
            return new CallTracer(TimeProvider.SYSTEM_TIME_PROVIDER);
        }
    };
    private volatile long lastCallStartedNanos;
    private final TimeProvider timeProvider;
    private final LongCounter callsStarted = LongCounterFactory.create();
    private final LongCounter callsSucceeded = LongCounterFactory.create();
    private final LongCounter callsFailed = LongCounterFactory.create();

    /* loaded from: classes2.dex */
    public interface Factory {
        CallTracer create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallTracer(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public static Factory getDefaultFactory() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InternalChannelz.ChannelStats.Builder builder) {
        builder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedNanos(this.lastCallStartedNanos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InternalChannelz.ServerStats.Builder builder) {
        builder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedNanos(this.lastCallStartedNanos);
    }

    public void reportCallEnded(boolean z) {
        (z ? this.callsSucceeded : this.callsFailed).add(1L);
    }

    public void reportCallStarted() {
        this.callsStarted.add(1L);
        this.lastCallStartedNanos = this.timeProvider.currentTimeNanos();
    }
}
