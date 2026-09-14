package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbcx extends zzbcn {
    public zzbcx(zzbaz zzbazVar) {
        super(zzbazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final boolean zzfi(String str) {
        zzbaz zzbazVar = this.c.get();
        if (zzbazVar != null) {
            zzbazVar.zza(a(str), this);
        }
        zzayu.zzez("VideoStreamNoopCache is doing nothing.");
        zza(str, a(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
