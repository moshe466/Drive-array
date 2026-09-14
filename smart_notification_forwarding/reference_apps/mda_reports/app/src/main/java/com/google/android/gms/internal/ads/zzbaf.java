package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbaf implements Runnable {
    private final /* synthetic */ zzazx zzdxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbaf(zzazx zzazxVar) {
        this.zzdxn = zzazxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbah zzbahVar;
        zzbah zzbahVar2;
        zzbahVar = this.zzdxn.zzdxm;
        if (zzbahVar != null) {
            zzbahVar2 = this.zzdxn.zzdxm;
            zzbahVar2.zzxu();
        }
    }
}
