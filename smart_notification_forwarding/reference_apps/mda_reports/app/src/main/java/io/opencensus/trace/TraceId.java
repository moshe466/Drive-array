package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Random;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public final class TraceId implements Comparable<TraceId> {
    private static final int BASE16_SIZE = 32;
    public static final TraceId INVALID = new TraceId(0, 0);
    private static final long INVALID_ID = 0;
    public static final int SIZE = 16;
    private final long idHi;
    private final long idLo;

    private TraceId(long j, long j2) {
        this.idHi = j;
        this.idLo = j2;
    }

    public static TraceId fromBytes(byte[] bArr) {
        Utils.checkNotNull(bArr, "src");
        Utils.checkArgument(bArr.length == 16, "Invalid size: expected %s, got %s", 16, Integer.valueOf(bArr.length));
        return fromBytes(bArr, 0);
    }

    public static TraceId fromBytes(byte[] bArr, int i) {
        Utils.checkNotNull(bArr, "src");
        return new TraceId(BigendianEncoding.a(bArr, i), BigendianEncoding.a(bArr, i + 8));
    }

    public static TraceId fromLowerBase16(CharSequence charSequence) {
        Utils.checkNotNull(charSequence, "src");
        Utils.checkArgument(charSequence.length() == 32, "Invalid size: expected %s, got %s", 32, Integer.valueOf(charSequence.length()));
        return fromLowerBase16(charSequence, 0);
    }

    public static TraceId fromLowerBase16(CharSequence charSequence, int i) {
        Utils.checkNotNull(charSequence, "src");
        return new TraceId(BigendianEncoding.b(charSequence, i), BigendianEncoding.b(charSequence, i + 16));
    }

    public static TraceId generateRandomId(Random random) {
        long nextLong;
        long nextLong2;
        do {
            nextLong = random.nextLong();
            nextLong2 = random.nextLong();
            if (nextLong != 0) {
                break;
            }
        } while (nextLong2 == 0);
        return new TraceId(nextLong, nextLong2);
    }

    @Override // java.lang.Comparable
    public int compareTo(TraceId traceId) {
        long j = this.idHi;
        long j2 = traceId.idHi;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        long j3 = this.idLo;
        long j4 = traceId.idLo;
        if (j3 == j4) {
            return 0;
        }
        return j3 < j4 ? -1 : 1;
    }

    public void copyBytesTo(byte[] bArr, int i) {
        BigendianEncoding.a(this.idHi, bArr, i);
        BigendianEncoding.a(this.idLo, bArr, i + 8);
    }

    public void copyLowerBase16To(char[] cArr, int i) {
        BigendianEncoding.a(this.idHi, cArr, i);
        BigendianEncoding.a(this.idLo, cArr, i + 16);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceId)) {
            return false;
        }
        TraceId traceId = (TraceId) obj;
        return this.idHi == traceId.idHi && this.idLo == traceId.idLo;
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[16];
        BigendianEncoding.a(this.idHi, bArr, 0);
        BigendianEncoding.a(this.idLo, bArr, 8);
        return bArr;
    }

    public long getLowerLong() {
        long j = this.idHi;
        return j < 0 ? -j : j;
    }

    public int hashCode() {
        long j = this.idHi;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        long j2 = this.idLo;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isValid() {
        return (this.idHi == 0 && this.idLo == 0) ? false : true;
    }

    public String toLowerBase16() {
        char[] cArr = new char[32];
        copyLowerBase16To(cArr, 0);
        return new String(cArr);
    }

    public String toString() {
        return "TraceId{traceId=" + toLowerBase16() + "}";
    }
}
