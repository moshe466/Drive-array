package io.grpc;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class Deadline implements Comparable<Deadline> {
    private final long deadlineNanos;
    private volatile boolean expired;
    private final Ticker ticker;
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private static final long MAX_OFFSET = TimeUnit.DAYS.toNanos(36500);
    private static final long MIN_OFFSET = -MAX_OFFSET;
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);

    /* loaded from: classes2.dex */
    private static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        @Override // io.grpc.Deadline.Ticker
        public long read() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class Ticker {
        Ticker() {
        }

        public abstract long read();
    }

    private Deadline(Ticker ticker, long j, long j2, boolean z) {
        this.ticker = ticker;
        long min = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, j2));
        this.deadlineNanos = j + min;
        this.expired = z && min <= 0;
    }

    private Deadline(Ticker ticker, long j, boolean z) {
        this(ticker, ticker.read(), j, z);
    }

    static Deadline a(long j, TimeUnit timeUnit, Ticker ticker) {
        checkNotNull(timeUnit, "units");
        return new Deadline(ticker, timeUnit.toNanos(j), true);
    }

    public static Deadline after(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, SYSTEM_TICKER);
    }

    private static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @Override // java.lang.Comparable
    public int compareTo(Deadline deadline) {
        long j = this.deadlineNanos - deadline.deadlineNanos;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public boolean isBefore(Deadline deadline) {
        return this.deadlineNanos - deadline.deadlineNanos < 0;
    }

    public boolean isExpired() {
        if (!this.expired) {
            if (this.deadlineNanos - this.ticker.read() > 0) {
                return false;
            }
            this.expired = true;
        }
        return true;
    }

    public Deadline minimum(Deadline deadline) {
        return isBefore(deadline) ? this : deadline;
    }

    public Deadline offset(long j, TimeUnit timeUnit) {
        return j == 0 ? this : new Deadline(this.ticker, this.deadlineNanos, timeUnit.toNanos(j), isExpired());
    }

    public ScheduledFuture<?> runOnExpiration(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        checkNotNull(runnable, "task");
        checkNotNull(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(runnable, this.deadlineNanos - this.ticker.read(), TimeUnit.NANOSECONDS);
    }

    public long timeRemaining(TimeUnit timeUnit) {
        long read = this.ticker.read();
        if (!this.expired && this.deadlineNanos - read <= 0) {
            this.expired = true;
        }
        return timeUnit.convert(this.deadlineNanos - read, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long timeRemaining = timeRemaining(TimeUnit.NANOSECONDS);
        long abs = Math.abs(timeRemaining) / NANOS_PER_SECOND;
        long abs2 = Math.abs(timeRemaining) % NANOS_PER_SECOND;
        StringBuilder sb = new StringBuilder();
        if (timeRemaining < 0) {
            sb.append('-');
        }
        sb.append(abs);
        if (abs2 > 0) {
            sb.append(String.format(".%09d", Long.valueOf(abs2)));
        }
        sb.append("s from now");
        return sb.toString();
    }
}
