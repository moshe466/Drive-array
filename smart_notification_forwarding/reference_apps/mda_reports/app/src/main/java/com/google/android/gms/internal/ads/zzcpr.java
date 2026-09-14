package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcpr implements zzdgf<zzaqk, zzcps> {
    private Executor executor;
    private zzcgm zzgef;

    public zzcpr(Executor executor, zzcgm zzcgmVar) {
        this.executor = executor;
        this.zzgef = zzcgmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final /* synthetic */ zzdhe<zzcps> zzf(zzaqk zzaqkVar) {
        final zzaqk zzaqkVar2 = zzaqkVar;
        return zzdgs.zzb(this.zzgef.zzg(zzaqkVar2), new zzdgf(zzaqkVar2) { // from class: com.google.android.gms.internal.ads.zzcpq
            private final zzaqk zzfhx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhx = zzaqkVar2;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return zzdgs.zzaj(new zzcps(new JsonReader(new InputStreamReader((InputStream) obj))).a(this.zzfhx.zzdlu));
            }
        }, this.executor);
    }
}
