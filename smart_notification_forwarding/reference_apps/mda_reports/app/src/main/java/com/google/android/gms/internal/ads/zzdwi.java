package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvx;

/* loaded from: classes.dex */
public final class zzdwi extends zzdvq<zzdwi> {
    private String[] zzhya;
    private String zzhyb;
    private Boolean zzhyc;
    private Boolean zzhyd;
    private byte[] zzhye;
    public zzdvx.zzb.zzi zzhyf;
    public String[] zzhyg;
    public String[] zzhyh;
    public zzdvx.zzb.zzg zzhxr = null;
    private zzdvx.zza.zzc zzhxs = null;
    public String url = null;
    public String zzhxt = null;
    private String zzhxu = null;
    public zzdvx.zzb.C0018zzb zzhxv = null;
    public zzdwm[] zzhxw = zzdwm.zzbdk();
    public String zzhxx = null;
    public zzdwj zzhxy = null;
    private Boolean zzhxz = null;

    public zzdwi() {
        String[] strArr = zzdvy.zzhuc;
        this.zzhya = strArr;
        this.zzhyb = null;
        this.zzhyc = null;
        this.zzhyd = null;
        this.zzhye = null;
        this.zzhyf = null;
        this.zzhyg = strArr;
        this.zzhyh = strArr;
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        String str = this.url;
        if (str != null) {
            a += zzdvo.zzg(1, str);
        }
        String str2 = this.zzhxt;
        if (str2 != null) {
            a += zzdvo.zzg(2, str2);
        }
        zzdwm[] zzdwmVarArr = this.zzhxw;
        int i = 0;
        if (zzdwmVarArr != null && zzdwmVarArr.length > 0) {
            int i2 = a;
            int i3 = 0;
            while (true) {
                zzdwm[] zzdwmVarArr2 = this.zzhxw;
                if (i3 >= zzdwmVarArr2.length) {
                    break;
                }
                zzdwm zzdwmVar = zzdwmVarArr2[i3];
                if (zzdwmVar != null) {
                    i2 += zzdvo.zzb(4, zzdwmVar);
                }
                i3++;
            }
            a = i2;
        }
        String[] strArr = this.zzhya;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.zzhya;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    i6++;
                    i5 += zzdvo.zzhh(str3);
                }
                i4++;
            }
            a = a + i5 + (i6 * 1);
        }
        zzdvx.zzb.zzg zzgVar = this.zzhxr;
        if (zzgVar != null && zzgVar != null) {
            a += zzdvo.zzaf(10, zzgVar.zzae());
        }
        zzdvx.zzb.C0018zzb c0018zzb = this.zzhxv;
        if (c0018zzb != null) {
            a += zzdrb.zzc(12, c0018zzb);
        }
        String str4 = this.zzhxx;
        if (str4 != null) {
            a += zzdvo.zzg(13, str4);
        }
        zzdwj zzdwjVar = this.zzhxy;
        if (zzdwjVar != null) {
            a += zzdvo.zzb(14, zzdwjVar);
        }
        zzdvx.zzb.zzi zziVar = this.zzhyf;
        if (zziVar != null) {
            a += zzdrb.zzc(17, zziVar);
        }
        String[] strArr3 = this.zzhyg;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.zzhyg;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i7];
                if (str5 != null) {
                    i9++;
                    i8 += zzdvo.zzhh(str5);
                }
                i7++;
            }
            a = a + i8 + (i9 * 2);
        }
        String[] strArr5 = this.zzhyh;
        if (strArr5 == null || strArr5.length <= 0) {
            return a;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr6 = this.zzhyh;
            if (i >= strArr6.length) {
                return a + i10 + (i11 * 2);
            }
            String str6 = strArr6[i];
            if (str6 != null) {
                i11++;
                i10 += zzdvo.zzhh(str6);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        String str = this.url;
        if (str != null) {
            zzdvoVar.zzf(1, str);
        }
        String str2 = this.zzhxt;
        if (str2 != null) {
            zzdvoVar.zzf(2, str2);
        }
        zzdwm[] zzdwmVarArr = this.zzhxw;
        int i = 0;
        if (zzdwmVarArr != null && zzdwmVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzdwm[] zzdwmVarArr2 = this.zzhxw;
                if (i2 >= zzdwmVarArr2.length) {
                    break;
                }
                zzdwm zzdwmVar = zzdwmVarArr2[i2];
                if (zzdwmVar != null) {
                    zzdvoVar.zza(4, zzdwmVar);
                }
                i2++;
            }
        }
        String[] strArr = this.zzhya;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.zzhya;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i3];
                if (str3 != null) {
                    zzdvoVar.zzf(6, str3);
                }
                i3++;
            }
        }
        zzdvx.zzb.zzg zzgVar = this.zzhxr;
        if (zzgVar != null && zzgVar != null) {
            zzdvoVar.zzab(10, zzgVar.zzae());
        }
        zzdvx.zzb.C0018zzb c0018zzb = this.zzhxv;
        if (c0018zzb != null) {
            zzdvoVar.zze(12, c0018zzb);
        }
        String str4 = this.zzhxx;
        if (str4 != null) {
            zzdvoVar.zzf(13, str4);
        }
        zzdwj zzdwjVar = this.zzhxy;
        if (zzdwjVar != null) {
            zzdvoVar.zza(14, zzdwjVar);
        }
        zzdvx.zzb.zzi zziVar = this.zzhyf;
        if (zziVar != null) {
            zzdvoVar.zze(17, zziVar);
        }
        String[] strArr3 = this.zzhyg;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.zzhyg;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i4];
                if (str5 != null) {
                    zzdvoVar.zzf(20, str5);
                }
                i4++;
            }
        }
        String[] strArr5 = this.zzhyh;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzhyh;
                if (i >= strArr6.length) {
                    break;
                }
                String str6 = strArr6[i];
                if (str6 != null) {
                    zzdvoVar.zzf(21, str6);
                }
                i++;
            }
        }
        super.zza(zzdvoVar);
    }
}
