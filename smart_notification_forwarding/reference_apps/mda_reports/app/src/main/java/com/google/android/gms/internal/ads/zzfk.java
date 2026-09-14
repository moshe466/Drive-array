package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfk extends zzfw {
    public zzfk(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        zzdu zzduVar = new zzdu((String) this.c.invoke(null, this.a.getContext(), Boolean.valueOf(((Boolean) zzve.zzoy().zzd(zzzn.zzcle)).booleanValue())));
        synchronized (this.b) {
            this.b.zzal(zzduVar.zzwx);
            this.b.zzbn(zzduVar.zzwy);
        }
    }
}
