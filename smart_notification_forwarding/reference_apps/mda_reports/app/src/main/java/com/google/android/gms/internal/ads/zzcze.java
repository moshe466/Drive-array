package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcze implements zzcoz<zzcbb> {
    private final /* synthetic */ zzczf zzgla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcze(zzczf zzczfVar) {
        this.zzgla = zzczfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final /* synthetic */ void onSuccess(zzcbb zzcbbVar) {
        zzcbb zzcbbVar2;
        zzcbb zzcbbVar3 = zzcbbVar;
        synchronized (this.zzgla) {
            this.zzgla.zzgky = zzcbbVar3;
            zzcbbVar2 = this.zzgla.zzgky;
            zzcbbVar2.zzagf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final void zzamx() {
        synchronized (this.zzgla) {
            this.zzgla.zzgky = null;
        }
    }
}
