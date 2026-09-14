package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class SmoothRateLimiter extends RateLimiter {
    double a;
    double b;
    double c;
    private long nextFreeTicketMicros;

    /* loaded from: classes2.dex */
    static final class SmoothBursty extends SmoothRateLimiter {
        final double d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d) {
            super(sleepingStopwatch);
            this.d = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void a(double d, double d2) {
            double d3;
            double d4 = this.b;
            this.b = this.d * d;
            if (d4 == Double.POSITIVE_INFINITY) {
                d3 = this.b;
            } else {
                d3 = 0.0d;
                if (d4 != 0.0d) {
                    d3 = (this.a * this.b) / d4;
                }
            }
            this.a = d3;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double b() {
            return this.c;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long b(double d, double d2) {
            return 0L;
        }
    }

    /* loaded from: classes2.dex */
    static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j, TimeUnit timeUnit, double d) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j);
            this.coldFactor = d;
        }

        private double permitsToTime(double d) {
            return this.c + (d * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void a(double d, double d2) {
            double d3 = this.b;
            double d4 = this.coldFactor * d2;
            long j = this.warmupPeriodMicros;
            double d5 = j;
            Double.isNaN(d5);
            this.thresholdPermits = (d5 * 0.5d) / d2;
            double d6 = this.thresholdPermits;
            double d7 = j;
            Double.isNaN(d7);
            this.b = ((d7 * 2.0d) / (d2 + d4)) + d6;
            double d8 = d4 - d2;
            double d9 = this.b;
            this.slope = d8 / (d9 - d6);
            if (d3 == Double.POSITIVE_INFINITY) {
                this.a = 0.0d;
                return;
            }
            if (d3 != 0.0d) {
                d9 = (this.a * d9) / d3;
            }
            this.a = d9;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double b() {
            double d = this.warmupPeriodMicros;
            double d2 = this.b;
            Double.isNaN(d);
            return d / d2;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long b(double d, double d2) {
            long j;
            double d3 = d - this.thresholdPermits;
            if (d3 > 0.0d) {
                double min = Math.min(d3, d2);
                j = (long) (((permitsToTime(d3) + permitsToTime(d3 - min)) * min) / 2.0d);
                d2 -= min;
            } else {
                j = 0;
            }
            return j + ((long) (this.c * d2));
        }
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double a() {
        double micros = TimeUnit.SECONDS.toMicros(1L);
        double d = this.c;
        Double.isNaN(micros);
        return micros / d;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long a(long j) {
        return this.nextFreeTicketMicros;
    }

    abstract void a(double d, double d2);

    @Override // com.google.common.util.concurrent.RateLimiter
    final void a(double d, long j) {
        b(j);
        double micros = TimeUnit.SECONDS.toMicros(1L);
        Double.isNaN(micros);
        double d2 = micros / d;
        this.c = d2;
        a(d, d2);
    }

    abstract double b();

    abstract long b(double d, double d2);

    @Override // com.google.common.util.concurrent.RateLimiter
    final long b(int i, long j) {
        b(j);
        long j2 = this.nextFreeTicketMicros;
        double d = i;
        double min = Math.min(d, this.a);
        Double.isNaN(d);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, b(this.a, min) + ((long) ((d - min) * this.c)));
        this.a -= min;
        return j2;
    }

    void b(long j) {
        long j2 = this.nextFreeTicketMicros;
        if (j > j2) {
            double d = j - j2;
            double b = b();
            Double.isNaN(d);
            this.a = Math.min(this.b, this.a + (d / b));
            this.nextFreeTicketMicros = j;
        }
    }
}
