package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfn extends zzfw {
    public zzfn(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        synchronized (this.b) {
            zzej zzejVar = new zzej((String) this.c.invoke(null, new Object[0]));
            this.b.zzbj(zzejVar.zzya.longValue());
            this.b.zzbk(zzejVar.zzyb.longValue());
        }
    }
}
