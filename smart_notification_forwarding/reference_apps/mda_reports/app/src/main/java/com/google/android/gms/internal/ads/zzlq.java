package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzlq implements zzmn {
    private final zzmn[] zzbas;

    public zzlq(zzmn[] zzmnVarArr) {
        this.zzbas = zzmnVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmn
    public final boolean zzef(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhh = zzhh();
            if (zzhh == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzmn zzmnVar : this.zzbas) {
                if (zzmnVar.zzhh() == zzhh) {
                    z |= zzmnVar.zzef(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzmn
    public final long zzhh() {
        long j = Long.MAX_VALUE;
        for (zzmn zzmnVar : this.zzbas) {
            long zzhh = zzmnVar.zzhh();
            if (zzhh != Long.MIN_VALUE) {
                j = Math.min(j, zzhh);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
