package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbad implements Runnable {
    private final /* synthetic */ zzazx zzdxn;
    private final /* synthetic */ int zzdxq;
    private final /* synthetic */ int zzdxr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbad(zzazx zzazxVar, int i, int i2) {
        this.zzdxn = zzazxVar;
        this.zzdxq = i;
        this.zzdxr = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbah zzbahVar;
        zzbah zzbahVar2;
        zzbahVar = this.zzdxn.zzdxm;
        if (zzbahVar != null) {
            zzbahVar2 = this.zzdxn.zzdxm;
            zzbahVar2.zzk(this.zzdxq, this.zzdxr);
        }
    }
}
