package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsy;

/* loaded from: classes.dex */
public final class zztp extends zzdvq<zztp> {
    public String zzbzo = null;
    private zzsy.zzb[] zzbzp = new zzsy.zzb[0];
    private zzte zzbzq = null;
    private zzte zzbzr = null;
    private zzte zzbzs = null;

    public zztp() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        String str = this.zzbzo;
        if (str != null) {
            a += zzdvo.zzg(1, str);
        }
        zzsy.zzb[] zzbVarArr = this.zzbzp;
        if (zzbVarArr != null && zzbVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzsy.zzb[] zzbVarArr2 = this.zzbzp;
                if (i >= zzbVarArr2.length) {
                    break;
                }
                zzsy.zzb zzbVar = zzbVarArr2[i];
                if (zzbVar != null) {
                    a += zzdrb.zzc(2, zzbVar);
                }
                i++;
            }
        }
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        String str = this.zzbzo;
        if (str != null) {
            zzdvoVar.zzf(1, str);
        }
        zzsy.zzb[] zzbVarArr = this.zzbzp;
        if (zzbVarArr != null && zzbVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzsy.zzb[] zzbVarArr2 = this.zzbzp;
                if (i >= zzbVarArr2.length) {
                    break;
                }
                zzsy.zzb zzbVar = zzbVarArr2[i];
                if (zzbVar != null) {
                    zzdvoVar.zze(2, zzbVar);
                }
                i++;
            }
        }
        super.zza(zzdvoVar);
    }
}
