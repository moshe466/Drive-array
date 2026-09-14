package org.apache.tika.fork;

/* loaded from: classes.dex */
class TimeoutLimits {
    private final long parseTimeoutMS;
    private final long pulseMS;
    private final long waitTimeoutMS;

    public TimeoutLimits(long j2, long j3, long j4) {
        this.pulseMS = j2;
        this.parseTimeoutMS = j3;
        this.waitTimeoutMS = j4;
    }

    public long getParseTimeoutMS() {
        return this.parseTimeoutMS;
    }

    public long getPulseMS() {
        return this.pulseMS;
    }

    public long getWaitTimeoutMS() {
        return this.waitTimeoutMS;
    }
}
