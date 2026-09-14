package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcsh implements zzdxg<zzcsf> {
    private final zzdxp<zzdhd> zzfcv;

    private zzcsh(zzdxp<zzdhd> zzdxpVar) {
        this.zzfcv = zzdxpVar;
    }

    public static zzcsh zzak(zzdxp<zzdhd> zzdxpVar) {
        return new zzcsh(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcsf(this.zzfcv.get());
    }
}
