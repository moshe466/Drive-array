package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvx;

/* loaded from: classes.dex */
public final class zzdwj extends zzdvq<zzdwj> {
    public zzdvx.zzb.zzf.EnumC0021zzb zzhyi = null;
    public String mimeType = null;
    public byte[] zzhyj = null;

    public zzdwj() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        zzdvx.zzb.zzf.EnumC0021zzb enumC0021zzb = this.zzhyi;
        if (enumC0021zzb != null && enumC0021zzb != null) {
            a += zzdvo.zzaf(1, enumC0021zzb.zzae());
        }
        String str = this.mimeType;
        if (str != null) {
            a += zzdvo.zzg(2, str);
        }
        byte[] bArr = this.zzhyj;
        return bArr != null ? a + zzdvo.zzfz(3) + zzdvo.zzgh(bArr.length) + bArr.length : a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        zzdvx.zzb.zzf.EnumC0021zzb enumC0021zzb = this.zzhyi;
        if (enumC0021zzb != null && enumC0021zzb != null) {
            zzdvoVar.zzab(1, enumC0021zzb.zzae());
        }
        String str = this.mimeType;
        if (str != null) {
            zzdvoVar.zzf(2, str);
        }
        byte[] bArr = this.zzhyj;
        if (bArr != null) {
            zzdvoVar.zza(3, bArr);
        }
        super.zza(zzdvoVar);
    }
}
