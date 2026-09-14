package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbim implements zzdgf<zzczt, zzczt> {
    private Map<String, zzbil> zzfbi;

    public zzbim(Map<String, zzbil> map) {
        this.zzfbi = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final /* synthetic */ zzdhe<zzczt> zzf(zzczt zzcztVar) {
        zzczt zzcztVar2 = zzcztVar;
        for (zzczq zzczqVar : zzcztVar2.zzgmi.zzgmg) {
            if (this.zzfbi.containsKey(zzczqVar.name)) {
                this.zzfbi.get(zzczqVar.name).zzk(zzczqVar.zzgmd);
            }
        }
        return zzdgs.zzaj(zzcztVar2);
    }
}
