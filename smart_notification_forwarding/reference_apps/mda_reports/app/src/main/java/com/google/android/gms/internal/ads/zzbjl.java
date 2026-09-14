package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjl implements zzdxg<Set<zzbsu<zzbph>>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbjd> zzfdd;
    private final zzdxp<JSONObject> zzfde;

    private zzbjl(zzdxp<zzbjd> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<JSONObject> zzdxpVar3) {
        this.zzfdd = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzfde = zzdxpVar3;
    }

    public static zzbjl zzc(zzdxp<zzbjd> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<JSONObject> zzdxpVar3) {
        return new zzbjl(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfde.get() == null ? Collections.emptySet() : Collections.singleton(new zzbsu(this.zzfdd.get(), this.zzfcv.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
