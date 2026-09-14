package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;
import java.util.Date;

/* loaded from: classes2.dex */
public class ExponentialBackoff {
    public static final double DEFAULT_BACKOFF_FACTOR = 1.5d;
    public static final long DEFAULT_BACKOFF_INITIAL_DELAY_MS = 1000;
    public static final long DEFAULT_BACKOFF_MAX_DELAY_MS = 60000;
    private final double backoffFactor;
    private long currentBaseMs;
    private final long initialDelayMs;
    private long lastAttemptTime;
    private final long maxDelayMs;
    private final AsyncQueue queue;
    private final AsyncQueue.TimerId timerId;
    private AsyncQueue.DelayedTask timerTask;

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        this(asyncQueue, timerId, 1000L, 1.5d, DEFAULT_BACKOFF_MAX_DELAY_MS);
    }

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId, long j, double d, long j2) {
        this.queue = asyncQueue;
        this.timerId = timerId;
        this.initialDelayMs = j;
        this.backoffFactor = d;
        this.maxDelayMs = j2;
        this.lastAttemptTime = new Date().getTime();
        reset();
    }

    public static /* synthetic */ void a(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        exponentialBackoff.lastAttemptTime = new Date().getTime();
        runnable.run();
    }

    private long jitterDelayMs() {
        double random = Math.random() - 0.5d;
        double d = this.currentBaseMs;
        Double.isNaN(d);
        return (long) (random * d);
    }

    public void backoffAndRun(Runnable runnable) {
        cancel();
        long jitterDelayMs = this.currentBaseMs + jitterDelayMs();
        long max = Math.max(0L, new Date().getTime() - this.lastAttemptTime);
        long max2 = Math.max(0L, jitterDelayMs - max);
        if (this.currentBaseMs > 0) {
            Logger.debug(ExponentialBackoff.class.getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(max2), Long.valueOf(this.currentBaseMs), Long.valueOf(jitterDelayMs), Long.valueOf(max));
        }
        this.timerTask = this.queue.enqueueAfterDelay(this.timerId, max2, ExponentialBackoff$$Lambda$1.lambdaFactory$(this, runnable));
        double d = this.currentBaseMs;
        double d2 = this.backoffFactor;
        Double.isNaN(d);
        this.currentBaseMs = (long) (d * d2);
        long j = this.currentBaseMs;
        long j2 = this.initialDelayMs;
        if (j >= j2) {
            j2 = this.maxDelayMs;
            if (j <= j2) {
                return;
            }
        }
        this.currentBaseMs = j2;
    }

    public void cancel() {
        AsyncQueue.DelayedTask delayedTask = this.timerTask;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.timerTask = null;
        }
    }

    public void reset() {
        this.currentBaseMs = 0L;
    }

    public void resetToMax() {
        this.currentBaseMs = this.maxDelayMs;
    }
}
