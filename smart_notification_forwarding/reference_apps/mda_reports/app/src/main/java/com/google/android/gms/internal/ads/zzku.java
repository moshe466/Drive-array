package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzku {
    public final int[] zzamp;
    public final long[] zzamq;
    public final int zzavf;
    public final int zzawo;
    public final int[] zzawq;
    public final long[] zzaxq;

    public zzku(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        zzoc.checkArgument(iArr.length == jArr2.length);
        zzoc.checkArgument(jArr.length == jArr2.length);
        zzoc.checkArgument(iArr2.length == jArr2.length);
        this.zzamq = jArr;
        this.zzamp = iArr;
        this.zzawo = i;
        this.zzaxq = jArr2;
        this.zzawq = iArr2;
        this.zzavf = jArr.length;
    }

    public final int zzec(long j) {
        for (int zza = zzoq.zza(this.zzaxq, j, true, false); zza >= 0; zza--) {
            if ((this.zzawq[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int zzb = zzoq.zzb(this.zzaxq, j, true, false); zzb < this.zzaxq.length; zzb++) {
            if ((this.zzawq[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
