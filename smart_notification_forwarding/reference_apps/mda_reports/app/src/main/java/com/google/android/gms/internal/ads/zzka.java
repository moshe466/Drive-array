package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzka {
    private static final long[] zzauk = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzane = new byte[8];

    public static long zza(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= zzauk[i - 1] ^ (-1);
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    public static int zzan(int i) {
        long j;
        int i2 = 0;
        do {
            long[] jArr = zzauk;
            if (i2 >= jArr.length) {
                return -1;
            }
            j = jArr[i2] & i;
            i2++;
        } while (j == 0);
        return i2;
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzjg zzjgVar, boolean z, boolean z2, int i) {
        if (this.state == 0) {
            if (!zzjgVar.zza(this.zzane, 0, 1, z)) {
                return -1L;
            }
            this.length = zzan(this.zzane[0] & 255);
            if (this.length == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.state = 1;
        }
        int i2 = this.length;
        if (i2 > i) {
            this.state = 0;
            return -2L;
        }
        if (i2 != 1) {
            zzjgVar.readFully(this.zzane, 1, i2 - 1);
        }
        this.state = 0;
        return zza(this.zzane, this.length, z2);
    }

    public final int zzgo() {
        return this.length;
    }
}
