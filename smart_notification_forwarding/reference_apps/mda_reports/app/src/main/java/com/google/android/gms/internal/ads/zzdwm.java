package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvx;

/* loaded from: classes.dex */
public final class zzdwm extends zzdvq<zzdwm> {
    private static volatile zzdwm[] zzhyx;
    public Integer zzhyy = null;
    public String url = null;
    public zzdwk zzhyz = null;
    private zzdvx.zzb.zze zzhza = null;
    private Integer zzhzb = null;
    private int[] zzhzc = zzdvy.zzhow;
    private String zzhzd = null;
    public zzdvx.zzb.zzh.zza zzhze = null;
    public String[] zzhzf = zzdvy.zzhuc;

    public zzdwm() {
        this.b = null;
        this.a = -1;
    }

    public static zzdwm[] zzbdk() {
        if (zzhyx == null) {
            synchronized (zzdvu.zzhtt) {
                if (zzhyx == null) {
                    zzhyx = new zzdwm[0];
                }
            }
        }
        return zzhyx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int[] iArr;
        int a = super.a() + zzdvo.zzaf(1, this.zzhyy.intValue());
        String str = this.url;
        if (str != null) {
            a += zzdvo.zzg(2, str);
        }
        zzdwk zzdwkVar = this.zzhyz;
        if (zzdwkVar != null) {
            a += zzdvo.zzb(3, zzdwkVar);
        }
        int[] iArr2 = this.zzhzc;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = this.zzhzc;
                if (i2 >= iArr.length) {
                    break;
                }
                i3 += zzdvo.zzga(iArr[i2]);
                i2++;
            }
            a = a + i3 + (iArr.length * 1);
        }
        zzdvx.zzb.zzh.zza zzaVar = this.zzhze;
        if (zzaVar != null && zzaVar != null) {
            a += zzdvo.zzaf(8, zzaVar.zzae());
        }
        String[] strArr = this.zzhzf;
        if (strArr == null || strArr.length <= 0) {
            return a;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.zzhzf;
            if (i >= strArr2.length) {
                return a + i4 + (i5 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i5++;
                i4 += zzdvo.zzhh(str2);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        zzdvoVar.zzab(1, this.zzhyy.intValue());
        String str = this.url;
        if (str != null) {
            zzdvoVar.zzf(2, str);
        }
        zzdwk zzdwkVar = this.zzhyz;
        if (zzdwkVar != null) {
            zzdvoVar.zza(3, zzdwkVar);
        }
        int[] iArr = this.zzhzc;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.zzhzc;
                if (i2 >= iArr2.length) {
                    break;
                }
                zzdvoVar.zzab(6, iArr2[i2]);
                i2++;
            }
        }
        zzdvx.zzb.zzh.zza zzaVar = this.zzhze;
        if (zzaVar != null && zzaVar != null) {
            zzdvoVar.zzab(8, zzaVar.zzae());
        }
        String[] strArr = this.zzhzf;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.zzhzf;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzdvoVar.zzf(9, str2);
                }
                i++;
            }
        }
        super.zza(zzdvoVar);
    }
}
