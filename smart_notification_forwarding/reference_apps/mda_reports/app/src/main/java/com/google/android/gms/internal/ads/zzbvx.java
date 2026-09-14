package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbvx implements zzdxg<JSONObject> {
    private final zzdxp<zzbww> zzeti;
    private final zzbvy zzfla;

    public zzbvx(zzbvy zzbvyVar, zzdxp<zzbww> zzdxpVar) {
        this.zzfla = zzbvyVar;
        this.zzeti = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzeti.get().zzajl();
    }
}
