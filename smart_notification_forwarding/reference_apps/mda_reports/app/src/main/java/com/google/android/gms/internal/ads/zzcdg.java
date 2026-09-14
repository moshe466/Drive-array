package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcdg implements zzdxg<Set<zzbsu<zzdcx>>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<String> zzfsh;
    private final zzdxp<Map<zzdco, zzcdh>> zzfsi;

    public zzcdg(zzdxp<String> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<Executor> zzdxpVar3, zzdxp<Map<zzdco, zzcdh>> zzdxpVar4) {
        this.zzfsh = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfcv = zzdxpVar3;
        this.zzfsi = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        Set emptySet;
        final String str = this.zzfsh.get();
        Context context = this.zzejv.get();
        Executor executor = this.zzfcv.get();
        Map<zzdco, zzcdh> map = this.zzfsi.get();
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnw)).booleanValue()) {
            zzsm zzsmVar = new zzsm(new zzsr(context));
            zzsmVar.zza(new zzsp(str) { // from class: com.google.android.gms.internal.ads.zzcdi
                private final String zzcyz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcyz = str;
                }

                @Override // com.google.android.gms.internal.ads.zzsp
                public final void zza(zztu zztuVar) {
                    zztuVar.zzcaq = this.zzcyz;
                }
            });
            emptySet = Collections.singleton(new zzbsu(new zzcdf(zzsmVar, map), executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzdxm.zza(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
