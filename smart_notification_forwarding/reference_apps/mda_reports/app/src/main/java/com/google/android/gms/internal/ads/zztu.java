package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsy;

/* loaded from: classes.dex */
public final class zztu extends zzdvq<zztu> {
    private Integer zzcap = null;
    public String zzcaq = null;
    private Integer zzcar = null;
    private zzte zzcas = null;
    private zztt zzcat = null;
    public long[] zzcau = zzdvy.zzhty;
    public zzts zzcav = null;
    private zztr zzcaw = null;
    private zzsy.zzh zzcax = null;
    public zztq zzcay = null;
    public zzsy.zzj zzcaz = null;
    public zzsy.zzw zzcba = null;
    public zzsy.zza zzcbb = null;

    public zztu() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        long[] jArr;
        int a = super.a();
        String str = this.zzcaq;
        if (str != null) {
            a += zzdvo.zzg(10, str);
        }
        long[] jArr2 = this.zzcau;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                jArr = this.zzcau;
                if (i >= jArr.length) {
                    break;
                }
                long j = jArr[i];
                i2 += ((-128) & j) == 0 ? 1 : ((-16384) & j) == 0 ? 2 : ((-2097152) & j) == 0 ? 3 : ((-268435456) & j) == 0 ? 4 : ((-34359738368L) & j) == 0 ? 5 : ((-4398046511104L) & j) == 0 ? 6 : ((-562949953421312L) & j) == 0 ? 7 : ((-72057594037927936L) & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
                i++;
            }
            a = a + i2 + (jArr.length * 1);
        }
        zzts zztsVar = this.zzcav;
        if (zztsVar != null) {
            a += zzdvo.zzb(15, zztsVar);
        }
        zztq zztqVar = this.zzcay;
        if (zztqVar != null) {
            a += zzdvo.zzb(18, zztqVar);
        }
        zzsy.zzj zzjVar = this.zzcaz;
        if (zzjVar != null) {
            a += zzdrb.zzc(19, zzjVar);
        }
        zzsy.zzw zzwVar = this.zzcba;
        if (zzwVar != null) {
            a += zzdrb.zzc(20, zzwVar);
        }
        zzsy.zza zzaVar = this.zzcbb;
        return zzaVar != null ? a + zzdrb.zzc(21, zzaVar) : a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        String str = this.zzcaq;
        if (str != null) {
            zzdvoVar.zzf(10, str);
        }
        long[] jArr = this.zzcau;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.zzcau;
                if (i >= jArr2.length) {
                    break;
                }
                long j = jArr2[i];
                zzdvoVar.zzaa(14, 0);
                zzdvoVar.zzfs(j);
                i++;
            }
        }
        zzts zztsVar = this.zzcav;
        if (zztsVar != null) {
            zzdvoVar.zza(15, zztsVar);
        }
        zztq zztqVar = this.zzcay;
        if (zztqVar != null) {
            zzdvoVar.zza(18, zztqVar);
        }
        zzsy.zzj zzjVar = this.zzcaz;
        if (zzjVar != null) {
            zzdvoVar.zze(19, zzjVar);
        }
        zzsy.zzw zzwVar = this.zzcba;
        if (zzwVar != null) {
            zzdvoVar.zze(20, zzwVar);
        }
        zzsy.zza zzaVar = this.zzcbb;
        if (zzaVar != null) {
            zzdvoVar.zze(21, zzaVar);
        }
        super.zza(zzdvoVar);
    }
}
