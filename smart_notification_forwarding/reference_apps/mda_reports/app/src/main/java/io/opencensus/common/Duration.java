package io.opencensus.common;

import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class Duration implements Comparable<Duration> {
    public static Duration create(long j, int i) {
        if (j < -315576000000L) {
            throw new IllegalArgumentException("'seconds' is less than minimum (-315576000000): " + j);
        }
        if (j > 315576000000L) {
            throw new IllegalArgumentException("'seconds' is greater than maximum (315576000000): " + j);
        }
        if (i < -999999999) {
            throw new IllegalArgumentException("'nanos' is less than minimum (-999999999): " + i);
        }
        if (i > 999999999) {
            throw new IllegalArgumentException("'nanos' is greater than maximum (999999999): " + i);
        }
        if ((j >= 0 || i <= 0) && (j <= 0 || i >= 0)) {
            return new AutoValue_Duration(j, i);
        }
        throw new IllegalArgumentException("'seconds' and 'nanos' have inconsistent sign: seconds=" + j + ", nanos=" + i);
    }

    public static Duration fromMillis(long j) {
        return create(j / 1000, (int) ((j % 1000) * 1000000));
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int b = TimeUtils.b(getSeconds(), duration.getSeconds());
        return b != 0 ? b : TimeUtils.b(getNanos(), duration.getNanos());
    }

    public abstract int getNanos();

    public abstract long getSeconds();

    public long toMillis() {
        return TimeUnit.SECONDS.toMillis(getSeconds()) + TimeUnit.NANOSECONDS.toMillis(getNanos());
    }
}
