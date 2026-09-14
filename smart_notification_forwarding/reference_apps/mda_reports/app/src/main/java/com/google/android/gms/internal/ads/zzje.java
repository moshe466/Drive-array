package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzje implements zzjg {
    private static final byte[] zzamt = new byte[4096];
    private final zznl zzamu;
    private final long zzamv;
    private long zzamw;
    private byte[] zzamx = new byte[65536];
    private int zzamy;
    private int zzamz;

    public zzje(zznl zznlVar, long j, long j2) {
        this.zzamu = zznlVar;
        this.zzamw = j;
        this.zzamv = j2;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.zzamu.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private final int zzae(int i) {
        int min = Math.min(this.zzamz, i);
        zzaf(min);
        return min;
    }

    private final void zzaf(int i) {
        this.zzamz -= i;
        this.zzamy = 0;
        byte[] bArr = this.zzamx;
        int i2 = this.zzamz;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.zzamx, i, bArr, 0, this.zzamz);
        this.zzamx = bArr;
    }

    private final void zzag(int i) {
        if (i != -1) {
            this.zzamw += i;
        }
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzamz;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzamx, 0, bArr, i, min);
        zzaf(min);
        return min;
    }

    private final boolean zzd(int i, boolean z) {
        int i2 = this.zzamy + i;
        byte[] bArr = this.zzamx;
        if (i2 > bArr.length) {
            this.zzamx = Arrays.copyOf(this.zzamx, zzoq.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzamz - this.zzamy, i);
        while (min < i) {
            min = zza(this.zzamx, this.zzamy, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.zzamy += i;
        this.zzamz = Math.max(this.zzamz, this.zzamy);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final long getLength() {
        return this.zzamv;
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final long getPosition() {
        return this.zzamw;
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final int read(byte[] bArr, int i, int i2) {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzag(zzb);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final void readFully(byte[] bArr, int i, int i2) {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final void zza(byte[] bArr, int i, int i2) {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzamx, this.zzamy - i2, bArr, i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzag(zzb);
        return zzb != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final int zzab(int i) {
        int zzae = zzae(i);
        if (zzae == 0) {
            byte[] bArr = zzamt;
            zzae = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzag(zzae);
        return zzae;
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final void zzac(int i) {
        int zzae = zzae(i);
        while (zzae < i && zzae != -1) {
            byte[] bArr = zzamt;
            zzae = zza(bArr, -zzae, Math.min(i, bArr.length + zzae), zzae, false);
        }
        zzag(zzae);
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final void zzad(int i) {
        zzd(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjg
    public final void zzgi() {
        this.zzamy = 0;
    }
}
