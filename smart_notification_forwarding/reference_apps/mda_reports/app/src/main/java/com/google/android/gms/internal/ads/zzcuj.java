package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcuj implements zzdxg<zzcuh> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdhd> zzfcv;

    public zzcuj(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzejv = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcuh(this.zzfcv.get(), this.zzejv.get());
    }
}
