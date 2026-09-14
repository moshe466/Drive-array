package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbwx implements zzdxg<zzbwv> {
    private final zzdxp<JSONObject> zzety;
    private final zzdxp<zzczl> zzfda;

    public zzbwx(zzdxp<zzczl> zzdxpVar, zzdxp<JSONObject> zzdxpVar2) {
        this.zzfda = zzdxpVar;
        this.zzety = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbwv(this.zzfda.get(), this.zzety.get());
    }
}
