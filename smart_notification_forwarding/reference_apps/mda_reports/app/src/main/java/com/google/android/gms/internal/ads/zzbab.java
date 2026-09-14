package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbab implements Runnable {
    private final /* synthetic */ zzazx zzdxn;
    private final /* synthetic */ String zzdxo;
    private final /* synthetic */ String zzdxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbab(zzazx zzazxVar, String str, String str2) {
        this.zzdxn = zzazxVar;
        this.zzdxo = str;
        this.zzdxp = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbah zzbahVar;
        zzbah zzbahVar2;
        zzbahVar = this.zzdxn.zzdxm;
        if (zzbahVar != null) {
            zzbahVar2 = this.zzdxn.zzdxm;
            zzbahVar2.zzm(this.zzdxo, this.zzdxp);
        }
    }
}
