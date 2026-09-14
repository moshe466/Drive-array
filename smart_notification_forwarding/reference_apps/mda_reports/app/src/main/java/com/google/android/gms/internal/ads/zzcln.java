package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzcln extends zzclk<zzcbb> {
    private final zzbrm zzers;
    private final zzbfx zzfzz;
    private final zzbod.zza zzgaa;

    public zzcln(zzbfx zzbfxVar, zzbod.zza zzaVar, zzbrm zzbrmVar) {
        this.zzfzz = zzbfxVar;
        this.zzgaa = zzaVar;
        this.zzers = zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclk
    protected final zzdhe<zzcbb> a(zzczu zzczuVar, Bundle bundle) {
        return this.zzfzz.zzacm().zze(this.zzgaa.zza(zzczuVar).zze(bundle).zzahh()).zze(this.zzers).zzaes().zzadc().zzaha();
    }
}
