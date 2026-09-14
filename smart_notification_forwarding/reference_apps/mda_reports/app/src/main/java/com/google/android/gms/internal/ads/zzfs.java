package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfs extends zzfw {
    public zzfs(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        zzbs.zza.zzb zzbVar;
        zzcd zzcdVar;
        this.b.zze(zzcd.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.c.invoke(null, this.a.getContext())).booleanValue();
        synchronized (this.b) {
            if (booleanValue) {
                zzbVar = this.b;
                zzcdVar = zzcd.ENUM_TRUE;
            } else {
                zzbVar = this.b;
                zzcdVar = zzcd.ENUM_FALSE;
            }
            zzbVar.zze(zzcdVar);
        }
    }
}
