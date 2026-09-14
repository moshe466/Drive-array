package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.RetryState;

/* loaded from: classes.dex */
class RetryManager {
    private static final long NANOSECONDS_IN_MS = 1000000;
    long a;
    private RetryState retryState;

    public RetryManager(RetryState retryState) {
        if (retryState == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.retryState = retryState;
    }

    public boolean canRetry(long j) {
        return j - this.a >= this.retryState.getRetryDelay() * NANOSECONDS_IN_MS;
    }

    public void recordRetry(long j) {
        this.a = j;
        this.retryState = this.retryState.nextRetryState();
    }

    public void reset() {
        this.a = 0L;
        this.retryState = this.retryState.initialRetryState();
    }
}
