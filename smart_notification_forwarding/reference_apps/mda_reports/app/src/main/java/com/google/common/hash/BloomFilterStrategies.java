package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            long asLong = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                if (!lockFreeBitArray.a(i5 % b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            long asLong = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                z |= lockFreeBitArray.b(i5 % b);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            byte[] a = Hashing.murmur3_128().hashObject(t, funnel).a();
            long lowerEight = lowerEight(a);
            long upperEight = upperEight(a);
            long j = lowerEight;
            for (int i2 = 0; i2 < i; i2++) {
                if (!lockFreeBitArray.a((Long.MAX_VALUE & j) % b)) {
                    return false;
                }
                j += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long b = lockFreeBitArray.b();
            byte[] a = Hashing.murmur3_128().hashObject(t, funnel).a();
            long lowerEight = lowerEight(a);
            long upperEight = upperEight(a);
            long j = lowerEight;
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= lockFreeBitArray.b((Long.MAX_VALUE & j) % b);
                j += upperEight;
            }
            return z;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        final AtomicLongArray a;
        private final LongAddable bitCount;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LockFreeBitArray(long j) {
            this(new long[Ints.checkedCast(LongMath.divide(j, 64L, RoundingMode.CEILING))]);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.a = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long j = 0;
            for (long j2 : jArr) {
                j += Long.bitCount(j2);
            }
            this.bitCount.add(j);
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            long[] jArr = new long[atomicLongArray.length()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long a() {
            return this.bitCount.sum();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(LockFreeBitArray lockFreeBitArray) {
            long j;
            long j2;
            boolean z;
            Preconditions.checkArgument(this.a.length() == lockFreeBitArray.a.length(), "BitArrays must be of equal length (%s != %s)", this.a.length(), lockFreeBitArray.a.length());
            for (int i = 0; i < this.a.length(); i++) {
                long j3 = lockFreeBitArray.a.get(i);
                while (true) {
                    j = this.a.get(i);
                    j2 = j | j3;
                    if (j != j2) {
                        if (this.a.compareAndSet(i, j, j2)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.bitCount.add(Long.bitCount(j2) - Long.bitCount(j));
                }
            }
        }

        boolean a(long j) {
            return ((1 << ((int) j)) & this.a.get((int) (j >>> 6))) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long b() {
            return this.a.length() * 64;
        }

        boolean b(long j) {
            long j2;
            long j3;
            if (a(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.bitCount.increment();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LockFreeBitArray c() {
            return new LockFreeBitArray(toPlainArray(this.a));
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.a), toPlainArray(((LockFreeBitArray) obj).a));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.a));
        }
    }
}
