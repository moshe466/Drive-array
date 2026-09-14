package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsy;

/* loaded from: classes.dex */
public final class zzts extends zzdvq<zzts> {
    public String zzcae = null;
    private zzsy.zzo zzcaf = null;
    private Integer zzcag = null;
    public zztt zzcah = null;
    private Integer zzcai = null;
    private zzte zzcaj = null;
    private zzte zzcak = null;
    private zzte zzcal = null;

    public zzts() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        String str = this.zzcae;
        if (str != null) {
            a += zzdvo.zzg(1, str);
        }
        zztt zzttVar = this.zzcah;
        return zzttVar != null ? a + zzdvo.zzb(4, zzttVar) : a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        String str = this.zzcae;
        if (str != null) {
            zzdvoVar.zzf(1, str);
        }
        zztt zzttVar = this.zzcah;
        if (zzttVar != null) {
            zzdvoVar.zza(4, zzttVar);
        }
        super.zza(zzdvoVar);
    }
}
