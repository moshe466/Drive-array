package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbwa implements zzdxg<JSONObject> {
    private final zzbvy zzfla;

    public zzbwa(zzbvy zzbvyVar) {
        this.zzfla = zzbvyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (JSONObject) zzdxm.zza(this.zzfla.zzais(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
