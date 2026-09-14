package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

/* loaded from: classes.dex */
class RandomBackoff implements Backoff {
    final Backoff a;
    final Random b;
    final double c;

    public RandomBackoff(Backoff backoff, double d) {
        this(backoff, d, new Random());
    }

    public RandomBackoff(Backoff backoff, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (backoff == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random == null) {
            throw new NullPointerException("random must not be null");
        }
        this.a = backoff;
        this.c = d;
        this.b = random;
    }

    double a() {
        double d = this.c;
        double d2 = 1.0d - d;
        return d2 + (((d + 1.0d) - d2) * this.b.nextDouble());
    }

    @Override // io.fabric.sdk.android.services.concurrency.internal.Backoff
    public long getDelayMillis(int i) {
        double a = a();
        double delayMillis = this.a.getDelayMillis(i);
        Double.isNaN(delayMillis);
        return (long) (a * delayMillis);
    }
}
