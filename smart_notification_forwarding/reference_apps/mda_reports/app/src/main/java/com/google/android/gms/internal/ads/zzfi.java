package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfi extends zzfw {
    private long zzzw;

    public zzfi(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 12);
        this.zzzw = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        this.b.zzap(-1L);
        this.b.zzap(((Long) this.c.invoke(null, this.a.getContext())).longValue());
    }
}
