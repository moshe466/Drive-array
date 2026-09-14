package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzctz implements zzdxg<zzctx> {
    private final zzdxp<zzcxw> zzfjl;

    private zzctz(zzdxp<zzcxw> zzdxpVar) {
        this.zzfjl = zzdxpVar;
    }

    public static zzctz zzal(zzdxp<zzcxw> zzdxpVar) {
        return new zzctz(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzctx(this.zzfjl.get());
    }
}
