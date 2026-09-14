package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcyy implements zzcoz<zzcbb> {
    private final /* synthetic */ zzcyz zzgkv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyy(zzcyz zzcyzVar) {
        this.zzgkv = zzcyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final /* synthetic */ void onSuccess(zzcbb zzcbbVar) {
        zzcbb zzcbbVar2;
        zzcbb zzcbbVar3 = zzcbbVar;
        synchronized (this.zzgkv) {
            this.zzgkv.zzgky = zzcbbVar3;
            zzcbbVar2 = this.zzgkv.zzgky;
            zzcbbVar2.zzagf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final void zzamx() {
        synchronized (this.zzgkv) {
            this.zzgkv.zzgky = null;
        }
    }
}
