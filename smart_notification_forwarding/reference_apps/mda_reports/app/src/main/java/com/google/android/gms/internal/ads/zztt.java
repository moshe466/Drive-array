package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zztt extends zzdvq<zztt> {
    public Integer zzcam = null;
    public Integer zzcan = null;
    public Integer zzcao = null;

    public zztt() {
        this.b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final int a() {
        int a = super.a();
        Integer num = this.zzcam;
        if (num != null) {
            a += zzdvo.zzaf(1, num.intValue());
        }
        Integer num2 = this.zzcan;
        if (num2 != null) {
            a += zzdvo.zzaf(2, num2.intValue());
        }
        Integer num3 = this.zzcao;
        return num3 != null ? a + zzdvo.zzaf(3, num3.intValue()) : a;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq, com.google.android.gms.internal.ads.zzdvt
    public final void zza(zzdvo zzdvoVar) {
        Integer num = this.zzcam;
        if (num != null) {
            zzdvoVar.zzab(1, num.intValue());
        }
        Integer num2 = this.zzcan;
        if (num2 != null) {
            zzdvoVar.zzab(2, num2.intValue());
        }
        Integer num3 = this.zzcao;
        if (num3 != null) {
            zzdvoVar.zzab(3, num3.intValue());
        }
        super.zza(zzdvoVar);
    }
}
