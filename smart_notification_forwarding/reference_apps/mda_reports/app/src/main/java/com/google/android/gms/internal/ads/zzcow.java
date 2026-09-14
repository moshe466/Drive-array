package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcow implements zzcoz<zzbmd> {
    private final /* synthetic */ zzcot zzgdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcow(zzcot zzcotVar) {
        this.zzgdp = zzcotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final /* synthetic */ void onSuccess(zzbmd zzbmdVar) {
        zzbmd zzbmdVar2 = zzbmdVar;
        synchronized (this.zzgdp) {
            zzcot.a(this.zzgdp, false);
            this.zzgdp.zzgdj = zzbmdVar2.zzags();
            zzbmdVar2.zzagf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final void zzamx() {
        synchronized (this.zzgdp) {
            zzcot.a(this.zzgdp, false);
        }
    }
}
