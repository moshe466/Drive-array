package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbac implements Runnable {
    private final /* synthetic */ zzazx zzdxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbac(zzazx zzazxVar) {
        this.zzdxn = zzazxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbah zzbahVar;
        zzbah zzbahVar2;
        zzbah zzbahVar3;
        zzbahVar = this.zzdxn.zzdxm;
        if (zzbahVar != null) {
            zzbahVar2 = this.zzdxn.zzdxm;
            zzbahVar2.onPaused();
            zzbahVar3 = this.zzdxn.zzdxm;
            zzbahVar3.zzxw();
        }
    }
}
