package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class zzbhl implements zzczc {
    private final /* synthetic */ zzbgr zzerr;
    private Context zzewj;
    private String zzewk;

    private zzbhl(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final zzczd zzaer() {
        zzdxm.zza(this.zzewj, (Class<Context>) Context.class);
        return new zzbhk(this.zzerr, this.zzewj, this.zzewk);
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final /* synthetic */ zzczc zzbu(Context context) {
        this.zzewj = (Context) zzdxm.checkNotNull(context);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final /* synthetic */ zzczc zzfr(String str) {
        this.zzewk = str;
        return this;
    }
}
