package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfr extends zzfw {
    private final View zzzl;

    public zzfr(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2, View view) {
        super(zzeiVar, str, str2, zzbVar, i, 57);
        this.zzzl = view;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (this.zzzl != null) {
            Boolean bool = (Boolean) zzve.zzoy().zzd(zzzn.zzclp);
            zzes zzesVar = new zzes((String) this.c.invoke(null, this.zzzl, this.a.getContext().getResources().getDisplayMetrics(), bool));
            zzbs.zza.zzf.C0014zza zzat = zzbs.zza.zzf.zzat();
            zzat.zzdc(zzesVar.zzzf.longValue()).zzdd(zzesVar.zzzg.longValue()).zzde(zzesVar.zzzh.longValue());
            if (bool.booleanValue()) {
                zzat.zzdf(zzesVar.zzzi.longValue());
            }
            this.b.zzb((zzbs.zza.zzf) zzat.zzbaf());
        }
    }
}
