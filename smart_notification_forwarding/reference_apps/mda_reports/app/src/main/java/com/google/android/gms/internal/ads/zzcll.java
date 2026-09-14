package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzcll extends zzclk<zzbtu> {
    private final zzbrm zzers;
    private final zzcns zzexc;
    private final zzbfx zzfzz;
    private final zzbod.zza zzgaa;

    public zzcll(zzbfx zzbfxVar, zzbod.zza zzaVar, zzcns zzcnsVar, zzbrm zzbrmVar) {
        this.zzfzz = zzbfxVar;
        this.zzgaa = zzaVar;
        this.zzexc = zzcnsVar;
        this.zzers = zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclk
    protected final zzdhe<zzbtu> a(zzczu zzczuVar, Bundle bundle) {
        return this.zzfzz.zzack().zzd(this.zzgaa.zza(zzczuVar).zze(bundle).zzahh()).zzd(this.zzers).zzb(this.zzexc).zzaek().zzadc().zzaha();
    }
}
