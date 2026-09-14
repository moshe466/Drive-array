package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfl extends zzfw {
    private final boolean zzzx;

    public zzfl(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 61);
        this.zzzx = zzeiVar.zzce();
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        long longValue = ((Long) this.c.invoke(null, this.a.getContext(), Boolean.valueOf(this.zzzx))).longValue();
        synchronized (this.b) {
            this.b.zzbo(longValue);
        }
    }
}
