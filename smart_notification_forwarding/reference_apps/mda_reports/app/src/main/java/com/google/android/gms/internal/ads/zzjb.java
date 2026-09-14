package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzjb implements zzjm {
    private final int length;
    private final long zzagj;
    private final int[] zzamp;
    private final long[] zzamq;
    private final long[] zzamr;
    private final long[] zzams;

    public zzjb(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzamp = iArr;
        this.zzamq = jArr;
        this.zzamr = jArr2;
        this.zzams = jArr3;
        this.length = iArr.length;
        int i = this.length;
        if (i > 0) {
            this.zzagj = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.zzagj = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjm
    public final long getDurationUs() {
        return this.zzagj;
    }

    @Override // com.google.android.gms.internal.ads.zzjm
    public final long zzdz(long j) {
        return this.zzamq[zzoq.zza(this.zzams, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzjm
    public final boolean zzgh() {
        return true;
    }
}
