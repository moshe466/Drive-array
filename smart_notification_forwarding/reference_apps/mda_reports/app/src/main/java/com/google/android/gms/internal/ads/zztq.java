package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsy;

/* loaded from: classes.dex */
public final class zztq extends zzdvq<zztq> {
    public Integer zzbzt = null;
    private zzte zzbzu = null;
    private zzsy.zzc zzbzv = null;
    public zztp zzbzw = null;
    private zzsy.zzb[] zzbzx = new zzsy.zzb[0];
    private zzsy.zzd zzbzy = null;
    private zzsy.zzk zzbzz = null;
    private zzsy.zzi zzcaa = null;
    private zzsy.zzf zzcab = null;
    private zzsy.zzg zzcac = null;
    private zztw[] zzcad = zztw.zzoj();

    public zztq() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        Integer num = this.zzbzt;
        if (num != null) {
            a += zzdvo.zzaf(7, num.intValue());
        }
        zztp zztpVar = this.zzbzw;
        if (zztpVar != null) {
            a += zzdvo.zzb(10, zztpVar);
        }
        zzsy.zzb[] zzbVarArr = this.zzbzx;
        int i = 0;
        if (zzbVarArr != null && zzbVarArr.length > 0) {
            int i2 = a;
            int i3 = 0;
            while (true) {
                zzsy.zzb[] zzbVarArr2 = this.zzbzx;
                if (i3 >= zzbVarArr2.length) {
                    break;
                }
                zzsy.zzb zzbVar = zzbVarArr2[i3];
                if (zzbVar != null) {
                    i2 += zzdrb.zzc(11, zzbVar);
                }
                i3++;
            }
            a = i2;
        }
        zztw[] zztwVarArr = this.zzcad;
        if (zztwVarArr != null && zztwVarArr.length > 0) {
            while (true) {
                zztw[] zztwVarArr2 = this.zzcad;
                if (i >= zztwVarArr2.length) {
                    break;
                }
                zztw zztwVar = zztwVarArr2[i];
                if (zztwVar != null) {
                    a += zzdvo.zzb(17, zztwVar);
                }
                i++;
            }
        }
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        Integer num = this.zzbzt;
        if (num != null) {
            zzdvoVar.zzab(7, num.intValue());
        }
        zztp zztpVar = this.zzbzw;
        if (zztpVar != null) {
            zzdvoVar.zza(10, zztpVar);
        }
        zzsy.zzb[] zzbVarArr = this.zzbzx;
        int i = 0;
        if (zzbVarArr != null && zzbVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzsy.zzb[] zzbVarArr2 = this.zzbzx;
                if (i2 >= zzbVarArr2.length) {
                    break;
                }
                zzsy.zzb zzbVar = zzbVarArr2[i2];
                if (zzbVar != null) {
                    zzdvoVar.zze(11, zzbVar);
                }
                i2++;
            }
        }
        zztw[] zztwVarArr = this.zzcad;
        if (zztwVarArr != null && zztwVarArr.length > 0) {
            while (true) {
                zztw[] zztwVarArr2 = this.zzcad;
                if (i >= zztwVarArr2.length) {
                    break;
                }
                zztw zztwVar = zztwVarArr2[i];
                if (zztwVar != null) {
                    zzdvoVar.zza(17, zztwVar);
                }
                i++;
            }
        }
        super.zza(zzdvoVar);
    }
}
