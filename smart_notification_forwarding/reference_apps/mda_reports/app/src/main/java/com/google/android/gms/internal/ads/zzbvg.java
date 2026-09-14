package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes.dex */
final class zzbvg implements zzbmi<zzbmj> {
    private final zzbwz zzfea;
    private final Map<String, zzcio<zzbmj>> zzfft;
    private final zzdxp<zzbmi<zzbkk>> zzfjs;
    private final Map<String, zzcio<zzbwk>> zzfjt;
    private final Map<String, zzckr<zzbwk>> zzfju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvg(Map<String, zzcio<zzbmj>> map, Map<String, zzcio<zzbwk>> map2, Map<String, zzckr<zzbwk>> map3, zzdxp<zzbmi<zzbkk>> zzdxpVar, zzbwz zzbwzVar) {
        this.zzfft = map;
        this.zzfjt = map2;
        this.zzfju = map3;
        this.zzfjs = zzdxpVar;
        this.zzfea = zzbwzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    @Nullable
    public final zzcio<zzbmj> zzd(int i, String str) {
        zzcio<zzbkk> zzd;
        zzcio<zzbmj> zzcioVar = this.zzfft.get(str);
        if (zzcioVar != null) {
            return zzcioVar;
        }
        if (i == 1) {
            if (this.zzfea.zzajs() == null || (zzd = this.zzfjs.get().zzd(i, str)) == null) {
                return null;
            }
            return zzbmj.zza(zzd);
        }
        if (i != 4) {
            return null;
        }
        zzckr<zzbwk> zzckrVar = this.zzfju.get(str);
        if (zzckrVar != null) {
            return zzbmj.zza((zzckr<? extends zzbmd>) zzckrVar);
        }
        zzcio<zzbwk> zzcioVar2 = this.zzfjt.get(str);
        if (zzcioVar2 != null) {
            return zzbmj.zza(zzcioVar2);
        }
        return null;
    }
}
