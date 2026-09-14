package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjr implements zzdxg<JSONObject> {
    private final zzdxp<zzczl> zzfda;

    private zzbjr(zzdxp<zzczl> zzdxpVar) {
        this.zzfda = zzdxpVar;
    }

    public static zzbjr zzc(zzdxp<zzczl> zzdxpVar) {
        return new zzbjr(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return zzbjs.zza(this.zzfda.get());
    }
}
