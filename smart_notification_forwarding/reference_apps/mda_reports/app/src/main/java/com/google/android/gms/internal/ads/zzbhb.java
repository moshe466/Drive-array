package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class zzbhb implements zzcww {
    private final /* synthetic */ zzbgr zzerr;
    private Context zzewj;
    private String zzewk;

    private zzbhb(zzbgr zzbgrVar) {
        this.zzerr = zzbgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcww
    public final zzcwx zzaeb() {
        zzdxm.zza(this.zzewj, (Class<Context>) Context.class);
        zzdxm.zza(this.zzewk, (Class<String>) String.class);
        return new zzbha(this.zzerr, this.zzewj, this.zzewk);
    }

    @Override // com.google.android.gms.internal.ads.zzcww
    public final /* synthetic */ zzcww zzbt(Context context) {
        this.zzewj = (Context) zzdxm.checkNotNull(context);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcww
    public final /* synthetic */ zzcww zzfq(String str) {
        this.zzewk = (String) zzdxm.checkNotNull(str);
        return this;
    }
}
