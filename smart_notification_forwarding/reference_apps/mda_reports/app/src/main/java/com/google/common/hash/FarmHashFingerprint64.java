package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;
    static final HashFunction a = new FarmHashFingerprint64();

    FarmHashFingerprint64() {
    }

    @VisibleForTesting
    static long a(byte[] bArr, int i, int i2) {
        return i2 <= 32 ? i2 <= 16 ? hashLength0to16(bArr, i, i2) : hashLength17to32(bArr, i, i2) : i2 <= 64 ? hashLength33To64(bArr, i, i2) : hashLength65Plus(bArr, i, i2);
    }

    private static long hashLength0to16(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = (i2 * 2) + K2;
            long b = LittleEndianByteArray.b(bArr, i) + K2;
            long b2 = LittleEndianByteArray.b(bArr, (i + i2) - 8);
            return hashLength16((Long.rotateRight(b2, 37) * j) + b, (Long.rotateRight(b, 25) + b2) * j, j);
        }
        if (i2 >= 4) {
            return hashLength16(i2 + ((LittleEndianByteArray.a(bArr, i) & 4294967295L) << 3), LittleEndianByteArray.a(bArr, (i + i2) - 4) & 4294967295L, (i2 * 2) + K2);
        }
        if (i2 <= 0) {
            return K2;
        }
        return shiftMix((((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8)) * K2) ^ ((i2 + ((bArr[i + (i2 - 1)] & 255) << 2)) * K0)) * K2;
    }

    private static long hashLength16(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private static long hashLength17to32(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) + K2;
        long b = LittleEndianByteArray.b(bArr, i) * K1;
        long b2 = LittleEndianByteArray.b(bArr, i + 8);
        int i3 = i + i2;
        long b3 = LittleEndianByteArray.b(bArr, i3 - 8) * j;
        return hashLength16((LittleEndianByteArray.b(bArr, i3 - 16) * K2) + Long.rotateRight(b + b2, 43) + Long.rotateRight(b3, 30), b + Long.rotateRight(b2 + K2, 18) + b3, j);
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) + K2;
        long b = LittleEndianByteArray.b(bArr, i) * K2;
        long b2 = LittleEndianByteArray.b(bArr, i + 8);
        int i3 = i + i2;
        long b3 = LittleEndianByteArray.b(bArr, i3 - 8) * j;
        long rotateRight = Long.rotateRight(b + b2, 43) + Long.rotateRight(b3, 30) + (LittleEndianByteArray.b(bArr, i3 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, b3 + Long.rotateRight(b2 + K2, 18) + b, j);
        long b4 = LittleEndianByteArray.b(bArr, i + 16) * j;
        long b5 = LittleEndianByteArray.b(bArr, i + 24);
        long b6 = (rotateRight + LittleEndianByteArray.b(bArr, i3 - 32)) * j;
        return hashLength16(((hashLength16 + LittleEndianByteArray.b(bArr, i3 - 24)) * j) + Long.rotateRight(b4 + b5, 43) + Long.rotateRight(b6, 30), b4 + Long.rotateRight(b5 + b, 18) + b6, j);
    }

    private static long hashLength65Plus(byte[] bArr, int i, int i2) {
        long shiftMix = shiftMix(-7956866745689871395L) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long b = 95310865018149119L + LittleEndianByteArray.b(bArr, i);
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = (i4 + i5) - 63;
        long j = 2480279821605975764L;
        int i7 = i;
        while (true) {
            long rotateRight = Long.rotateRight(b + j + jArr[0] + LittleEndianByteArray.b(bArr, i7 + 8), 37) * K1;
            long rotateRight2 = Long.rotateRight(j + jArr[1] + LittleEndianByteArray.b(bArr, i7 + 48), 42) * K1;
            long j2 = rotateRight ^ jArr2[1];
            long b2 = rotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr, i7 + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i7, jArr[1] * K1, j2 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i7 + 32, rotateRight3 + jArr2[1], b2 + LittleEndianByteArray.b(bArr, i7 + 16), jArr2);
            i7 += 64;
            if (i7 == i4) {
                long j3 = ((j2 & 255) << 1) + K1;
                jArr2[0] = jArr2[0] + i5;
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long rotateRight4 = Long.rotateRight(rotateRight3 + b2 + jArr[0] + LittleEndianByteArray.b(bArr, i6 + 8), 37) * j3;
                long rotateRight5 = Long.rotateRight(b2 + jArr[1] + LittleEndianByteArray.b(bArr, i6 + 48), 42) * j3;
                long j4 = rotateRight4 ^ (jArr2[1] * 9);
                long b3 = rotateRight5 + (jArr[0] * 9) + LittleEndianByteArray.b(bArr, i6 + 40);
                long rotateRight6 = Long.rotateRight(j2 + jArr2[0], 33) * j3;
                weakHashLength32WithSeeds(bArr, i6, jArr[1] * j3, j4 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr, i6 + 32, rotateRight6 + jArr2[1], LittleEndianByteArray.b(bArr, i6 + 16) + b3, jArr2);
                return hashLength16(hashLength16(jArr[0], jArr2[0], j3) + (shiftMix(b3) * K0) + j4, hashLength16(jArr[1], jArr2[1], j3) + rotateRight6, j3);
            }
            shiftMix = j2;
            j = b2;
            b = rotateRight3;
        }
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long b = LittleEndianByteArray.b(bArr, i);
        long b2 = LittleEndianByteArray.b(bArr, i + 8);
        long b3 = LittleEndianByteArray.b(bArr, i + 16);
        long b4 = LittleEndianByteArray.b(bArr, i + 24);
        long j3 = j + b;
        long j4 = b2 + j3 + b3;
        long rotateRight = Long.rotateRight(j2 + j3 + b4, 21) + Long.rotateRight(j4, 44);
        jArr[0] = j4 + b4;
        jArr[1] = rotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(a(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
