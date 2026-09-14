package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvx;

/* loaded from: classes.dex */
public final class zzdwk extends zzdvq<zzdwk> {
    private zzdvx.zzb.zzd.C0019zzb zzhyk = null;
    public zzdvx.zzb.zzc[] zzhyl = new zzdvx.zzb.zzc[0];
    private byte[] zzhym = null;
    private byte[] zzhyn = null;
    private Integer zzhyo = null;

    public zzdwk() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        zzdvx.zzb.zzc[] zzcVarArr = this.zzhyl;
        if (zzcVarArr != null && zzcVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzdvx.zzb.zzc[] zzcVarArr2 = this.zzhyl;
                if (i >= zzcVarArr2.length) {
                    break;
                }
                zzdvx.zzb.zzc zzcVar = zzcVarArr2[i];
                if (zzcVar != null) {
                    a += zzdrb.zzc(2, zzcVar);
                }
                i++;
            }
        }
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        zzdvx.zzb.zzc[] zzcVarArr = this.zzhyl;
        if (zzcVarArr != null && zzcVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzdvx.zzb.zzc[] zzcVarArr2 = this.zzhyl;
                if (i >= zzcVarArr2.length) {
                    break;
                }
                zzdvx.zzb.zzc zzcVar = zzcVarArr2[i];
                if (zzcVar != null) {
                    zzdvoVar.zze(2, zzcVar);
                }
                i++;
            }
        }
        super.zza(zzdvoVar);
    }
}
