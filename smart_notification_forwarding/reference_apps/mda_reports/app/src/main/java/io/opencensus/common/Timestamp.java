package io.opencensus.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class Timestamp implements Comparable<Timestamp> {
    public static Timestamp create(long j, int i) {
        if (j < -315576000000L) {
            throw new IllegalArgumentException("'seconds' is less than minimum (-315576000000): " + j);
        }
        if (j > 315576000000L) {
            throw new IllegalArgumentException("'seconds' is greater than maximum (315576000000): " + j);
        }
        if (i < 0) {
            throw new IllegalArgumentException("'nanos' is less than zero: " + i);
        }
        if (i <= 999999999) {
            return new AutoValue_Timestamp(j, i);
        }
        throw new IllegalArgumentException("'nanos' is greater than maximum (999999999): " + i);
    }

    private static long floorDiv(long j, long j2) {
        return BigDecimal.valueOf(j).divide(BigDecimal.valueOf(j2), 0, RoundingMode.FLOOR).longValue();
    }

    private static long floorMod(long j, long j2) {
        return j - (floorDiv(j, j2) * j2);
    }

    public static Timestamp fromMillis(long j) {
        return create(floorDiv(j, 1000L), (int) (((int) floorMod(j, 1000L)) * 1000000));
    }

    private static Timestamp ofEpochSecond(long j, long j2) {
        return create(TimeUtils.a(j, floorDiv(j2, 1000000000L)), (int) floorMod(j2, 1000000000L));
    }

    private Timestamp plus(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(TimeUtils.a(TimeUtils.a(getSeconds(), j), j2 / 1000000000), getNanos() + (j2 % 1000000000));
    }

    public Timestamp addDuration(Duration duration) {
        return plus(duration.getSeconds(), duration.getNanos());
    }

    public Timestamp addNanos(long j) {
        return plus(0L, j);
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp timestamp) {
        int b = TimeUtils.b(getSeconds(), timestamp.getSeconds());
        return b != 0 ? b : TimeUtils.b(getNanos(), timestamp.getNanos());
    }

    public abstract int getNanos();

    public abstract long getSeconds();

    public Duration subtractTimestamp(Timestamp timestamp) {
        long j;
        long seconds = getSeconds() - timestamp.getSeconds();
        int nanos = getNanos() - timestamp.getNanos();
        if (seconds >= 0 || nanos <= 0) {
            if (seconds > 0 && nanos < 0) {
                seconds--;
                j = nanos + 1000000000;
            }
            return Duration.create(seconds, nanos);
        }
        seconds++;
        j = nanos - 1000000000;
        nanos = (int) j;
        return Duration.create(seconds, nanos);
    }
}
