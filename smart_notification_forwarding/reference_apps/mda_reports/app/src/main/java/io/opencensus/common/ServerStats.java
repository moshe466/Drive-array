package io.opencensus.common;

import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class ServerStats {
    public static ServerStats create(long j, long j2, byte b) {
        if (j < 0) {
            throw new IllegalArgumentException("'getLbLatencyNs' is less than zero: " + j);
        }
        if (j2 >= 0) {
            return new AutoValue_ServerStats(j, j2, b);
        }
        throw new IllegalArgumentException("'getServiceLatencyNs' is less than zero: " + j2);
    }

    public abstract long getLbLatencyNs();

    public abstract long getServiceLatencyNs();

    public abstract byte getTraceOption();
}
