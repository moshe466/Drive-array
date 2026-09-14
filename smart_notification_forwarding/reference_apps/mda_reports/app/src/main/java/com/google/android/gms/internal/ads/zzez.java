package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzez extends zzfw {
    public zzez(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        this.b.zzam(-1L);
        this.b.zzan(-1L);
        int[] iArr = (int[]) this.c.invoke(null, this.a.getContext());
        synchronized (this.b) {
            this.b.zzam(iArr[0]);
            this.b.zzan(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.b.zzbm(iArr[2]);
            }
        }
    }
}
